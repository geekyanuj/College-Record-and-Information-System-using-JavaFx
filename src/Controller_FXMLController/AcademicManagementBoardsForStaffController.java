
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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class AcademicManagementBoardsForStaffController implements Initializable {

    @FXML
    private JFXButton btn;
    private String gEmail;
    private String gusertype;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showAssignedSubjects(ActionEvent event) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/ShowAssignedSubjectsFXML.fxml"));
            Parent root =loader.load();
            ShowAssignedSubjectsFXMLController showAssignedSubjectsFXMLController=loader.getController();
            showAssignedSubjectsFXMLController.setUserDetails(gEmail);
            Scene scene = new Scene(root, 988, 542);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("My Subjects - Staff - College Record and Information System v1.1.1");
            stage.getIcons().add(new Image("/MultimediaResources/loginPageTitleIcon.png"));
            stage.setScene(scene);
            
            stage.showAndWait();
        
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    @FXML
    private void showRoutine(ActionEvent event) throws IOException {
        Parent root;
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_FXMLGUI/ShowRoutineFXML.fxml"));
             root=loader.load();
             
             
             Scene scene = new Scene(root, 1355, 750);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Show Routine");
            stage.getIcons().add(new Image("/MultimediaResources/loginPageTitleIcon.png"));
            stage.setScene(scene);
            stage.showAndWait();
    }
   
   void setUserDetails(String email,String usertype){
        System.out.println(email+"--------from Academic management board");
        gEmail=email;
        gusertype=usertype;
    }

}
