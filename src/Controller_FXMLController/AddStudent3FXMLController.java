
package Controller_FXMLController;

import Model_Beans.StudentPreviousAcademicDetails;
import Model_Beans.Subject;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class AddStudent3FXMLController implements Initializable {

    @FXML
    private JFXTextField lastPassedExaminationTF;
    @FXML
    private JFXTextField streamNameTF;
    @FXML
    private JFXComboBox<String> courseMediumComboBox;
    @FXML
    private JFXComboBox<String> courseTypeComboBox;
    @FXML
    private JFXTextField passingYearTF;
    @FXML
    private JFXTextField marksPercentTF;
    @FXML
    private JFXTextField boardNameTF;
    @FXML
    private JFXTextField schoolNameTF;
    @FXML
    private TableView<Object> subjectTableView;
    @FXML
    private TextField subjectNameTF;
    @FXML
    private TextField marksSecuredTF;
    @FXML
    private Button addSubjectBtn;
    @FXML
    private Button RemoveSubjectBtn;
    @FXML
    private TableColumn<Subject, String> subjectNameColumn;
    @FXML
    private TableColumn<Subject, String> marksSecuredColumn;
    @FXML
    private TableColumn<Integer, String> slNoColumn;
    
    
    String courseMediums[]={"English","Hindi","Others"};
    String courseTypes[]={"Attending","Distant"};


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       courseMediumComboBox.getItems().addAll(courseMediums);
       courseTypeComboBox.getItems().addAll(courseTypes);
       
       subjectNameColumn.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
       marksSecuredColumn.setCellValueFactory(new PropertyValueFactory<>("marksSecured"));
       slNoColumn.setCellValueFactory(new PropertyValueFactory<>("slNo"));
       
    }    

    @FXML
    private void addSubjectToTable(ActionEvent event) {
        String subjectName=subjectNameTF.getText();
        String marksSecured=marksSecuredTF.getText();
        int index=subjectTableView.getItems().size();
        subjectTableView.getItems().add(new Subject(++index,subjectName, marksSecured));
        subjectNameTF.clear();
        marksSecuredTF.clear();
        
              
    }

    @FXML
    private void removeSubjectFromTable(ActionEvent event) {
        
        subjectTableView.getItems().removeAll(subjectTableView.getSelectionModel().getSelectedItem());
        if(subjectTableView.getItems()==null){
            RemoveSubjectBtn.setDisable(true);
        }
    }
    
    
    boolean validateAllFieldsForEmpty(){
        if(lastPassedExaminationTF.getText().isEmpty()){
            Notifications.create().title("Please Enter Last Passed Examination").showError();
            lastPassedExaminationTF.requestFocus();
        }else{
            if(streamNameTF.getText().isEmpty()){
                Notifications.create().title("Please Enter Stream Name").showError();
                streamNameTF.requestFocus();
            }else{
                if(courseMediumComboBox.getSelectionModel().isEmpty()){
                    Notifications.create().title("Please Select Course Medium").showError();
                    courseMediumComboBox.requestFocus();
                }else{
                    if(courseTypeComboBox.getSelectionModel().isEmpty()){
                        Notifications.create().title("Please Select Course Type first").showError();
                        courseTypeComboBox.requestFocus();
                    }else{
                        if(passingYearTF.getText().isEmpty()){
                            Notifications.create().title("Please Enter Passing Year first").showError();
                            passingYearTF.requestFocus();
                        }else{
                            if(marksPercentTF.getText().isEmpty()){
                                Notifications.create().title("Please Enter  Overall Marks in Percentage").showError();
                                marksPercentTF.requestFocus();
                            }else{
                                if(boardNameTF.getText().isEmpty()){
                                    Notifications.create().title("Please Enter University/Board Name").showError();
                                    boardNameTF.requestFocus();
                                }else{
                                    if(schoolNameTF.getText().isEmpty()){
                                        Notifications.create().title("Please Enter School/College Name").showError();
                                        schoolNameTF.requestFocus();
                                    }else{
                                        if(subjectTableView.getItems().isEmpty()){
                                            Notifications.create().title("Please Add Subject to Subject Table").showError();
                                            subjectTableView.requestFocus();
                                        }else{
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    
    boolean validateAllFieldsForWrongEntry(){
        if(lastPassedExaminationTF.getText().length()>30){
            Notifications.create().title("Last Passed Examination is too long").showError();
            lastPassedExaminationTF.requestFocus();
        }else{
            if(!streamNameTF.getText().matches("^[a-zA-Z ]*$")){
                Notifications.create().title("Please Enter Correct Stream Name").showError();
                streamNameTF.requestFocus();
            }else{
                if(!(Integer.parseInt(passingYearTF.getText())>2005 && Integer.parseInt(passingYearTF.getText())<Calendar.getInstance().get(Calendar.YEAR))){
                        Notifications.create().title("Please Enter a valid Year").showError();
                        passingYearTF.requestFocus();
                     }else{
                         if(!(marksPercentTF.getText().length()>=2 && (marksPercentTF.getText().matches("[0-9]+")))){
                                Notifications.create().title("Please Enter Overall Marks percentage in digit only").showError();
                                marksPercentTF.requestFocus();
                            }else{
                                if(!(boardNameTF.getText().matches("^[a-zA-Z ]*$"))){
                                    Notifications.create().title("Please Enter a valid University/Board Name").showError();
                                    boardNameTF.requestFocus();
                                }else{
                                    if(!(schoolNameTF.getText().matches("^[a-zA-Z ]*$"))){
                                        Notifications.create().title("Please Enter a valid School/College Name").showError();
                                        schoolNameTF.requestFocus();
                                    }else{
                                        return true;
                                    }
                                }
                            }
                        }
                    
                }
            }
        
        return false;
    }
    
    StudentPreviousAcademicDetails getDataFromPage3AndSendDataToMainBoard(){
        StudentPreviousAcademicDetails studentPreviousAcademicDetails=new StudentPreviousAcademicDetails();
        String lastPassedExamination = lastPassedExaminationTF.getText();
        String streamName = streamNameTF.getText();
        String courseMedium = courseMediumComboBox.getValue();
        String courseType = courseTypeComboBox.getValue();
        String passingYear = passingYearTF.getText();
        String overallPercentage = marksPercentTF.getText();
        String nameofUniversityBoard = boardNameTF.getText();
        String schoolCollegeName = schoolNameTF.getText();
        
        List<Subject> subjectList=new ArrayList<>();
        for(int i=0;i<subjectTableView.getItems().size();i++){
            subjectList.add((Subject) subjectTableView.getItems().get(i)); 
        }
        
        studentPreviousAcademicDetails.setLastPassedExamination(lastPassedExamination);
        studentPreviousAcademicDetails.setStreamName(streamName);
        studentPreviousAcademicDetails.setCourseMedium(courseMedium);
        studentPreviousAcademicDetails.setCourseType(courseType);
        studentPreviousAcademicDetails.setPassingYear(passingYear);
        studentPreviousAcademicDetails.setOverallPercentage(overallPercentage);
        studentPreviousAcademicDetails.setNameofUniversityBoard(nameofUniversityBoard);
        studentPreviousAcademicDetails.setSchoolCollegeName(schoolCollegeName);
        studentPreviousAcademicDetails.setSubjectList(subjectList);
                
        return studentPreviousAcademicDetails;
    }
    
    
    void  getExistingDataFromMainBoardAndSetToPage3(StudentPreviousAcademicDetails studentPreviousAcademicDetails){
        if(studentPreviousAcademicDetails!=null){
            lastPassedExaminationTF.setText(studentPreviousAcademicDetails.getLastPassedExamination());
            streamNameTF.setText(studentPreviousAcademicDetails.getStreamName());
            courseMediumComboBox.setValue(studentPreviousAcademicDetails.getCourseMedium());
            courseTypeComboBox.setValue(studentPreviousAcademicDetails.getCourseType());
            passingYearTF.setText(studentPreviousAcademicDetails.getPassingYear());
            marksPercentTF.setText(studentPreviousAcademicDetails.getOverallPercentage());
            schoolNameTF.setText(studentPreviousAcademicDetails.getSchoolCollegeName());
            boardNameTF.setText(studentPreviousAcademicDetails.getNameofUniversityBoard());
            List<Subject> subjectList = studentPreviousAcademicDetails.getSubjectList();
            for(int i=0;i<subjectList.size();i++){
//                subjectList.get(i);
//                        add((Subject) subjectTableView.getItems().get(i));
                subjectTableView.getItems().add(subjectList.get(i));
            }
            
            
        }
    }
    
}
