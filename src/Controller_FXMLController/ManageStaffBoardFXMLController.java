
package Controller_FXMLController;

import Model_Beans.Staff;
import Model_Services.StaffManagementServicesImpl;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class ManageStaffBoardFXMLController implements Initializable {
//    Staff staff;
    List<Staff> staffList;
    StaffManagementServicesImpl staffManagementServicesImpl;

    @FXML
    private BorderPane bp;
    @FXML
    private ScrollPane ap;
    @FXML
    private Button backBtn;
    
    
    String gusername;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        staffManagementServicesImpl=new StaffManagementServicesImpl();
        staffList=new ArrayList<>();
        loadImageView();
    }    
    
    
    ImageView createImageView(byte[] pic){
        ImageView imageView = null;
        try {
            Image image = new Image(new ByteArrayInputStream(pic), 150, 0, true,true);
            imageView = new ImageView(image);
            imageView.setFitWidth(134);
            imageView.setFitHeight(150);
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return imageView;
    }

    void loadImageView(){
        bp.setCenter(ap);
        staffList=staffManagementServicesImpl.showAllStaff();
        TilePane tile = new TilePane();

        tile.setPadding(new Insets(15, 15, 15, 15));
        tile.setHgap(15);  
        for(Staff staff:staffList){
            ImageView imageView=createImageView(staff.getPic());
            Label nameLabel=new Label(staff.getStaffName());
            Label designationLabel=new Label("("+staff.getDesignation()+")");
            VBox vBox=new VBox();
            vBox.setAlignment(Pos.CENTER);
            vBox.setPrefSize(134, 158);
            vBox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;"+
                "-fx-border-insets: 5;"+
                "-fx-border-radius: 8;" +
                "-fx-border-color: black;");
            vBox.getChildren().addAll(imageView,nameLabel,designationLabel);
            tile.setTileAlignment(Pos.TOP_CENTER);
            tile.getChildren().add(vBox);     
        }
        ap.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Horizontal
        ap.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Vertical scroll bar
        ap.setFitToWidth(true);
        ap.setContent(tile);
    }
    @FXML
    private void backToDashboard(ActionEvent event) {
        int flag=JOptionPane.showConfirmDialog(null, "Do you want to go back? All unsaved data will be lost...");
        if(flag==0){
            Stage stage=(Stage)bp.getScene().getWindow();
            stage.close();
            stage=(Stage) stage.getUserData();
            stage.setMaximized(true);
            stage.show();
             int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
             int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
            try{
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AdminDashboardFXML.fxml"));
                    Parent root=loader.load();
                    AdminDashboardFXMLController adminDashboardFXMLController=loader.getController();
                    if(gusername!=null){
                        adminDashboardFXMLController.setUserDetails(gusername);
                    }
                    Scene scene = new Scene(root,screenWidth,screenHeight);
                    
                    stage.setScene(scene);
                    stage.setTitle("Admin - P.K. Roy Memorial College,Dhanbad  Smart-Ed College ERP v1.1.1");
                    stage.setX(0);
                    stage.setY(0);
                   
          
                    stage.show();
            }catch(Exception ex){
                ex.printStackTrace();;
            }
        }
    }

    @FXML
    private void openAddStaffDialog(ActionEvent event) throws IOException {
        Parent root;
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_FXMLGUI/AddStaffFXML.fxml"));
             root=loader.load();
            Stage stage=(Stage)bp.getScene().getWindow();
            Scene scene = new Scene(root, 839, 700);
            stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add Staff");
            stage.getIcons().add(new Image("/MultimediaResources/staffIcon.png"));
            stage.setScene(scene);
            stage.showAndWait();
    }
    
 
    void setUserDetails(String username){
        gusername=username;
    }

    @FXML
    private void loadPhotoView(ActionEvent event) {
        loadImageView();
    }

    @FXML
    private void loadTableView(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/DisplayStaffFXML.fxml"));
        Parent root=loader.load();
        bp.setCenter(root);
    }
}
