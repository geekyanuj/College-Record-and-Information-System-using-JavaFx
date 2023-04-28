
package Controller_FXMLController;

import Model_Services.StudentManagementServicesImpl;
import Model_Beans.Student;
import com.jfoenix.controls.JFXButton;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class DisplayStudent1FXMLController implements Initializable {

    @FXML
    private TextField studentIdTF;
    @FXML
    private JFXButton findStudentBtn;
    @FXML
    private TableView<Object> display1TableView;
    @FXML
    private ImageView profilePicImageView;

    
    StudentManagementServicesImpl studentManagementServicesImpl;
    List<Student> studentList;
    
    @FXML
    private TableColumn<Student, Integer> sudentIdCol;
    @FXML
    private TableColumn<Student, String> nameCol;
    @FXML
    private TableColumn<Student, String> fatherNameCol;
    @FXML
    private TableColumn<Student, String> dobCol;
    @FXML
    private TableColumn<Student, String> genderCol;
    @FXML
    private TableColumn<Student, String> mobileNoCol;
    @FXML
    private TableColumn<Student, String> emailCol;
    @FXML
    private TableColumn<Student, String> admissionDateCol;
    @FXML
    private TableColumn<Student, String> semesterCol;
    @FXML
    private TableColumn<Student, String> departmentCol;
    @FXML
    private TableColumn<Student, String> sessionCol;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentManagementServicesImpl=new StudentManagementServicesImpl();
        
        sudentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        fatherNameCol.setCellValueFactory(new PropertyValueFactory<>("fatherName"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        mobileNoCol.setCellValueFactory(new PropertyValueFactory<>("mobileNo"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        admissionDateCol.setCellValueFactory(new PropertyValueFactory<>("admission_on"));
        semesterCol.setCellValueFactory(new PropertyValueFactory<>("current_semester"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        sessionCol.setCellValueFactory(new PropertyValueFactory<>("session"));

        
        showAllStudents(new ActionEvent());
        
    }    

    @FXML
    private void findStudentUsingStudentId(ActionEvent event) {
        studentManagementServicesImpl = new StudentManagementServicesImpl();
        
        if(! studentIdTF.getText().isEmpty()){
            int studentId=Integer.parseInt(studentIdTF.getText().trim());
            
            Student student = studentManagementServicesImpl.displayStudentUsingStudentId(studentId);
            if(student.getStudentId()!=0 && student.getStudentId()==studentId){
                display1TableView.getItems().clear();
                display1TableView.getItems().add(student);
                ByteArrayInputStream bis=new ByteArrayInputStream(student.getProfilePic());
                profilePicImageView.setImage(new Image(bis));
                
            }else{
                Notifications.create().position(Pos.TOP_CENTER).title("Student not Found...").text("Please check Student Id").showError();
                studentIdTF.requestFocus();
            }
        }else{
            Notifications.create().position(Pos.TOP_CENTER).title("Student Id is required*").text("Please Enter Student Id").showError();
            studentIdTF.requestFocus();
        }
        
        
    }

    @FXML
    private void showAllStudents(ActionEvent event) {
        studentList=new ArrayList<>();
        studentList=studentManagementServicesImpl.displayAllStudent();
        display1TableView.getItems().clear();
        for(int i=0;i<studentList.size();i++){
            Student student=studentList.get(i);           
            display1TableView.getItems().add(i,student); 
        }
    }
    
}
