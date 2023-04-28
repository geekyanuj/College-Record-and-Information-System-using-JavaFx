
package Controller_FXMLController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class ManagePersonalDetailsBoardFXMLController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Button backBtn;
    
    private String gEmail;
    FXMLLoader loader;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/UpdateStudent1FXML.fxml"));
            Parent root=loader.load();
            bp.setCenter(root);

        } catch (IOException ex){
           ex.printStackTrace();
        }
    }    

    @FXML
    private void backToDashboard(ActionEvent event) throws IOException {

        int flag=JOptionPane.showConfirmDialog(null, "Do you want to go back? All unsaved data will be lost...");
        if(flag==0){
            Stage stage=(Stage)bp.getScene().getWindow();
            stage.close();
            stage=new Stage();
             int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
             int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
            try{
                    FXMLLoader loaders=new FXMLLoader(getClass().getResource("/View_FXMLGUI/StudentDashboardFXML.fxml"));
                    Parent root=loaders.load();
                    StudentDashboardFXMLController studentDashboardFXMLController=loaders.getController();
                    if(gEmail!=null){
                        studentDashboardFXMLController.setUserDetails(gEmail);
                    }
                    Scene scene = new Scene(root,screenWidth,screenHeight);
                    
                    stage.setScene(scene);
                    stage.setTitle("Student - P.K. Roy Memorial College,Dhanbad - College Record and Information System v1.1.1");
                    stage.getIcons().add(new Image("/MultimediaResources/pkroylogo.png")); 
                    stage.setX(0);
                    stage.setY(0);
                    stage.setMaximized(true);
                    stage.show();
                    
                    
                }catch (IOException ex){
                    ex.printStackTrace();
                }
        }
    }
    
    void setUserDetails(String email){
        gEmail=email;
        
            UpdateStudent1FXMLController updateStudent1FXMLController=loader.getController();
            updateStudent1FXMLController.setUserDetails(gEmail);
            updateStudent1FXMLController.setStudentDetails(gEmail);
    }
}
