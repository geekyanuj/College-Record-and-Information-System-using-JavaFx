
package Controller_FXMLController;

import Model_Beans.Department;
import Model_Services.AcademicManagementServicesImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class ManageDepartmentBoardFXMLController implements Initializable {

    @FXML
    private JFXTextField deptNameTF;
    @FXML
    private Button backBtn;
    
    
    @FXML
    private JFXTextField depHodTF;
    @FXML
    private JFXTextField deptCapacityTF;
    @FXML
    private TableView<Object> deptTableView;
    @FXML
    private TableColumn<Department, Integer> deptIdCol;
    @FXML
    private TableColumn<Department, String> deptNameCol;
    @FXML
    private TableColumn<Department, String> deptHodCol;
    @FXML
    private TableColumn<Department, Integer> deptCapacityCol;

    AcademicManagementServicesImpl academicManagementServicesImpl=new AcademicManagementServicesImpl();
    Department department;
    
    String gusername;
    @FXML
    private JFXTextField deptNameTFU;
    @FXML
    private JFXTextField depHodTFU;
    @FXML
    private JFXTextField deptCapacityTFU;
    @FXML
    private TextField deptIdTFU;
    @FXML
    private BorderPane bp;
    @FXML
    private JFXButton submitBtn;
    @FXML
    private BorderPane displayTabBP;
    @FXML
    private BorderPane bp1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       academicManagementServicesImpl=new AcademicManagementServicesImpl();
       department=new Department();
       
       deptIdCol.setCellValueFactory(new PropertyValueFactory<>("departmentId"));
       deptNameCol.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
       deptHodCol.setCellValueFactory(new PropertyValueFactory<>("departmentHod"));
       deptCapacityCol.setCellValueFactory(new PropertyValueFactory<>("departmentCapacity"));
       
       loadAndRefreshDepartmentsInTableView();
       
    }    

    @FXML
    private void submit(ActionEvent event) {
        if(deptNameTF.getText().isEmpty()){
            Notifications.create().position(Pos.TOP_RIGHT).title("Department Name is required*").showError();
        }else{
            
            String departmentName=deptNameTF.getText();
            String departmentHod=depHodTF.getText();
            int departmentCapacity=Integer.parseInt(deptCapacityTF.getText());
            department.setDepartmentName(departmentName);
            department.setDepartmentHod(departmentHod);
            department.setDepartmentCapacity(departmentCapacity);
            int deptId=academicManagementServicesImpl.addDepartment(department);
            if(deptId>0){
                Notifications.create().position(Pos.TOP_RIGHT).title("Department is added Successfully").showInformation();
                JOptionPane.showMessageDialog(null, "Department Id is "+deptId);
            }else{
                Notifications.create().position(Pos.TOP_RIGHT).title("Not Added").showError();
            }
        }
    }



    @FXML
    private void backToDashboard(ActionEvent event) {
        int flag=JOptionPane.showConfirmDialog(null, "Do you want to go back? All unsaved data will be lost...");
        if(flag==0){
            Stage stage=(Stage)bp.getScene().getWindow();
            stage.close();
            stage=(Stage) stage.getUserData();
            stage.setMaximized(true);
            stage.show();
             int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
             int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
            try{
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AdminDashboardFXML.fxml"));
                    Parent root=loader.load();
                    AdminDashboardFXMLController adminDashboardFXMLController=loader.getController();
                    if(gusername!=null){
                        adminDashboardFXMLController.setUserDetails(gusername);
                    }
                    Scene scene = new Scene(root,screenWidth,screenHeight);
                    
                    stage.setScene(scene);
                    stage.setTitle("Admin - P.K. Roy Memorial College,Dhanbad  Smart-Ed College ERP v1.1.1");
                    stage.setX(0);
                    stage.setY(0);
                   
          
                    stage.show();
                    
                    
                }catch (IOException ex){
                    System.out.println(ex);
                    ex.printStackTrace();
                }
        }
    }




    @FXML
    private void update(ActionEvent event) {
        if(deptIdTFU.getText().isEmpty()){
            Notifications.create().position(Pos.TOP_RIGHT).title("Please enter Departement Id first").showError();
        }else{
            if(deptNameTFU.getText().isEmpty()){
                Notifications.create().position(Pos.TOP_RIGHT).title("Please enter Departement Name first").showError();
            }else{
                if(depHodTFU.getText().isEmpty()){
                    Notifications.create().position(Pos.TOP_RIGHT).title("Please enter Departement HOD first").showError();
                }else{
                    if(deptCapacityTFU.getText().isEmpty()){
                        Notifications.create().position(Pos.TOP_RIGHT).title("Please enter Departement Capacity first").showError();
                    }else{
                        department =new Department(Integer.parseInt(deptIdTFU.getText()), deptNameTFU.getText(), depHodTFU.getText(), Integer.parseInt(deptCapacityTFU.getText()));
                        int x=academicManagementServicesImpl.updateDepartment(department);
                        if(x>0){
                            Notifications.create().position(Pos.TOP_RIGHT).title("Department Updated Successfully").showInformation();
                        }else{
                            Notifications.create().position(Pos.TOP_RIGHT).title("Not Updated").showInformation();
                        }
                    }
                }
            }
        }
    }

    @FXML
    private void findDeptUsingStudentId(ActionEvent event) {
        if(deptIdTFU.getText().isEmpty()){
            Notifications.create().position(Pos.TOP_RIGHT).title("Please enter Departement Id first").showError();
        }else{
            int deptId=Integer.parseInt(deptIdTFU.getText().trim());
            department=academicManagementServicesImpl.findDepartmentUsingDeptId(deptId);
            if(department!=null && department.getDepartmentId()==deptId){
                deptNameTFU.setText(department.getDepartmentName());
                depHodTFU.setText(department.getDepartmentHod());
                deptCapacityTFU.setText(department.getDepartmentCapacity()+"");
            }else{
                Notifications.create().position(Pos.TOP_RIGHT).title("Department not found...").showError();
            }      
        }
    }
    
    @FXML
    private void onTabChange(Event event) {
        loadAndRefreshDepartmentsInTableView();
    }
    
    void loadAndRefreshDepartmentsInTableView(){
        List<Department> departmentList=new ArrayList<>();
       departmentList=academicManagementServicesImpl.showAllDepartments();
       deptTableView.getItems().clear();
       for(int i=0;i<departmentList.size();i++){
            Department department1=departmentList.get(i);
            deptTableView.getItems().add(i,new Department(department1.getDepartmentId(), department1.getDepartmentName(), department1.getDepartmentHod(), department1.getDepartmentCapacity()));
       }      
    }
    
    
    void fetchUserDetails(String username) {
      gusername=username;
    }

    
}
