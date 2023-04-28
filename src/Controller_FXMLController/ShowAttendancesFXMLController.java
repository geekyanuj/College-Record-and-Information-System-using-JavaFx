
package Controller_FXMLController;

import Model_Beans.Department;
import Model_Beans.StudentAttendance;
import Model_Services.AcademicManagementServicesImpl;
import Model_Services.AttendanceManagementServicesImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class ShowAttendancesFXMLController implements Initializable {

    @FXML
    private JFXDatePicker dateCB;
    @FXML
    private JFXComboBox<String> departmentCB;
    @FXML
    private JFXComboBox<String> semesterCB;
    @FXML
    private TableView<Object> tableView;
    @FXML
    private TableColumn<StudentAttendance, Integer> idCol;
    @FXML
    private TableColumn<StudentAttendance, String> nameCol;
    @FXML
    private TableColumn<StudentAttendance, String> departmentCol;
    @FXML
    private TableColumn<StudentAttendance, Integer> semesterCol;
    @FXML
    private TableColumn<StudentAttendance, Character> statusCol;

    AttendanceManagementServicesImpl attendanceManagementServicesImpl;
    AcademicManagementServicesImpl academicManagementServicesImpl;
    
    List<Department> departmentList;
    List<String> departmentNameList;
    String semesters[]={"1","2","3","4","5","6","7","8"};
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        attendanceManagementServicesImpl=new AttendanceManagementServicesImpl();
        academicManagementServicesImpl=new AcademicManagementServicesImpl();
        
        //for fetching all department for CB
        departmentList=academicManagementServicesImpl.showAllDepartments();
        departmentNameList=new ArrayList<>();
        for(Department department:departmentList){
            departmentNameList.add(department.getDepartmentName());
        }
        departmentCB.getItems().addAll(departmentNameList);
        semesterCB.getItems().addAll(semesters);
        //adding table properties 
        idCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        semesterCol.setCellValueFactory(new PropertyValueFactory<>("semester"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }    

    boolean validateAllFieldsForEmpty(){
        if(dateCB.getValue()==null){
            Notifications.create().title("Date is required*").showError();
        }else{
            if(departmentCB.getValue()==null){
                Notifications.create().title("Department is required*").showError();
            }else{
                if(semesterCB.getValue()==null){
                    Notifications.create().title("Semester is required*").showError();
                }else{
                    return true;
                }
            }
        }
        return false;
    }
    
    @FXML
    private void fetchStudent(ActionEvent event) {
        if(validateAllFieldsForEmpty()){
            Date date=Date.valueOf(dateCB.getValue());
            String department=departmentCB.getValue();
            int semester=Integer.parseInt(semesterCB.getValue());
            List<StudentAttendance> studentAttendanceList=attendanceManagementServicesImpl.getStudentAttendanceListUsingDate(date, department, semester);
            if(studentAttendanceList.isEmpty()){
                Notifications.create().title("No data found against this criteria ").showError();
            }else{
                tableView.getItems().clear();
                tableView.getItems().addAll(studentAttendanceList);
              
            }
        }
    }

}
