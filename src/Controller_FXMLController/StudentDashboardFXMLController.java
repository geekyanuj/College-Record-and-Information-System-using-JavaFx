
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
public class StudentDashboardFXMLController implements Initializable {

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
    private JFXButton routineNavBtn;
    @FXML
    private JFXButton learningNavBtn;
    @FXML
    private JFXButton feeNavBtn;

   //my declared variables
    String gEmail,name,phone,password;
    String gusertype="Student";
    byte[] pic;
    int userid;
    Stage stage;
    LoginUser loginUser=new LoginUser();
    LoginPageServicesImpl loginPageServicesImpl=new LoginPageServicesImpl();
    @FXML
    private JFXButton profileNavBtn;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        openDashboardBanner();
    }    
    
    void openDashboardBanner(){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/StudentDashboardBannerFXML.fxml"));
            Parent root =loader.load();
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
        stage.setResizable(false);
        stage.setTitle("Login -  P.K. Roy Memorial College Dhanbad - Smart-Ed College ERP v1.1.1");
        stage.getIcons().add(new Image("/MultimediaResources/loginPageTitleIcon.png"));
        Scene scene=new Scene(root,1150, 650);
        
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void openProfileManagement(ActionEvent event) {
         try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/ProfileManagementBoards.fxml"));
            Parent root =loader.load();
            bp.setCenter(root);
            
            profileNavBtn.setStyle("-fx-background-color:blue");
            routineNavBtn.setStyle(null);
            learningNavBtn.setStyle(null);
            feeNavBtn.setStyle(null);
            
            ProfileManagementBoardsController profileManagementBoardsController=loader.getController();
            profileManagementBoardsController.setUserDetails(gEmail);
  
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void openRoutineManagement(ActionEvent event) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/RoutineManagementBoards.fxml"));
            Parent root =loader.load();
            bp.setCenter(root);
            
            profileNavBtn.setStyle(null);
            routineNavBtn.setStyle("-fx-background-color:blue");
            learningNavBtn.setStyle(null);
            feeNavBtn.setStyle(null);
            
            RoutineManagementBoardsController routineManagementBoardsController=loader.getController();
            routineManagementBoardsController.setUserDetails(gEmail);
  
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
            
            profileNavBtn.setStyle(null);
            routineNavBtn.setStyle(null);
            learningNavBtn.setStyle("-fx-background-color:blue");
            feeNavBtn.setStyle(null);
            
            LearningManagementBoardsController learningManagementBoardsController=loader.getController();
            learningManagementBoardsController.setUserDetails(gEmail);
  
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void openFeeManagement(ActionEvent event) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/FeesManagementBoards.fxml"));
            Parent root =loader.load();
            bp.setCenter(root);
            
            profileNavBtn.setStyle(null);
            routineNavBtn.setStyle(null);
            learningNavBtn.setStyle(null);
            feeNavBtn.setStyle("-fx-background-color:blue");
            
            FeesManagementBoardsController feesManagementBoardsController=loader.getController();
            feesManagementBoardsController.setUserDetails(gEmail,gusertype);
            
  
         } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    
    
    
        
    void setUserDetails(String email) {
              loginUser=loginPageServicesImpl.doLoginAsStudent(email);
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
