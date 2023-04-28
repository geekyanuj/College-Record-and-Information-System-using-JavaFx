
package Controller_FXMLController;

import Model_Services.AdminPageServicesImpl;
import Model_Beans.LoginUser;
import Model_Services.StaffPageServicesImpl;
import com.jfoenix.controls.JFXButton;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;


public class ManageProfileFormFXMLController implements Initializable {
    


    @FXML
    private Circle circle;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private PasswordField cPasswordTF;
    @FXML
    private JFXButton updateBtn;

    //my declared variables
     LoginUser loginUser;
    AdminPageServicesImpl adminPageServicesImpl;
    StaffPageServicesImpl staffPageServicesImpl;
    int userid;
    String userType;
    File selectedFile;
    byte []pic;

 
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        adminPageServicesImpl=new AdminPageServicesImpl();
        staffPageServicesImpl=new StaffPageServicesImpl();
    }    

    @FXML
    private void chooseImg(MouseEvent event) throws FileNotFoundException, IOException {
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg"));
        selectedFile=fileChooser.showOpenDialog(null);
        if(selectedFile!=null){
            Image image=new Image(new FileInputStream(selectedFile)); //converted using FileInputStream class
            ImagePattern pattern = new ImagePattern(image);
            circle.setFill(pattern);
        
            FileInputStream f = new FileInputStream(selectedFile);
        
            pic=new byte[(int)selectedFile.length()];
            f.read(pic);
        }
    }

    @FXML
    private void updateProfile(ActionEvent event) throws FileNotFoundException, IOException {
        
        
        if(validateAllFieldsForEmpty()){
            if(validateAllFieldsForWrongEntry()){
                    
                    String name=nameTF.getText().trim();
                    String email=emailTF.getText().trim();
                    String phone=phoneTF.getText().trim();
                    String password=cPasswordTF.getText().trim();
                    
                    loginUser=new LoginUser(userid, userType,email,password,pic,phone,name);
                    int r=0;
                    if(userType.equals("Admin")){
                        r=adminPageServicesImpl.updateUser(loginUser);
                    }else if(userType.equals("Staff")){
                        r=staffPageServicesImpl.updateStaffProfile(loginUser);
                    }else if(userType.equals("Student")){
                        //////////////
                    }
                    
                    
                        if(r>0){
                            JOptionPane.showMessageDialog(null, "Profile Updated Successfully ! Please Login with new credentials");
                            updateBtn.setDisable(true);
                        }else{
                            JOptionPane.showMessageDialog(null, "Profile Not Updated ");
                        }
            }
        
        }

        

        

        
    
    }
    
    void setAllDetails(int userid,String userType,String name,String email,String phone,String password,byte[] pic){
       
        ByteArrayInputStream bis = new ByteArrayInputStream(pic); //second convert it into byteArrayInputStream     
        Image image=new Image(bis); //third convert byteArrayInputStream into Image and then put it into further
        ImagePattern pattern = new ImagePattern(image);
        circle.setFill(pattern);
        this.pic=pic;
        this.userid=userid;
        this.userType=userType;
        nameTF.setText(name);
        emailTF.setText(email);
        phoneTF.setText(phone);
        passwordTF.setText(password);
    }
    
    boolean validateAllFieldsForEmpty(){
        if(nameTF.getText().trim().isEmpty()){
            Notifications.create().position(Pos.TOP_CENTER).title("Name is required*").text("Please enter your name").showError();
            nameTF.requestFocus();
        }else{
            if(emailTF.getText().trim().isEmpty()){
                Notifications.create().position(Pos.TOP_CENTER).title("Email is required*").text("Please enter your Email").showError();
                emailTF.requestFocus();
            }else{
                if(phoneTF.getText().trim().isEmpty()){
                    Notifications.create().position(Pos.TOP_CENTER).title("Phone No. is required*").text("Please enter your Phone No").showError();
                    phoneTF.requestFocus();
                }else{
                    if(passwordTF.getText().trim().isEmpty()){
                        Notifications.create().position(Pos.TOP_CENTER).title("Password is required*").text("Please enter password").showError();
                        passwordTF.requestFocus();
                    }else{
                        if(!(passwordTF.getText().equals(cPasswordTF.getText()))){
                            Notifications.create().position(Pos.TOP_CENTER).title("Password Mismatch*").text("Please confirm your password").showError();
                            cPasswordTF.requestFocus();
                        }else{
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    boolean validateAllFieldsForWrongEntry(){
        if(nameTF.getText().matches("^[a-zA-Z ]*$")){
            if(emailTF.getText().matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$")){
                if(phoneTF.getText().length()==10 && phoneTF.getText().matches("(0/91)?[7-9][0-9]{9}")){
                     if(passwordTF.getText().length()>=8 && passwordTF.getText().length()<=12 ){
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Password should be greater than 8 and less than 12 characters");
                        passwordTF.requestFocus();
                        
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Phone No.");
                    phoneTF.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Email");
                emailTF.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Name");
            nameTF.requestFocus();
        }
        return false;
    }
    
}
