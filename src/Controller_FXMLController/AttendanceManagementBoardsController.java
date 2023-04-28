
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
public class AttendanceManagementBoardsController implements Initializable {

    @FXML
    private JFXButton btn;
    private String gemail;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void openMarkDepartmentwiseStudentAttendanceBoard(ActionEvent event) {
        Parent loader;     
        try{
            loader = FXMLLoader.load(getClass().getResource("/View_FXMLGUI/MarkDepartmentwiseStudentAttendanceFXML.fxml"));
            Scene scene = new Scene(loader, 988, 735);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Mark Attendance - Staff - College Record and Information System v1.1.1");
            stage.getIcons().add(new Image("/MultimediaResources/loginPageTitleIcon.png"));
            stage.setScene(scene);
            
            stage.showAndWait();
        
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    @FXML
    private void openManageLabAttendanceBoard(ActionEvent event) {
    }

    @FXML
    private void openIssueAttendaceReportBoard(ActionEvent event) {
    }

@FXML
    private void openShowStudentAttendancesBoard(ActionEvent event) {
        Parent loader;     
        System.err.println("reached showattendance");
        try{
            loader = FXMLLoader.load(getClass().getResource("/View_FXMLGUI/ShowAttendancesFXML.fxml"));
            Scene scene = new Scene(loader, 988, 735);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Show Attendance - Staff - College Record and Information System v1.1.1");
            stage.getIcons().add(new Image("/MultimediaResources/loginPageTitleIcon.png"));
            stage.setScene(scene);
            
            stage.showAndWait();
        
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    void setUserDetails(String email){
        System.out.println(email+"--------from Academic management board");
        
        gemail=email;
    }

    



   
}
