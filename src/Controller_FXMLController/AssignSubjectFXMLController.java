
package Controller_FXMLController;

import Model_Beans.AssignedSubjects;
import Model_Beans.Department;
import Model_Beans.Staff;
import Model_Beans.Subject;
import Model_Services.AcademicManagementServicesImpl;
import Model_Services.StaffManagementServicesImpl;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class AssignSubjectFXMLController implements Initializable {

    @FXML
    private HBox ap;
    @FXML
    private ImageView picIV;
    @FXML
    private Label nameLabel;
    @FXML
    private Label designationLabel;
    @FXML
    private ComboBox<String> facultyNameCB;
    @FXML
    private ComboBox<String> subjectNameCB;
    @FXML
    private ComboBox<String> departmentCB;
    @FXML
    private ComboBox<String> semesterCB;
    @FXML
    private ComboBox<String> positionCB;
    @FXML
    private Button assignSubjectBtn;

    AcademicManagementServicesImpl academicManagementServicesImpl;
    StaffManagementServicesImpl staffManagementServicesImpl;
    List<Staff> facultyList;
    List<Subject> subjectList;
    String sem[]={"1","2","3","4","5","6"};
    String positions[]={"Professor","Associate Professor","Asst. Professor","Lacturer","Lab Assistant"};
    List<Department> departmentList;
    List<String> departmentNameList;
    int facultyId;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        academicManagementServicesImpl=new AcademicManagementServicesImpl();
        staffManagementServicesImpl=new StaffManagementServicesImpl();
        facultyList=new ArrayList<>();
        facultyList=staffManagementServicesImpl.showAllStaff();
        for(Staff faculty:facultyList){   
        facultyNameCB.getItems().add(faculty.getStaffName());
        }
        
        //subjectsCB
        subjectList=new ArrayList<>();
        subjectList=academicManagementServicesImpl.displayAllSubject();
        for(Subject subject:subjectList){
            subjectNameCB.getItems().add(subject.getSubjectCode()+" - "+subject.getSubjectName());
        }
        
        departmentList=academicManagementServicesImpl.showAllDepartments();
        departmentNameList=new ArrayList<>();
        for(Department department:departmentList){
            departmentNameList.add(department.getDepartmentName());
    }
        departmentCB.getItems().addAll(departmentNameList);
        
        //semesterCB
        semesterCB.getItems().addAll(sem);
        
        //positionCB
        positionCB.getItems().addAll(positions);
        
    }    

    @FXML
    private void assignSubject(ActionEvent event) {
        if(validateAllFieldsForEmpty()){
            //facultyId is a global variable
            String facultyName=facultyNameCB.getValue();
            String subjectCode=subjectNameCB.getValue().substring(0, 5).trim();
            String subjectName=subjectNameCB.getValue().substring(6).trim();
            String departement=departmentCB.getValue();
            int semester=Integer.parseInt(semesterCB.getValue());
            String position=positionCB.getValue();
            AssignedSubjects assignedSubjects=new AssignedSubjects(facultyId, facultyName, subjectCode, subjectName, departement, semester, position);
            int row=academicManagementServicesImpl.addAssignedSubject(assignedSubjects);
            if(row>0){
                Notifications.create().title("Subject Assigned Successfully").showInformation();
            }else{
                Notifications.create().title("Subject Not Assigned").showError(); 
            }
        }
    }

    @FXML
    private void facultyNameCBStateChange(ActionEvent event) {
        String facultyName=facultyNameCB.getValue();
        byte[] imageByte = null;
        String designation = null;
        for(Staff staff:facultyList){
            if(staff.getStaffName().equals(facultyName)){
                imageByte=staff.getPic();
                designation=staff.getDesignation();
                facultyId=staff.getStaffId();
            }
        }
//        picIV.setImage(null);
        picIV.setImage(new Image(new ByteArrayInputStream(imageByte)));
        nameLabel.setText(facultyName);
        designationLabel.setText(designation);
    }
    
    
    
    
    boolean validateAllFieldsForEmpty(){
        if(facultyNameCB.getValue()==null){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Faculty Name is required*");
            facultyNameCB.requestFocus();
        }else{
            if(subjectNameCB.getValue()==null){
               Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Subject Name is required*");
                subjectNameCB.requestFocus(); 
            }else{
                if(semesterCB.getValue()==null){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Semester is required*");
                    semesterCB.requestFocus();
                }else{
                    if(positionCB.getValue()==null){
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Position is required*");
                        positionCB.requestFocus();
                    }else{
                        return true;
                    }
                }
            }
        }
        return false;    
    }
    
}
