
package Controller_FXMLController;

import Model_Beans.Department;
import Model_Beans.Routine;
import Model_Beans.Subject;
import Model_Services.AcademicManagementServicesImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class CreateRoutineFXMLController implements Initializable {

    @FXML
    private JFXComboBox<String> departmentCB;
    @FXML
    private JFXComboBox<String> semesterCB;
    @FXML
    private ComboBox<String> sub1CB;
    @FXML
    private ComboBox<String> sub2CB;
    @FXML
    private ComboBox<String> sub3CB;
    @FXML
    private ComboBox<String> sub4CB;
    @FXML
    private ComboBox<String> sub5CB;
    @FXML
    private ComboBox<String> sub6CB;
    @FXML
    private ComboBox<String> sub7CB;
    @FXML
    private ComboBox<String> sub8CB;
    @FXML
    private ComboBox<String> sub9CB;
    @FXML
    private ComboBox<String> sub10CB;
    @FXML
    private ComboBox<String> sub11CB;
    @FXML
    private ComboBox<String> sub12CB;
    @FXML
    private ComboBox<String> sub13CB;
    @FXML
    private ComboBox<String> sub14CB;
    @FXML
    private ComboBox<String> sub15CB;
    @FXML
    private ComboBox<String> sub16CB;
    @FXML
    private ComboBox<String> sub17CB;
    @FXML
    private ComboBox<String> sub18CB;
    @FXML
    private ComboBox<String> sub19CB;
    @FXML
    private ComboBox<String> sub20CB;
    @FXML
    private ComboBox<String> sub21CB;
    @FXML
    private ComboBox<String> sub22CB;
    @FXML
    private ComboBox<String> sub23CB;
    @FXML
    private ComboBox<String> sub24CB;

    AcademicManagementServicesImpl academicManagementServicesImpl;
    List<Department> departmentList;
    List<String> departmentNameList;
    List<Subject> subjectList;
    List<String> subjectNameList;
    String semesters[]={"1","2","3","4","5","6","7","8"};
    @FXML
    private JFXButton submitBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        academicManagementServicesImpl=new AcademicManagementServicesImpl();
        
        //for fetching all department for CB
        departmentList=academicManagementServicesImpl.showAllDepartments();
        departmentNameList=new ArrayList<>();
        for(Department department:departmentList){
            departmentNameList.add(department.getDepartmentName());
        }
        departmentCB.getItems().addAll(departmentNameList);
        semesterCB.getItems().addAll(semesters);
        
        //for fetching all subjects
        subjectList=academicManagementServicesImpl.displayAllSubject();
        subjectNameList=new ArrayList<>();
        for(Subject subject:subjectList){
            subjectNameList.add(subject.getSubjectName());
        }
        //for setting subjects
        sub1CB.getItems().addAll(subjectNameList);
        sub2CB.getItems().addAll(subjectNameList);
        sub3CB.getItems().addAll(subjectNameList);
        sub4CB.getItems().addAll(subjectNameList);
        sub5CB.getItems().addAll(subjectNameList);
        sub6CB.getItems().addAll(subjectNameList);
        sub7CB.getItems().addAll(subjectNameList);
        sub8CB.getItems().addAll(subjectNameList);
        sub9CB.getItems().addAll(subjectNameList);
        sub10CB.getItems().addAll(subjectNameList);
        sub11CB.getItems().addAll(subjectNameList);
        sub12CB.getItems().addAll(subjectNameList);
        sub13CB.getItems().addAll(subjectNameList);
        sub14CB.getItems().addAll(subjectNameList);
        sub15CB.getItems().addAll(subjectNameList);
        sub16CB.getItems().addAll(subjectNameList);
        sub17CB.getItems().addAll(subjectNameList);
        sub18CB.getItems().addAll(subjectNameList);
        sub19CB.getItems().addAll(subjectNameList);
        sub20CB.getItems().addAll(subjectNameList);
        sub21CB.getItems().addAll(subjectNameList);
        sub22CB.getItems().addAll(subjectNameList);
        sub23CB.getItems().addAll(subjectNameList);
        sub24CB.getItems().addAll(subjectNameList);
       
    }    

    @FXML
    private void submit(ActionEvent event) {
        if(validateAllFieldsForEmpty()){
            String department=departmentCB.getValue();
            int semester=Integer.parseInt(semesterCB.getValue());
            String mon_p1_subejct=sub1CB.getValue();
            String mon_p2_subejct=sub2CB.getValue();
            String mon_p3_subejct=sub3CB.getValue();
            String mon_p4_subejct=sub4CB.getValue();
            String tue_p1_subejct=sub5CB.getValue();
            String tue_p2_subejct=sub6CB.getValue();
            String tue_p3_subejct=sub7CB.getValue();
            String tue_p4_subejct=sub8CB.getValue();
            String wed_p1_subejct=sub9CB.getValue();
            String wed_p2_subejct=sub10CB.getValue();
            String wed_p3_subejct=sub11CB.getValue();
            String wed_p4_subejct=sub12CB.getValue();
            String thu_p1_subejct=sub13CB.getValue();
            String thu_p2_subejct=sub14CB.getValue();
            String thu_p3_subejct=sub15CB.getValue();
            String thu_p4_subejct=sub16CB.getValue();
            String fri_p1_subejct=sub17CB.getValue();
            String fri_p2_subejct=sub18CB.getValue();
            String fri_p3_subejct=sub19CB.getValue();
            String fri_p4_subejct=sub20CB.getValue();
            String sat_p1_subejct=sub21CB.getValue();
            String sat_p2_subejct=sub22CB.getValue();
            String sat_p3_subejct=sub23CB.getValue();
            String sat_p4_subejct=sub24CB.getValue();
            Routine routine=new Routine(department, semester, mon_p1_subejct, mon_p2_subejct, mon_p3_subejct, mon_p4_subejct, tue_p1_subejct, tue_p2_subejct, tue_p3_subejct, tue_p4_subejct, wed_p1_subejct, wed_p2_subejct, wed_p3_subejct, wed_p4_subejct, thu_p1_subejct, thu_p2_subejct, thu_p3_subejct, thu_p4_subejct, fri_p1_subejct, fri_p2_subejct, fri_p3_subejct, fri_p4_subejct, sat_p1_subejct, sat_p2_subejct, sat_p3_subejct, sat_p4_subejct);
            int x=academicManagementServicesImpl.addRoutine(routine);
            if(x>0){
                Notifications.create().title("Routine Created Successfully").showInformation();
            }else{
                Notifications.create().title("Not Created").showError();
            }
        }
    }
    
    
    boolean validateAllFieldsForEmpty(){
        if(departmentCB.getValue()==null){
            Notifications.create().title("Department required*").showError();
            departmentCB.requestFocus();
        }else{
            if(semesterCB.getValue()==null){
                Notifications.create().title("Semester required*").showError();
                semesterCB.requestFocus();
            }else{
                if(sub1CB.getValue()==null && sub3CB.getValue()==null && sub4CB.getValue()==null && sub5CB.getValue()==null && sub6CB.getValue()==null && sub7CB.getValue()==null && sub8CB.getValue()==null && sub9CB.getValue()==null && sub10CB.getValue()==null && sub11CB.getValue()==null && sub12CB.getValue()==null && sub13CB.getValue()==null && sub14CB.getValue()==null && sub15CB.getValue()==null && sub16CB.getValue()==null && sub17CB.getValue()==null && sub18CB.getValue()==null && sub19CB.getValue()==null && sub20CB.getValue()==null && sub21CB.getValue()==null && sub22CB.getValue()==null && sub23CB.getValue()==null && sub24CB.getValue()==null){
                    Notifications.create().title("Anyone of Subject required*").showError();
                }else{
                    return true;
                }
            }
        }
        return false;
    }
    
    
}
