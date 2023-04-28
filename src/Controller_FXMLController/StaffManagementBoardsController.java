
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
public class StaffManagementBoardsController implements Initializable {

    @FXML
    private JFXButton btn;

    String gusername;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openMangeStaffBoard(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/ManageStaffBoardFXML.fxml"));
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
        
        ManageStaffBoardFXMLController manageStaffBoardFXMLController=loader.getController();
        manageStaffBoardFXMLController.setUserDetails(gusername);
        
    }
    
    
    void setUserDetails(String username){
        gusername=username;
    }
    
}
