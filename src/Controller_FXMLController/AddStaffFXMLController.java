
package Controller_FXMLController;

import Model_Beans.Faculty;
import Model_Services.StaffManagementServicesImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class AddStaffFXMLController implements Initializable {

    @FXML
    private JFXComboBox<String> staffTypeCB;
    @FXML
    private JFXTextField facultyNameTF;
    @FXML
    private JFXTextField cityTF;
    @FXML
    private JFXTextField emailTF;
    @FXML
    private JFXTextField qualificationTF;
    @FXML
    private ImageView picImageView;
    @FXML
    private Label fileChooseStatusLabel;
    @FXML
    private Button choosePicBtn;
    @FXML
    private JFXComboBox<String> genderCB;
    @FXML
    private JFXTextField stateTF;
    @FXML
    private JFXTextField mobileTF;
    @FXML
    private JFXTextField designationTF;
    @FXML
    private JFXTextField experienceTF;

    
    @FXML
    private HBox ap;
    @FXML
    private Button addStaffBtn;
    
    StaffManagementServicesImpl staffManagementServicesImpl;
    String staffTypes[]={"Faculty","Non-Teaching"};
    String genders[]={"Male","Female","Others"};
    byte[] pic;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        staffManagementServicesImpl=new StaffManagementServicesImpl();
        ap.setVisible(false);
        addStaffBtn.setVisible(false);
        staffTypeCB.getItems().addAll(staffTypes);
        
    }    

    @FXML
    private void choosePic(ActionEvent event) {
        try{
            FileChooser fileChooser=new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg"));
            File selectedProfilePicFile=fileChooser.showOpenDialog(null);
            Image image = null;
            image = new Image(new FileInputStream(selectedProfilePicFile)); //converted using FileInputStream class
            picImageView.setImage(image);   
            fileChooseStatusLabel.setText(selectedProfilePicFile.getCanonicalPath());
            FileInputStream f = new FileInputStream(selectedProfilePicFile);        
            pic=new byte[(int)selectedProfilePicFile.length()];
            f.read(pic);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Profile Pic couldn't be loaded...");
            e.printStackTrace();
        }
    }

    @FXML
    private void addStaff(ActionEvent event) {
        if(validateAllFieldsForEmpty()){
            if(validateAllFieldsForWrongEntry()){
                String facultyName=facultyNameTF.getText();
                String facultyGender=genderCB.getValue();
                String facultyCity=cityTF.getText();
                String facultyState=stateTF.getText();
                String facultyEmail=emailTF.getText();
                String facultyMobile=mobileTF.getText();
                String facultyQualification=qualificationTF.getText();
                String facultyDesignation=designationTF.getText();
                String facultyExperience=experienceTF.getText();
                Faculty faculty=new Faculty(0,facultyName, facultyGender, facultyState, facultyCity, facultyEmail, facultyMobile, facultyDesignation, facultyQualification, facultyExperience, pic);
                int x=staffManagementServicesImpl.addFaculty(faculty);
                if(x>0){
                    Notifications.create().position(Pos.TOP_RIGHT).title("Faculty is added successfully").showInformation();
                    JOptionPane.showMessageDialog(null, "Faculty Id is  "+x);
                    clearAllFields();
                }else{
                    Notifications.create().position(Pos.TOP_RIGHT).title("Faculty not added").showError();
                }
                
            }
        }
    }

    @FXML
    private void staffTypeStateChange(ActionEvent event) {
        String staffType=staffTypeCB.getValue();
        if(staffType.equals("Faculty")){
            ap.setVisible(true);
            addStaffBtn.setVisible(true);
            genderCB.getItems().clear();
            genderCB.getItems().addAll(genders);
         
        }
        else if(staffType.equals("Non-Teaching")){
            ap.setVisible(false);
            addStaffBtn.setVisible(false);
        }
    }
    
    boolean validateAllFieldsForEmpty(){
        if(facultyNameTF.getText().isEmpty()){
            Notifications.create().position(Pos.TOP_RIGHT).title("Faculty Name is required*").showError();
            facultyNameTF.requestFocus();
        }else{
            if(genderCB.getValue()==null){
                Notifications.create().position(Pos.TOP_RIGHT).title("Gender is required*").showError();
                genderCB.requestFocus();
            }else{
                if(cityTF.getText().isEmpty()){
                    Notifications.create().position(Pos.TOP_RIGHT).title("City Name is required*").showError();
                    cityTF.requestFocus();
                }else{
                    if(stateTF.getText().isEmpty()){
                        Notifications.create().position(Pos.TOP_RIGHT).title("State Name is required*").showError();
                        stateTF.requestFocus();
                    }else{
                        if(emailTF.getText().isEmpty()){
                            Notifications.create().position(Pos.TOP_RIGHT).title("Email is required*").showError();
                            emailTF.requestFocus();
                        }else{
                            if(mobileTF.getText().isEmpty()){
                                Notifications.create().position(Pos.TOP_RIGHT).title("Mobile is required*").showError();
                                mobileTF.requestFocus();
                            }else{
                                if(qualificationTF.getText().isEmpty()){
                                    Notifications.create().position(Pos.TOP_RIGHT).title("Qualification is required*").showError();
                                    qualificationTF.requestFocus();
                                }else{
                                    if(designationTF.getText().isEmpty()){
                                        Notifications.create().position(Pos.TOP_RIGHT).title("Designation is required*").showError();
                                        designationTF.requestFocus();
                                    }else{
                                        if(experienceTF.getText().isEmpty()){
                                            Notifications.create().position(Pos.TOP_RIGHT).title("Experience is required*").showError();
                                            experienceTF.requestFocus();
                                        }else{
                                            if(pic==null){
                                                Notifications.create().position(Pos.TOP_RIGHT).title("Profile Pic is required*").showError();
                                                picImageView.requestFocus();
                                            }else{
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    boolean validateAllFieldsForWrongEntry(){
        if(facultyNameTF.getText().matches("^[a-zA-Z ]*$") && facultyNameTF.getText().length()<=20){
            if(cityTF.getText().length()<=15){
                if(stateTF.getText().length()<=15){
                    if(emailTF.getText().matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$")){
                        if(mobileTF.getText().length()==10 && mobileTF.getText().matches("(0/91)?[6-9][0-9]{9}")){
                            return true;
                        }else{
                            Notifications.create().position(Pos.TOP_RIGHT).title("Please Enter 10 digit Mobile No").showError();
                            mobileTF.requestFocus();
                        }
                    }else{
                        Notifications.create().position(Pos.TOP_RIGHT).title("Please Enter valid Email").showError();
                        emailTF.requestFocus();
                    }
                }else{
                    Notifications.create().position(Pos.TOP_RIGHT).title("Please Enter valid State Name").showError();
                    stateTF.requestFocus();
                }
            }else{
                Notifications.create().position(Pos.TOP_RIGHT).title("Please Enter City Name").showError();
                cityTF.requestFocus();
            }
        }else{
            Notifications.create().position(Pos.TOP_RIGHT).title("Please Enter valid Name").showError();
            facultyNameTF.requestFocus();
        }
    
    
        return false;
    }
    
    void clearAllFields(){
        pic=null;
        facultyNameTF.clear();
        cityTF.clear();
        emailTF.clear();
        qualificationTF.clear();
        picImageView.setImage(null);
        genderCB.setValue(null);
        stateTF.clear();
        mobileTF.clear();
        designationTF.clear();
        experienceTF.clear();
    }
}
