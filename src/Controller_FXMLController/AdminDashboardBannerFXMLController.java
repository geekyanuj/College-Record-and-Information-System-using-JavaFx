
package Controller_FXMLController;

import Model_Services.AcademicManagementServicesImpl;
import Model_Services.StaffManagementServicesImpl;
import Model_Services.StudentManagementServicesImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class AdminDashboardBannerFXMLController implements Initializable {

    @FXML
    private Label totalStudentLabel;
    @FXML
    private Label totalStaffLabel;
    @FXML
    private Label totalSubjectsLabel;
    @FXML
    private Label totalCoursesLabel;
    @FXML
    private Label totalDeptLabel;

    AcademicManagementServicesImpl academicManagementServicesImpl;
    StudentManagementServicesImpl studentManagementServicesImpl;
    StaffManagementServicesImpl staffManagementServicesImpl;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    void fetchAllNumbers(){
        studentManagementServicesImpl=new StudentManagementServicesImpl();
        academicManagementServicesImpl=new AcademicManagementServicesImpl();
        staffManagementServicesImpl=new StaffManagementServicesImpl();
       
        int totalStudents=studentManagementServicesImpl.displayAllStudent().size();
        int totalStaff=staffManagementServicesImpl.showAllStaff().size();
        int totalSubjects=academicManagementServicesImpl.displayAllSubject().size();
        int totalCourses=academicManagementServicesImpl.displayAllCourse().size();
        int totalDepartments=academicManagementServicesImpl.showAllDepartments().size();
        
        totalStudentLabel.setText(totalStudents+"");
        totalStaffLabel.setText(totalStaff+"");
        totalSubjectsLabel.setText(totalSubjects+"");
        totalCoursesLabel.setText(totalCourses+"");
        totalDeptLabel.setText(totalDepartments+"");
    }
}
