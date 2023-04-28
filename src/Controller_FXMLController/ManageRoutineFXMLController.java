
package Controller_FXMLController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class ManageRoutineFXMLController implements Initializable {

    @FXML
    private Tab createRoutineTab;
    @FXML
    private Tab showRoutneTab;
    @FXML
    private Button backBtn;
    
    private String gEmail;
    private String gusertype;
    
    FXMLLoader loader1;
    FXMLLoader loader2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            loader1=new FXMLLoader(getClass().getResource("/View_FXMLGUI/CreateRoutineFXML.fxml"));
            Parent root1=loader1.load();
            createRoutineTab.setContent(root1);
            
            loader2=new FXMLLoader(getClass().getResource("/View_FXMLGUI/ShowRoutineFXML.fxml"));
            Parent root2=loader2.load();
            showRoutneTab.setContent(root2);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }    

    @FXML
    private void backToDashboard(ActionEvent event) {
        
           int flag=JOptionPane.showConfirmDialog(null, "Do you want to go back? All unsaved data will be lost...");
        if(flag==0){
            Stage stage=(Stage)backBtn.getScene().getWindow();
            stage.close();
//            stage=new Stage();
             int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
             int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
            try{
                if(gusertype.equals("Admin")){
                        FXMLLoader loaders=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AdminDashboardFXML.fxml"));
                        Parent root=loaders.load();
                        AdminDashboardFXMLController adminDashboardFXMLController=loaders.getController();
                        if(gEmail!=null){
                            adminDashboardFXMLController.setUserDetails(gEmail);
                        }
                        Scene scene = new Scene(root,screenWidth,screenHeight);
                    
                        stage.setScene(scene);
                        stage.setTitle("Show Routine - Admin - P.K. Roy Memorial College,Dhanbad - College Record and Information System v1.1.1");
                        stage.getIcons().add(new Image("/MultimediaResources/pkroylogo.png")); 
                        stage.setX(0);
                        stage.setY(0);
                        stage.setMaximized(true);
                        stage.show();
                }else if(gusertype.equals("Staff")){
                        FXMLLoader loaders=new FXMLLoader(getClass().getResource("/View_FXMLGUI/StaffDashboardFXML.fxml"));
                        Parent root=loaders.load();
                        StaffDashboardFXMLController staffDashboardFXMLController=loaders.getController();
                        if(gEmail!=null){
                            staffDashboardFXMLController.setUserDetails(gEmail);
                        }
                        Scene scene = new Scene(root,screenWidth,screenHeight);
                    
                        stage.setScene(scene);
                        stage.setTitle("Show Routine - Staff - P.K. Roy Memorial College,Dhanbad - College Record and Information System v1.1.1");
                        stage.getIcons().add(new Image("/MultimediaResources/pkroylogo.png")); 
                        stage.setX(0);
                        stage.setY(0);
                        stage.setMaximized(true);
                        stage.show();
                }
                    
                }catch (IOException ex){
                    ex.printStackTrace();
                }
        }
    }    

    
    
    void setUserDetails(String email,String usertype){
        gEmail=email;
        gusertype=usertype;
        
        ShowRoutineFXMLController showRoutineFXMLController=loader2.getController();
        showRoutineFXMLController.setUserDetails(email, usertype);
    }
}
