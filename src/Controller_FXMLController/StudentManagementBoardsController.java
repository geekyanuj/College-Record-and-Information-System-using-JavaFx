
package Controller_FXMLController;


import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class StudentManagementBoardsController implements Initializable {

    @FXML
    private JFXButton btn;
    
    
//    LoginUser loginUser;
//    LoginPageServicesImpl loginPageServicesImpl;
    String gusername;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openManageStudent(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/ManageStudentBoardFXML.fxml"));
        
        Parent root=loader.load();
        Stage currentsStage=(Stage)btn.getScene().getWindow();
        currentsStage.hide();
        
        Stage currentStage=new Stage();
        Scene scene=new Scene(root);

        currentStage.setUserData(currentsStage);
        
        currentStage.setScene(scene);
        currentStage.setMaximized(true);
        currentStage.getIcons().add(new Image("/MultimediaResources/pkroylogo.png"));
        currentStage.setTitle("Manage Students - P.K. Roy Memorial College Dhanbad - Smart-Ed College ERP v1.1.1");
        currentStage.show();
        
        
        ManageStudentBoardFXMLController manageStudentBoardFXMLController=loader.getController();
        manageStudentBoardFXMLController.fetchUserDetails(gusername);
        
        
    }

    @FXML
    private void openManageParent(ActionEvent event) throws IOException {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/ManageParentAndGuardianBoardFXML.fxml"));
        
        Parent root = loader.load();
      
        Stage currentsStage=(Stage)btn.getScene().getWindow();
        currentsStage.hide();
        
        Stage currentStage=new Stage();
        Scene scene=new Scene(root);

        currentStage.setUserData(currentsStage);
        
        currentStage.setScene(scene);
        currentStage.setMaximized(true);
        currentStage.getIcons().add(new Image("/MultimediaResources/pkroylogo.png"));
        currentStage.setTitle("Manage Students - P.K. Roy Memorial College Dhanbad - College Record and Information System v1.1.1");
        currentStage.show();
        
        
        ManageParentAndGuardianBoardFXMLController manageParentAndGuardianBoardFXMLController=loader.getController();
        manageParentAndGuardianBoardFXMLController.fetchUserDetails(gusername);
        
    }
    
    void setUserDetails(String username){
        System.out.println(username+"--------from Student management board");
        gusername=username;
    }
}
