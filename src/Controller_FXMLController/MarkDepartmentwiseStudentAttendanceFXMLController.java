
package Controller_FXMLController;

import Model_Beans.Department;
import Model_Beans.Student;
import Model_Beans.StudentAttendance;
import Model_Services.AcademicManagementServicesImpl;
import Model_Services.AttendanceManagementServicesImpl;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class MarkDepartmentwiseStudentAttendanceFXMLController implements Initializable {

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
    private TableColumn<StudentAttendance, Pane> statusCol;
    @FXML
    private Label timeLabel;
    @FXML
    private Label currentdateLabel;
    @FXML
    private JFXComboBox<String> departmentCB;
    @FXML
    private JFXComboBox<String> semesterCB;
    
    AttendanceManagementServicesImpl attendanceManagementServicesImpl;
    AcademicManagementServicesImpl academicManagementServicesImpl;
    
    List<Department> departmentList;
    List<String> departmentNameList;
    String semesters[]={"1","2","3","4","5","6","7","8"};
    Date currentDate;
//    
//    RadioButton presentRadio;
//    RadioButton absentRadio;
//    ToggleGroup toggleGroup;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      initDate();
      initClock();
      attendanceManagementServicesImpl=new AttendanceManagementServicesImpl();
      academicManagementServicesImpl=new AcademicManagementServicesImpl();
     
       
        idCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        semesterCol.setCellValueFactory(new PropertyValueFactory<>("semester"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("pane"));

        //for fetching all department for CB
        departmentList=academicManagementServicesImpl.showAllDepartments();
        departmentNameList=new ArrayList<>();
        for(Department department:departmentList){
            departmentNameList.add(department.getDepartmentName());
        }
        
        departmentCB.getItems().addAll(departmentNameList);
        semesterCB.getItems().addAll(semesters);
        
//       
        
        
       
        
    }    
    
    private void initClock() {

    Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->  
         timeLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
    ),
         new KeyFrame(Duration.seconds(1))
    );
    clock.setCycleCount(Animation.INDEFINITE);
    clock.play();
    }  
    
    private void initDate() {
       DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
       Calendar calendar=Calendar.getInstance();
       String date=formatter.format(calendar.getTime());
       currentdateLabel.setText(date);
//       DateFormat formatter2=new SimpleDateFormat("YYYY-MM-DD");
//       String date2=formatter2.format(calendar.getTime());
//       currentDate=Date.valueOf(date2);
       currentDate=new Date(Calendar.getInstance().getTime().getTime());
    }  

    @FXML
    private void fetchStudent(ActionEvent event) {
        if(validateAllFieldsForEmpty()){
           
            String department=departmentCB.getValue();
            int semester=Integer.parseInt(semesterCB.getValue());
            List<Student> studentList=attendanceManagementServicesImpl.getAllStudentUsingSemesterAndCourse(department, semester);
            tableView.setVisible(true);
            tableView.getItems().clear();
            for(Student student:studentList){
                tableView.getItems().add(new StudentAttendance(student.getStudentId(), student.getStudentName(), student.getCourse_enrolled(), student.getCurrent_semester(), new Pane()));
            }
        }
         
    }
    
    
    boolean validateAllFieldsForEmpty(){
        if(departmentCB.getValue()==null){
            Notifications.create().position(Pos.TOP_RIGHT).title("Department Required*").showError();
        }else{
            if(semesterCB.getValue()==null){
                Notifications.create().position(Pos.TOP_RIGHT).title("Semester Required*").showError();
            }else{
                return true;
            }
        }
        return false;
    }

    @FXML
    private void submit(ActionEvent event) {
        List<StudentAttendance> studentAttendanceListTemp=new ArrayList<>();
        for(int i=0;i<tableView.getItems().size();i++){
            studentAttendanceListTemp.add((StudentAttendance) tableView.getItems().get(i)); 
        }  
        List<StudentAttendance> studentAttendanceList=new ArrayList<>();
        for(StudentAttendance studentAttendance:studentAttendanceListTemp){
            ObservableList<Node> nodeListOfPane=studentAttendance.getPane().getChildren(); 
            RadioButton presentRadio=(RadioButton) nodeListOfPane.get(0);
            RadioButton absentRadio=(RadioButton) nodeListOfPane.get(1);
           
            char status;
            if(presentRadio.isSelected()){
                status='P';
            }else if(absentRadio.isSelected()){
                status='A';
            }else{
                status='-';
            }
            
            studentAttendanceList.add(new StudentAttendance(studentAttendance.getStudentId(), studentAttendance.getName(), studentAttendance.getDepartment(), studentAttendance.getSemester(), currentDate, status));
        }

        
        int row=attendanceManagementServicesImpl.setAndAddStudentAttendance(studentAttendanceList);
        if(row>0){
            Notifications.create().title("Sumbmitted Successfully").showInformation();
        }else{
            Notifications.create().title("Not Updated*").showError();
        }
       
        
    }
    
       
}
