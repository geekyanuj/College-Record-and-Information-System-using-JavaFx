
package Controller_FXMLController;

import Model_Beans.Subject;
import Model_Services.AcademicManagementServicesImpl;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class ManageSubjectBoardFXMLController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Label subjectCountLabel;
    
    private String gusername;
    @FXML
    private TableView<Object> subjectDispalyTV;
    @FXML
    private TableColumn<Subject, String> subjectCodeCol;
    @FXML
    private TableColumn<Subject, String> subjectNameCol;
    @FXML
    private TableColumn<Subject, String> subjectTypeCol;
    @FXML
    private TableColumn<Subject, Integer> semesterCol;
    @FXML
    private TableColumn<Subject, Integer> subjectTheoryMarksCol;
    @FXML
    private TableColumn<Subject, Integer> subjectPracticalMarksCol;
    @FXML
    private TableColumn<Subject, Integer> subjectTotalMarksCol;
    @FXML
    private TableColumn<Object, Object> subjectActionCol;

    AcademicManagementServicesImpl academicManagementServicesImpl;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subjectCodeCol.setCellValueFactory(new PropertyValueFactory<>("subjectCode"));
        subjectNameCol.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        subjectTypeCol.setCellValueFactory(new PropertyValueFactory<>("subjectType"));
        semesterCol.setCellValueFactory(new PropertyValueFactory<>("semester"));
        subjectTheoryMarksCol.setCellValueFactory(new PropertyValueFactory<>("subjectTheoryMarks"));
        subjectPracticalMarksCol.setCellValueFactory(new PropertyValueFactory<>("subjectPracticalMarks"));
        subjectTotalMarksCol.setCellValueFactory(new PropertyValueFactory<>("subjectTotalMarks"));
        subjectActionCol.setCellValueFactory(new PropertyValueFactory<>("Action"));
        
        loadAndRefreshTable();
    }    

    @FXML
    private void openAddSubject(ActionEvent event) throws IOException {
       Parent root;
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_FXMLGUI/AddSubjectFXML.fxml"));
       root=loader.load();
             
            Stage stage;
             
             Scene scene = new Scene(root, 600, 700);
            stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Manage Subject");
            stage.getIcons().add(new Image("/MultimediaResources/loginPageTitleIcon.png"));
            stage.setScene(scene);
            stage.showAndWait();
    }
    
    @FXML
    private void openAssignSubjectToFaculty(ActionEvent event) throws IOException {
        Parent root;
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_FXMLGUI/AssignSubjectToFacultyFXML.fxml"));
       root=loader.load();
             
            Stage stage;
             
             Scene scene = new Scene(root, 500, 600);
            stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Manage Subject");
            stage.getIcons().add(new Image("/MultimediaResources/loginPageTitleIcon.png"));
            stage.setScene(scene);
            stage.showAndWait();
    }

    @FXML
    private void backToDashboard(ActionEvent event) {
        int flag=JOptionPane.showConfirmDialog(null, "Do you want to go back? All unsaved data will be lost...");
        if(flag==0){
            Stage stage=(Stage)subjectCountLabel.getScene().getWindow();
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
    
    void loadAndRefreshTable(){
        subjectDispalyTV.getItems().clear();
        academicManagementServicesImpl=new AcademicManagementServicesImpl();
        List<Subject> subjectList=academicManagementServicesImpl.displayAllSubject();
        int rowCount=0;
        for(Subject subject:subjectList){
            subjectDispalyTV.getItems().add(subject);
            rowCount++;
        }
        subjectCountLabel.setText(rowCount+"");
    }
    


    @FXML
    private void refreshTable(ActionEvent event) {
        
        loadAndRefreshTable();
    }

    void setUserDetails(String username){
        gusername=username;
    }

    
    
}
