
package Controller_FXMLController;

import Model_Beans.AssignedSubjects;
import Model_Beans.LoginUser;
import Model_Services.AcademicManagementServicesImpl;
import Model_Services.LoginPageServicesImpl;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class ShowAssignedSubjectsFXMLController implements Initializable {

    @FXML
    private TableView<Object> tableView;
    @FXML
    private TableColumn<AssignedSubjects, String> subjectCodeCol;
    @FXML
    private TableColumn<AssignedSubjects, String> subjectNameCol;
    @FXML
    private TableColumn<AssignedSubjects, String> departmentCol;
    @FXML
    private TableColumn<AssignedSubjects, String> positionCol;
    @FXML
    private TableColumn<AssignedSubjects, Integer> semesterCol;

    AcademicManagementServicesImpl academicManagementServicesImpl;
    LoginPageServicesImpl loginPageServicesImpl=new LoginPageServicesImpl();
    LoginUser loginUser;
    private String gEmail;
    private int gfacultyId;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subjectCodeCol.setCellValueFactory(new PropertyValueFactory<>("subjectCode"));
        subjectNameCol.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>(""));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        semesterCol.setCellValueFactory(new PropertyValueFactory<>("sem"));

    }    
    
    
    void setUserDetails(String email){
        gEmail=email;
        loginUser = loginPageServicesImpl.doLoginAsStaff(email);
        gfacultyId=loginUser.getUserid();
        setDataToTable();
    }
    
    void setDataToTable(){
        academicManagementServicesImpl=new AcademicManagementServicesImpl();
       List<AssignedSubjects> assignedSubjectList=academicManagementServicesImpl.displayAssignedSubject(gfacultyId);
       tableView.getItems().clear();
       tableView.getItems().addAll(assignedSubjectList);
    }
}
