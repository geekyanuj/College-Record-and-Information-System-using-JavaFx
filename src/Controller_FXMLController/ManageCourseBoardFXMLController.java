
package Controller_FXMLController;

import Model_Beans.Course;
import Model_Beans.Subject;
import Model_Services.AcademicManagementServicesImpl;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class ManageCourseBoardFXMLController implements Initializable {

    @FXML
    private TableView<Object> courseDispalyTV;
    @FXML
    private TableColumn<Course, String> courseIdCol;
    @FXML
    private TableColumn<Course, String> courseNameCol;
    @FXML
    private TableColumn<Course, String> courseTypeCol;
    @FXML
    private TableColumn<Course, String> noOfSemesterCol;
    @FXML
    private TableColumn<Course, String> courseDurationCol;
    @FXML
    private Button backBtn;
    @FXML
    private Label courseCountLabel;
    @FXML
    private VBox manageCourseContainer;
    @FXML
    private TextField courseIdTF;
    @FXML
    private TextField courseNameTF;
    @FXML
    private ComboBox<String> courseTypeCB;
    @FXML
    private TextField noOfSemesterTF;
    @FXML
    private ComboBox<String> courseDurationCB;
    @FXML
    private Button addCourseBtn;

    AcademicManagementServicesImpl academicManagementServicesImpl;
    
    String courseTypes[]={"Regular","Distant"};
    String courseDurations[]={"1 Yrs","2 Yrs","3 Yrs","4 Yrs","5 Yrs","6 Yrs"};
    private String gusername;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        academicManagementServicesImpl=new AcademicManagementServicesImpl();
        courseTypeCB.getItems().addAll(courseTypes);
        courseDurationCB.getItems().addAll(courseDurations);
        
        
        courseIdCol.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        courseNameCol.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        courseTypeCol.setCellValueFactory(new PropertyValueFactory<>("course_type"));
        noOfSemesterCol.setCellValueFactory(new PropertyValueFactory<>("course_noOfSemester"));
        courseDurationCol.setCellValueFactory(new PropertyValueFactory<>("course_duration"));
        
        loadAndRefreshTable();
    }    

    @FXML
    private void refreshTable(ActionEvent event) {
        loadAndRefreshTable();
    }

    @FXML
    private void openAddCourse(ActionEvent event) {
        
    }

    @FXML
    private void openUpdateCourse(ActionEvent event) {
    }

    @FXML
    private void backToDashboard(ActionEvent event) {
        int flag=JOptionPane.showConfirmDialog(null, "Do you want to go back? All unsaved data will be lost...");
        if(flag==0){
            Stage stage=(Stage)backBtn.getScene().getWindow();
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
            }catch(Exception ex){
                ex.printStackTrace();;
            }
        }
    }

    @FXML
    private void addCourse(ActionEvent event) {
        if(validateAllFieldForEmpty()){
            String courseId=courseIdTF.getText();
            String courseName=courseNameTF.getText();
            String courseType=courseTypeCB.getValue();
            if(noOfSemesterTF.getText().matches("[0-9]+")){
                int noOfSem=Integer.parseInt(noOfSemesterTF.getText());
                String courseDuration=courseDurationCB.getValue();
                
                Course course=new Course(courseId, courseName, courseType, noOfSem, courseDuration);
                int x=academicManagementServicesImpl.addCourse(course);
                if(x>0){
                    Notifications.create().position(Pos.TOP_RIGHT).title("Course added successfully..").showInformation();
                }else{
                    Notifications.create().position(Pos.TOP_RIGHT).title("Course not added").showError();
                }
        
                
            }else{
                Notifications.create().position(Pos.TOP_RIGHT).title("No of Semester should be in digit*").showError();
            }
        }
    }
    
    
    boolean validateAllFieldForEmpty(){
        if(courseIdTF.getText().isEmpty()){
            Notifications.create().position(Pos.TOP_RIGHT).title("Course Id is required*").showError();
        }else{
            if(courseNameTF.getText().isEmpty()){
                Notifications.create().position(Pos.TOP_RIGHT).title("Course Name is required*").showError();
            }else{
                if(courseTypeCB.getValue()==null){
                    Notifications.create().position(Pos.TOP_RIGHT).title("Course Type is required*").showError();
                }else{
                    if(noOfSemesterTF.getText().isEmpty()){
                        Notifications.create().position(Pos.TOP_RIGHT).title("No of Semester is required*").showError();
                    }else{
                        if(courseDurationCB.getValue()==null){
                            Notifications.create().position(Pos.TOP_RIGHT).title("Course Duration is required*").showError();
                        }else{
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
        void loadAndRefreshTable(){
        courseDispalyTV.getItems().clear();
        academicManagementServicesImpl=new AcademicManagementServicesImpl();
        List<Course> courseList=academicManagementServicesImpl.displayAllCourse();
        int rowCount=0;
        for(Course course:courseList){
            courseDispalyTV.getItems().add(course);
            rowCount++;
        }
        courseCountLabel.setText(rowCount+"");
    }
    
    void setUserDetails(String username){
        gusername=username;
    }
    
}
