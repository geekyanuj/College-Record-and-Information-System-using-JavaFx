
package Controller_FXMLController;

import Model_Services.LoginPageServicesImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

public class ForgotPasswordFXMLController implements Initializable {

    @FXML
    private JFXButton resetPasswordBtn;
    @FXML
    private JFXTextField usernameTF;
    
    
    //Declares variables
    LoginPageServicesImpl loginPageServicesImpl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         loginPageServicesImpl=new LoginPageServicesImpl();
    }    

    @FXML
    private void resetPassword(ActionEvent event) {
          String username=usernameTF.getText();
          String password=loginPageServicesImpl.getPassword(username);
          if(validateUsernameField(password)){
            JOptionPane.showMessageDialog(null, "Your Password is :  "+password);  
          }else{
              
          }
          
    }
    
    
    boolean validateUsernameField(String password){
        if(usernameTF.getText().isEmpty()){
            Notifications.create().position(Pos.TOP_RIGHT).text("Please enter your Email").title("Email is required*").showError();
        }else if(password==null){
            Notifications.create().position(Pos.TOP_RIGHT).text("Please enter a valid Email").title("Invalid User*").showError();
        }else{
            return true;
        }
        return false;
    }
}
