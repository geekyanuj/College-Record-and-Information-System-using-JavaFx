
package Controller_FXMLController;

import Model_Services.StudentManagementServicesImpl;
import Model_Beans.Student;
import Model_Beans.StudentPersonalInformation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class DeleteStudent1FXMLController implements Initializable {
    
    StudentManagementServicesImpl studentManagementServicesImpl;

    @FXML
    private TextField studentIdTF;
    @FXML
    private JFXButton findStudentBtn;
    @FXML
    private JFXTextField fullNameTF;
    @FXML
    private JFXTextField fatherNameTF;
    @FXML
    private JFXTextField motherNameTF;
    @FXML
    private JFXTextField emailTF;
    @FXML
    private JFXTextField dobTF;
    @FXML
    private JFXTextField genderTF;
    @FXML
    private JFXTextField mobileNoTF;
    @FXML
    private ImageView picImgView;
    @FXML
    private ImageView signImgView;
    
    
    boolean isDataFoundAgaintStudentId=false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        studentManagementServicesImpl=new StudentManagementServicesImpl();
    }    

    @FXML
    private void findStudentUsingStudentId(ActionEvent event) {
        if(! studentIdTF.getText().isEmpty()){
            String studentId=studentIdTF.getText().trim();
            
            StudentPersonalInformation studentPersonalInformation = studentManagementServicesImpl.findStudentUsingStudentId(studentId);
            if(!studentPersonalInformation.getId().isEmpty() && studentPersonalInformation.getId().equals(studentId)){
                

                fullNameTF.setText(studentPersonalInformation.getFullName());
                fatherNameTF.setText(studentPersonalInformation.getFatherName());
                motherNameTF.setText(studentPersonalInformation.getMotherName());
                emailTF.setText(studentPersonalInformation.getEmail());
                dobTF.setText(studentPersonalInformation.getDob());
                genderTF.setText(studentPersonalInformation.getGender());
                mobileNoTF.setText(studentPersonalInformation.getMobileNo());
                picImgView.setImage(new Image(new ByteArrayInputStream(studentPersonalInformation.getProfilePic())));
                signImgView.setImage(new Image(new ByteArrayInputStream(studentPersonalInformation.getSignature())));
                
                isDataFoundAgaintStudentId=true;
            
            }else{
                Notifications.create().position(Pos.TOP_CENTER).title("Student not Found...").text("Please check Student Id").showError();
                studentIdTF.requestFocus();
            }
        }else{
            Notifications.create().position(Pos.TOP_CENTER).title("Student Id is required*").text("Please Enter Student Id").showError();
            studentIdTF.requestFocus();
        }
        
        
    }


    @FXML
    private void deleteStudent(ActionEvent event) {
        if(! studentIdTF.getText().isEmpty()){
            String studentId=studentIdTF.getText();
            if(isDataFoundAgaintStudentId){
                int flag=studentManagementServicesImpl.deleteStudent(studentId);
                if(flag>0){
                    Notifications.create().position(Pos.BOTTOM_RIGHT).title("Deleted Successfully").showInformation();
                    clearAllFields();
                }else{
                    Notifications.create().position(Pos.BOTTOM_RIGHT).title("Not Deleted").showError();
                }
            }
        }else{
            Notifications.create().position(Pos.TOP_CENTER).title("Error").text("Please Find the Student first").showError();
            studentIdTF.requestFocus();
        }
    }

    private void clearAllFields() {
        fullNameTF.clear();
        fatherNameTF.clear();
        motherNameTF.clear();
        emailTF.clear();
        dobTF.clear();
        genderTF.clear();
        mobileNoTF.clear();
        picImgView.setImage(null);
        signImgView.setImage(null);
    }
}
