
package Controller_FXMLController;

import Model_Services.LoginPageServicesImpl;
import Model_Beans.LoginUser;
import com.jfoenix.controls.JFXButton;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AdminDashboardFXMLController implements Initializable {
    
    LoginUser loginUser=new LoginUser();
    LoginPageServicesImpl loginPageServicesImpl=new LoginPageServicesImpl();
    
    @FXML
    private JFXButton studentNavBtn;
    @FXML
    private BorderPane bp;
    @FXML
    private Circle profilePic;
    @FXML
    private JFXButton academicNavBtn;
    @FXML
    private JFXButton staffNavBtn;
    @FXML
    private JFXButton certificateNavBtn;
    @FXML
    private JFXButton admissionNavBtn;
    @FXML
    private JFXButton feesNavBtn;
    @FXML
    private MenuItem manageProfileBtn;
    @FXML
    private MenuItem logoutBtn;
    @FXML
    private MenuButton menuBtn;

    
  
    //my declared variables
    String gEmail,name,phone,password;
    String gusertype="Admin";
    byte[] pic;
    int userid;
    Stage stage;
//    FXMLLoader loader;
    
    

//    This can't be achieved by ImageView so we will use circle instead of ImageView in scenebuilder
//    private Circle profilePic;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       openDashboardBanner();
//        openStudentManagement(new ActionEvent());

    }    

    void openDashboardBanner(){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AdminDashboardBannerFXML.fxml"));
            Parent root =loader.load();
            bp.setCenter(root);
            
            AdminDashboardBannerFXMLController adminDashboardBannerFXMLController=loader.getController();
            adminDashboardBannerFXMLController.fetchAllNumbers();
                       
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }


    @FXML
    private void openStudentManagement(ActionEvent event) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/StudentManagementBoards.fxml"));
            Parent root =loader.load();
            bp.setCenter(root);
            
            studentNavBtn.setStyle("-fx-background-color:blue");
            academicNavBtn.setStyle(null);
            admissionNavBtn.setStyle(null);
            staffNavBtn.setStyle(null);
            certificateNavBtn.setStyle(null);
            feesNavBtn.setStyle(null);
            
            StudentManagementBoardsController studentManagementBoardsController=loader.getController();
            studentManagementBoardsController.setUserDetails(gEmail);
  
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void openAcademicManagement(ActionEvent event) {
         try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AcademicManagementBoards.fxml"));
            Parent root=loader.load();
            bp.setCenter(root);
            
            academicNavBtn.setStyle("-fx-background-color:blue");
            studentNavBtn.setStyle(null);
            admissionNavBtn.setStyle(null);
            staffNavBtn.setStyle(null);
            certificateNavBtn.setStyle(null);
            feesNavBtn.setStyle(null);
            
            AcademicManagementBoardsController academicManagementBoardsController = loader.getController();
            academicManagementBoardsController.setUserDetails(gEmail,gusertype);
            
            
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void openStaffManagement(ActionEvent event) {
          try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/StaffManagementBoards.fxml"));
            Parent node=loader.load();
            bp.setCenter(node);
            
           staffNavBtn.setStyle("-fx-background-color:blue");
            studentNavBtn.setStyle(null);
            academicNavBtn.setStyle(null);
            admissionNavBtn.setStyle(null);
            certificateNavBtn.setStyle(null);
            feesNavBtn.setStyle(null);
            
            
            StaffManagementBoardsController staffManagementBoardsController=loader.getController();
            staffManagementBoardsController.setUserDetails(gEmail);
            
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void openCertificateManagement(ActionEvent event) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/CertificateManagementBoards.fxml"));
            Parent node=loader.load();
            bp.setCenter(node);
            
            certificateNavBtn.setStyle("-fx-background-color:blue");
            studentNavBtn.setStyle(null);
            academicNavBtn.setStyle(null);
            admissionNavBtn.setStyle(null);
            staffNavBtn.setStyle(null);
            feesNavBtn.setStyle(null);
            
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void openAdmissionManagement(ActionEvent event) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AdmissionManagementBoards.fxml"));
            Parent node=loader.load();
            bp.setCenter(node);
            
            admissionNavBtn.setStyle("-fx-background-color:blue");
            studentNavBtn.setStyle(null);
            academicNavBtn.setStyle(null);
            staffNavBtn.setStyle(null);
            feesNavBtn.setStyle(null);
            certificateNavBtn.setStyle(null);

            
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void openFeesManagement(ActionEvent event) {
          try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/FeesManagementBoards.fxml"));
            Parent node=loader.load();
            bp.setCenter(node);
            
            feesNavBtn.setStyle("-fx-background-color:blue");
            studentNavBtn.setStyle(null);
            academicNavBtn.setStyle(null);
            staffNavBtn.setStyle(null);
            admissionNavBtn.setStyle(null);
            certificateNavBtn.setStyle(null);
            
            FeesManagementBoardsController feesManagementBoardsController=loader.getController();
            feesManagementBoardsController.setUserDetails(gEmail,gusertype);
            
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }
        
  
    void setUserDetails(String email) {
        
              loginUser=loginPageServicesImpl.doLoginAsAdmin(email);
              userid=loginUser.getUserid();
              name=loginUser.getName();
              gEmail=loginUser.getEmail();
              password=loginUser.getPassword();
              phone=loginUser.getPhone();
              pic=loginUser.getUserPic(); //first store byte[] data from beans class
            
            ByteArrayInputStream bis = new ByteArrayInputStream(pic); //second convert it into byteArrayInputStream 
            
            Image image=new Image(bis); //third convert byteArrayInputStream into Image and then put it into further
            
            ImagePattern pattern = new ImagePattern(image);
             profilePic.setFill(pattern);
             menuBtn.setText(loginUser.getName()+" ("+loginUser.getUsertype()+")");    
        }  

    @FXML
    private void manageProfile(ActionEvent event) throws IOException {
             Parent root;
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_FXMLGUI/ManageProfileFormFXML.fxml"));
             root=loader.load();
             
            ManageProfileFormFXMLController obj=loader.getController();
            obj.setAllDetails(userid,"Admin",name, gEmail, phone, password,pic);
             
             Scene scene = new Scene(root, 600, 700);
            stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Manage Profile");
            stage.getIcons().add(new Image("/MultimediaResources/loginPageTitleIcon.png"));
            stage.setScene(scene);
            stage.showAndWait();
         
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Stage currentStage=(Stage)profilePic.getScene().getWindow();
        currentStage.close();
        Parent root=FXMLLoader.load(getClass().getResource("/View_FXMLGUI/loginFormFXML.fxml"));
        Stage stage=new Stage();
//        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setTitle("Login -  P.K. Roy Memorial College Dhanbad - Smart-Ed College ERP v1.1.1");
        stage.getIcons().add(new Image("/MultimediaResources/loginPageTitleIcon.png"));
        Scene scene=new Scene(root,1150, 650);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
