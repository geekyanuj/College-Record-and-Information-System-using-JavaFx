
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

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class AcademicManagementBoardsController implements Initializable {

    @FXML
    private JFXButton btn;

    
    private String gusertype;
    private String gEmail;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void openManageDepartment(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/ManageDepartmentBoardFXML.fxml"));
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
      
        ManageDepartmentBoardFXMLController manageDepartmentBoardFXMLController=loader.getController();
        manageDepartmentBoardFXMLController.fetchUserDetails(gEmail);
    }
  
    @FXML
    private void openManageSubjects(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/ManageSubjectBoardFXML.fxml"));
        
        Parent root=loader.load();
        Stage currentsStage=(Stage)btn.getScene().getWindow();
        currentsStage.hide();
        
        Stage currentStage=new Stage();
        Scene scene=new Scene(root);

        currentStage.setUserData(currentsStage);
        
        currentStage.setScene(scene);
        currentStage.setMaximized(true);
        currentStage.getIcons().add(new Image("/MultimediaResources/pkroylogo.png"));
        currentStage.setTitle("Manage Subject - P.K. Roy Memorial College Dhanbad - Smart-Ed College ERP v1.1.1");
        currentStage.show();
       
        ManageSubjectBoardFXMLController manageSubjectBoardFXMLController=loader.getController();
        manageSubjectBoardFXMLController.setUserDetails(gEmail);
    }
    
    @FXML
    private void openManageCourses(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/ManageCourseBoardFXML.fxml"));
        
        Parent root=loader.load();
        Stage currentsStage=(Stage)btn.getScene().getWindow();
        currentsStage.hide();
        
        Stage currentStage=new Stage();
        Scene scene=new Scene(root);

        currentStage.setUserData(currentsStage);
        
        currentStage.setScene(scene);
        currentStage.setMaximized(true);
        currentStage.getIcons().add(new Image("/MultimediaResources/pkroylogo.png"));
        currentStage.setTitle("Manage Course - P.K. Roy Memorial College Dhanbad - Smart-Ed College ERP v1.1.1");
        currentStage.show();
 
       ManageCourseBoardFXMLController manageCourseBoardFXMLController=loader.getController();
       manageCourseBoardFXMLController.setUserDetails(gEmail);
    }

    @FXML
    private void openManageRoutine(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/ManageRoutineFXML.fxml"));
        
        Parent root=loader.load();
        Stage currentsStage=(Stage)btn.getScene().getWindow();
        currentsStage.hide();
        
        Stage currentStage=new Stage();
        Scene scene=new Scene(root);

        currentStage.setUserData(currentsStage);
        
        currentStage.setScene(scene);
        currentStage.setMaximized(true);
        currentStage.getIcons().add(new Image("/MultimediaResources/pkroylogo.png"));
        currentStage.setTitle("Manage Routine - P.K. Roy Memorial College Dhanbad - Smart-Ed College ERP v1.1.1");
        currentStage.show();
        
        
        ManageRoutineFXMLController manageRoutineFXMLController=loader.getController();
        manageRoutineFXMLController.setUserDetails(gEmail,gusertype);
    }
       
     void setUserDetails(String email,String usertype){
        System.out.println(email+"--------from Academic management board");
        gEmail=email;
        gusertype=usertype;
    }

}
