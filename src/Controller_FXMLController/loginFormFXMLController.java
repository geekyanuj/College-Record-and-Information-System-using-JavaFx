package Controller_FXMLController;


import Model_Services.LoginPageServicesImpl;
import Model_Beans.LoginUser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

public class loginFormFXMLController implements Initializable {
    
    @FXML
    private Label forgotPasswordLabel;
    @FXML
    private JFXComboBox<String> userTypeComboBox;
    @FXML
    private JFXTextField emailTF;
    @FXML
    private JFXPasswordField passwordTF;
    @FXML
    private JFXButton loginBtn;

    //declared variables
    LoginPageServicesImpl loginPageServicesImpl=new LoginPageServicesImpl();
    private boolean isAllFieldsValidated;
    int useridfromdb=0;
//    String globalusername="anujv8692@gmail.com";
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    LoginUser userfromdb;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().add("Admin");
        userTypeComboBox.getItems().add("Staff");
        userTypeComboBox.getItems().add("Student");
        
        passwordTF.setOnKeyPressed( event -> {
           if( event.getCode() == KeyCode.ENTER ) {
              login(new ActionEvent());
           }
        } );   
    }    

 
    @FXML
    private void login(ActionEvent event) {
        isAllFieldsValidated=validateAllFields();
        if(isAllFieldsValidated){
            String usertype=userTypeComboBox.getSelectionModel().getSelectedItem();
            String email=emailTF.getText().trim();
            String password=passwordTF.getText();
            
            if(usertype.equals("Admin")){
                boolean x=validateLoginCredentialsForAdmin(email,password);
                if(x){
                    stage=(Stage)loginBtn.getScene().getWindow();
                    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
                    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
                    stage.setResizable(true);
                    try{
                        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AdminDashboardFXML.fxml"));
                        root=loader.load();
                    
                        AdminDashboardFXMLController adminDashboardFXMLController=loader.getController();
                        adminDashboardFXMLController.setUserDetails(userfromdb.getEmail());
                    
                        scene=new Scene(root,screenWidth,screenHeight);
                        stage.setScene(scene);
                        stage.setTitle("Admin - P.K. Roy Memorial College,Dhanbad  College Record and Information System v1.1.1");
                        stage.setX(0);
                        stage.setY(0);
                        stage.show();         
                    }catch (IOException ex){
                        System.out.println(ex);
                    ex.printStackTrace();
                    }
                }
                
            }else if(usertype.equals("Staff")){
                boolean x=validateLoginCredentialsForStaff(email,password);
                if(x){
                    stage=(Stage)loginBtn.getScene().getWindow();
                    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
                    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
                    stage.setResizable(true);
                    try{
                        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/StaffDashboardFXML.fxml"));
                        root=loader.load();
                    
                        StaffDashboardFXMLController staffDashboardFXMLController=loader.getController();
                        staffDashboardFXMLController.setUserDetails(userfromdb.getEmail());
                    
                        scene=new Scene(root,screenWidth,screenHeight);
                        stage.setScene(scene);
                        stage.setTitle("Staff - P.K. Roy Memorial College,Dhanbad  College Record and Information System v1.1.1");
                        stage.setX(0);
                        stage.setY(0);
                        stage.show();         
                    }catch (IOException ex){
                        System.out.println(ex);
                        ex.printStackTrace();
                    }
                }
            }else if(usertype.equals("Student")){
                boolean x=validateLoginCredentialsForStudent(email,password);
                if(x){
                    stage=(Stage)loginBtn.getScene().getWindow();
                    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
                    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
                    stage.setResizable(true);
                    try{
                        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/StudentDashboardFXML.fxml"));
                        root=loader.load();
                    
                        StudentDashboardFXMLController studentDashboardFXMLController=loader.getController();
                        studentDashboardFXMLController.setUserDetails(userfromdb.getEmail());
                    
                        scene=new Scene(root,screenWidth,screenHeight);
                        stage.setScene(scene);
                        stage.setTitle("Student - P.K. Roy Memorial College,Dhanbad  College Record and Information System v1.1.1");
//                       stage.getIcons().add(new Image("/MultimediaResources/pkroylogo.png")); 
                        stage.setX(0);
                        stage.setY(0);
                        stage.show();         
                    }catch (IOException ex){
                        System.out.println(ex);
                        ex.printStackTrace();
                    }
                }
            }
            
        } 
    }
    
    
    @FXML
    private void forgotPassword(MouseEvent event) {
       Parent loader;     
        try
        {
            loader = FXMLLoader.load(getClass().getResource("/View_FXMLGUI/forgotPasswordFXML.fxml"));
            Scene scene = new Scene(loader, 1000, 530);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Forgot Password");
            stage.getIcons().add(new Image("/MultimediaResources/loginPageTitleIcon.png"));
            stage.setScene(scene);
            
            stage.showAndWait();
        
        
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
    
    //method for validating all fileds in login form
    boolean validateAllFields(){
        String userType=userTypeComboBox.getSelectionModel().getSelectedItem();
        String email=emailTF.getText().trim();
        String password=passwordTF.getText().trim();
        if(userType==null){
            Notifications.create().darkStyle().position(Pos.TOP_RIGHT).title("User Type is not selected...").text("Please select your Usertype").showError();
        }else{
            if(email.isEmpty()){
                Notifications.create().darkStyle().position(Pos.TOP_RIGHT).title("Email is required*").text("Please enter your Email").showError();
            }else{
                if(password.isEmpty()){
                    Notifications.create().darkStyle().position(Pos.TOP_RIGHT).title("Password is required*").text("Please enter your Password").showError();
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    
    //method for validating all fileds in database
    boolean validateLoginCredentialsForAdmin(String email,String password){
        userfromdb=loginPageServicesImpl.doLoginAsAdmin(email);
        String emailfromdb=userfromdb.getEmail();
        String passwordfromdb=userfromdb.getPassword();

        if(userfromdb.getUserid()!=null) {
            if((emailfromdb!=null)&&(emailfromdb.equals(email))){
                if((passwordfromdb!=null)&&passwordfromdb.equals(password)){
                    JOptionPane.showMessageDialog(null, "Welcome");
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Password!!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid User");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid credentials");         
        }
        return false;
    }   

    
    boolean validateLoginCredentialsForStaff(String email,String password){
        userfromdb=loginPageServicesImpl.doLoginAsStaff(email);
        String emailfromdb=userfromdb.getEmail();
        String passwordfromdb=userfromdb.getPassword();

        if(userfromdb.getUserid()!=null) {
            if((emailfromdb!=null)&&(emailfromdb.equals(email))){
                if((passwordfromdb!=null)&&passwordfromdb.equals(password)){
                    JOptionPane.showMessageDialog(null, "Welcome");
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Password!!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid User");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid credentials");         
        }
        return false;
    }  
    
        
    boolean validateLoginCredentialsForStudent(String email,String password){
        userfromdb=loginPageServicesImpl.doLoginAsStudent(email);
        String emailfromdb=userfromdb.getEmail();
        String passwordfromdb=userfromdb.getPassword();

        if(userfromdb.getUserid()!=null) {
            if((emailfromdb!=null)&&(emailfromdb.equals(email))){
                if((passwordfromdb!=null)&&passwordfromdb.equals(password)){
                    JOptionPane.showMessageDialog(null, "Welcome");
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Password!!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid User");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid credentials");         
        }
        return false;
    }
    
}
