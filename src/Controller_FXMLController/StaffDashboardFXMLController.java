
package Controller_FXMLController;

import Model_Beans.LoginUser;
import Model_Services.LoginPageServicesImpl;
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

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class StaffDashboardFXMLController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Circle profilePic;
    @FXML
    private MenuButton menuBtn;
    @FXML
    private MenuItem manageProfileBtn;
    @FXML
    private MenuItem logoutBtn;
    @FXML
    private JFXButton academicNavBtn;
    @FXML
    private JFXButton attendanceNavBtn;
    @FXML
    private JFXButton learningNavBtn;

    LoginUser loginUser=new LoginUser();
    LoginPageServicesImpl loginPageServicesImpl=new LoginPageServicesImpl();
    
        //my declared variables
    String gEmail,name,phone,password;
    byte[] pic;
    int userid;
    String gusertype="Staff";
    Stage stage;
//    FXMLLoader loader;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        openDashboardBanner();
    }

    void openDashboardBanner(){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/StaffDashboardBannerFXML.fxml"));
            Parent root =loader.load();
            StaffDashboardBannerFXMLController staffDashboardBannerFXMLController=loader.getController();
            staffDashboardBannerFXMLController.setUserDetails(gEmail);
            bp.setCenter(root);
                       
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void manageProfile(ActionEvent event) throws IOException {
             Parent root;
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_FXMLGUI/ManageProfileFormFXML.fxml"));
             root=loader.load();
             
            ManageProfileFormFXMLController obj=loader.getController();
            obj.setAllDetails(userid,"Staff",name, gEmail, phone, password,pic);
             
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
        Stage stage1=new Stage();
//        stage.setMaximized(true);
        stage1.setResizable(false);
        stage1.setTitle("Login -  P.K. Roy Memorial College Dhanbad - Smart-Ed College ERP v1.1.1");
        stage1.getIcons().add(new Image("/MultimediaResources/loginPageTitleIcon.png"));
        Scene scene=new Scene(root,1150, 650);
        
        stage1.setScene(scene);
        stage1.show();
    }

    @FXML
    private void openAcademicManagement(ActionEvent event) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AcademicManagementBoardsForStaff.fxml"));
            Parent root =loader.load();
            bp.setCenter(root);
            
            academicNavBtn.setStyle("-fx-background-color:blue");
            attendanceNavBtn.setStyle(null);
            learningNavBtn.setStyle(null);
            
            AcademicManagementBoardsForStaffController academicManagementBoardsForStaffController=loader.getController();
            academicManagementBoardsForStaffController.setUserDetails(gEmail,gusertype);
  
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void openAttendanceManagement(ActionEvent event) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AttendanceManagementBoards.fxml"));
            Parent root =loader.load();
            bp.setCenter(root);
            
            academicNavBtn.setStyle(null);
            attendanceNavBtn.setStyle("-fx-background-color:blue");
            learningNavBtn.setStyle(null);
            
            AttendanceManagementBoardsController attendanceManagementBoardsController=loader.getController();
            attendanceManagementBoardsController.setUserDetails(gEmail);
  
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void openLearningManagement(ActionEvent event) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/LearningManagementBoards.fxml"));
            Parent root =loader.load();
            bp.setCenter(root);
            
            academicNavBtn.setStyle(null);
            attendanceNavBtn.setStyle(null);
            learningNavBtn.setStyle("-fx-background-color:blue");
            
            LearningManagementBoardsController learningManagementBoardsController=loader.getController();
            learningManagementBoardsController.setUserDetails(gEmail);
  
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    
    void setUserDetails(String email){
    loginUser=loginPageServicesImpl.doLoginAsStaff(email);
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
    
}
