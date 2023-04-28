
package Controller_FXMLController;

import Model_Beans.StudentPersonalInformation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import Model_Services.StudentManagementServicesImpl;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class ManageParentAndGuardianBoardFXMLController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private JFXButton submitBtn;
    @FXML
    private JFXTextField fatherNameTF;
    @FXML
    private JFXTextField motherNameTF;
    @FXML
    private JFXTextField guardianNameTF;
    @FXML
    private JFXComboBox<String> relationshipComboBox;
    @FXML
    private BorderPane displayTabBP;
    @FXML
    private Button backBtn;
    @FXML
    private TextField studentIdTF;
    @FXML
    private JFXButton findStudentBtn;
    @FXML
    private JFXTextField studentNameTF;
    
    StudentManagementServicesImpl studentManagementServicesImpl;
    StudentPersonalInformation studentPersonalInformation;
    String gusername;
    String relationships[]={"Father","Mother","Step-Father","Step-Mother","Spouse","Brother","Sister","Uncle","Aunt"};
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        relationshipComboBox.getItems().addAll(relationships);
        studentManagementServicesImpl=new StudentManagementServicesImpl();
        studentPersonalInformation=new StudentPersonalInformation();
    }    

    @FXML
    private void findStudentUsingStudentId(ActionEvent event) {
        String id=studentIdTF.getText();
        studentPersonalInformation = studentManagementServicesImpl.findStudentUsingStudentId(id);
        if(studentPersonalInformation!=null && id.equals(studentPersonalInformation.getId())){
            studentNameTF.setText(studentPersonalInformation.getFullName());
            fatherNameTF.setText(studentPersonalInformation.getFatherName());
            motherNameTF.setText(studentPersonalInformation.getMotherName());
            guardianNameTF.setText(studentPersonalInformation.getGuardianName());
            relationshipComboBox.setValue(studentPersonalInformation.getRelationshipWithGuardian());
        }else{
            Notifications.create().position(Pos.TOP_RIGHT).title("Student Not Found...").showError();
        }
    }
    @FXML
    private void submit(ActionEvent event) {
        if(validateAllFieldsForEmpty()){
            String id=studentIdTF.getText();
            String fatherName=fatherNameTF.getText();
            String motherName=motherNameTF.getText();
            String guardianName=guardianNameTF.getText();
            String relationshipName=relationshipComboBox.getValue();
        
            studentPersonalInformation=new StudentPersonalInformation(id,fatherName, motherName, guardianName, relationshipName);
            int x=studentManagementServicesImpl.updateStudentParentDetails(studentPersonalInformation);
            if(x>0){
                Notifications.create().position(Pos.TOP_RIGHT).title("Updated Successfully").showInformation();
                submitBtn.setDisable(true);
            }else{
                Notifications.create().position(Pos.TOP_RIGHT).title("Not Updated").showInformation();
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
    
    boolean validateAllFieldsForEmpty(){
        if(studentIdTF.getText().isEmpty()){
            Notifications.create().position(Pos.TOP_RIGHT).title("Student Id is required*").showError();
            studentIdTF.requestFocus();
        }else{
            if(fatherNameTF.getText().isEmpty()){
                Notifications.create().position(Pos.TOP_RIGHT).title("Father Name is required*").showError();
                fatherNameTF.requestFocus();
            }else{
                if(motherNameTF.getText().isEmpty()){
                    Notifications.create().position(Pos.TOP_RIGHT).title("Mother Name is required*").showError();
                    motherNameTF.requestFocus();
                }else{
                    if(guardianNameTF.getText().isEmpty()){
                        Notifications.create().position(Pos.TOP_RIGHT).title("Guardian Name is required*").showError();
                         guardianNameTF.requestFocus();
                    }else{
                        if(relationshipComboBox.getSelectionModel().getSelectedItem().isEmpty()){
                            Notifications.create().position(Pos.TOP_RIGHT).title("Relationship is required*").showError();
                            relationshipComboBox.requestFocus();
                        }else{
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    
    void fetchUserDetails(String username){
        gusername=username;
    }


    
}
