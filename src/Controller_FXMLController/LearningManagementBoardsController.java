
package Controller_FXMLController;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class LearningManagementBoardsController implements Initializable {

    @FXML
    private JFXButton btn;
    private String gusername;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openMangeContentSharingBoard(ActionEvent event) {
    }

    @FXML
    private void openManageAssignmentsBoard(ActionEvent event) {
    }
    
    
    void setUserDetails(String username){
        System.out.println(username+"--------from Academic management board");
        gusername=username;
    }
}
