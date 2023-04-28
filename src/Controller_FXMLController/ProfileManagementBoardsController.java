
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
public class ProfileManagementBoardsController implements Initializable {

    @FXML
    private JFXButton btn;
    private String gEmail;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void openMangePersonalDetailsBoard(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/ManagePersonalDetailsBoardFXML.fxml"));
        Parent root=loader.load();
        Stage currentsStage=(Stage)btn.getScene().getWindow();
        currentsStage.hide();
        
        Stage currentStage=new Stage();
        Scene scene=new Scene(root);

        currentStage.setUserData(currentsStage);
        
        currentStage.setScene(scene);
        currentStage.setMaximized(true);
        currentStage.getIcons().add(new Image("/MultimediaResources/pkroylogo.png"));
        currentStage.setTitle("Manage Profile - P.K. Roy Memorial College Dhanbad - College Record and Information System v1.1.1");
        currentStage.show();
        
        ManagePersonalDetailsBoardFXMLController managePersonalDetailsBoardFXMLController=loader.getController();
        managePersonalDetailsBoardFXMLController.setUserDetails(gEmail);
//        UpdateStudent1FXMLController updateStudent1FXMLController=loader.getController();
//        updateStudent1FXMLController.setUserDetails(gEmail);
//        updateStudent1FXMLController.setStudentDetails(gEmail);
//        updateStudent1FXMLController.setBackButton();
    }

    @FXML
    private void openManageParentDetailsBoard(ActionEvent event) {
    }
    
    void setUserDetails(String email){
        System.out.println(email+"--------from Academic management board");
        gEmail=email;
    }
}
