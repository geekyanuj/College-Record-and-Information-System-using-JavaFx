
package Controller_FXMLController;

import Model_Beans.Subject;
import Model_Services.AcademicManagementServicesImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class AddSubjectFXMLController implements Initializable {

    @FXML
    private HBox ap;
    @FXML
    private JFXComboBox<String> subjectTypeCB;
    @FXML
    private JFXTextField subjectCodeTF;
    @FXML
    private JFXTextField subjectNameTF;
    @FXML
    private JFXTextField subjectTheoryMarksTF;
    @FXML
    private JFXTextField subjectPracticalMarksTF;
    @FXML
    private JFXTextField subjectTotalMarksTF;
    @FXML
    private Button addSubjectBtn;
    @FXML
    private JFXTextField semesterTF;
    
    AcademicManagementServicesImpl academicManagementServicesImpl;
    String subjectTypes[]={"Core","Elective","General"};
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        academicManagementServicesImpl=new AcademicManagementServicesImpl();
        subjectTypeCB.getItems().addAll(subjectTypes);
    }    

    @FXML
    private void addSubject(ActionEvent event) {
        if(validateAllFields()){
            String subjectType=subjectTypeCB.getValue();
            String subjectCode=subjectCodeTF.getText();
            String subjectName=subjectNameTF.getText();
            if(semesterTF.getText().matches("^[0-9]") && semesterTF.getText().length()==1){
                int semester=Integer.parseInt(semesterTF.getText());
                int subjectTheoryMarks=Integer.parseInt(subjectTheoryMarksTF.getText());
                int subjectPracticalMarks=Integer.parseInt(subjectPracticalMarksTF.getText());
                int subjectTotalMarks=Integer.parseInt(subjectTotalMarksTF.getText());
                
                Subject subject=new Subject(subjectCode, subjectName, subjectType, subjectTheoryMarks, subjectPracticalMarks, subjectTotalMarks,semester);
                int x=academicManagementServicesImpl.addSubject(subject);
                if(x>0){
                    Notifications.create().position(Pos.TOP_RIGHT).title("Subject Added Successfully").showInformation();
                    subjectTypeCB.setValue(null);
                    subjectCodeTF.clear();
                    subjectNameTF.clear();
                    subjectTheoryMarksTF.clear();
                    subjectPracticalMarksTF.clear();
                    subjectTotalMarksTF.clear();
                }else{
                    Notifications.create().position(Pos.TOP_RIGHT).title("Subject not added").showError();
                }
                
            }else{
                Notifications.create().position(Pos.TOP_RIGHT).title("Semeseter is not valid").showError();
                semesterTF.requestFocus();
            }
            
            
            
        }
    }
    
    
    boolean validateAllFields(){
        if(subjectTypeCB.getValue()==null){
            Notifications.create().position(Pos.TOP_RIGHT).title("Subject Type is required*").showError();
            subjectTypeCB.requestFocus();
        }else{
            if(subjectCodeTF.getText().isEmpty()){
                Notifications.create().position(Pos.TOP_RIGHT).title("Subject Code is required*").showError();
                subjectCodeTF.requestFocus();
            }else{
                if(subjectNameTF.getText().isEmpty()){
                    Notifications.create().position(Pos.TOP_RIGHT).title("Subject Name is required*").showError();
                    subjectNameTF.requestFocus();
                }else{
                    if(semesterTF.getText().isEmpty()){
                        Notifications.create().position(Pos.TOP_RIGHT).title("Semester is required*").showError();
                            semesterTF.requestFocus();
                    }else{
                        if(subjectTheoryMarksTF.getText().isEmpty()){
                            Notifications.create().position(Pos.TOP_RIGHT).title("Theory Marks is required*").showError();
                            subjectTheoryMarksTF.requestFocus();
                        }else{
                            if(subjectPracticalMarksTF.getText().isEmpty()){
                                Notifications.create().position(Pos.TOP_RIGHT).title("Practical Marks is required*").showError();
                             subjectPracticalMarksTF.requestFocus();
                            }else{
                                if(subjectTotalMarksTF.getText().isEmpty()){
                                    Notifications.create().position(Pos.TOP_RIGHT).title("Total Marks is required*").showError();
                                    subjectTotalMarksTF.requestFocus();
                                }else{
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
