
package Controller_FXMLController;

import Model_Beans.Course;
import Model_Beans.Department;
import Model_Beans.LoginUser;
import Model_Services.StudentManagementServicesImpl;
import Model_Beans.StudentPersonalInformation;
import Model_Services.AcademicManagementServicesImpl;
import Model_Services.LoginPageServicesImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class UpdateStudent1FXMLController implements Initializable {
    
    @FXML
    private TextField studentIdTF;
    @FXML
    private JFXButton findStudentBtn;
    @FXML
    private Label HeadingLabel;
    @FXML
    private ImageView picImgView;
    @FXML
    private ImageView signImgView;
    @FXML
    private JFXTextField fullNameTF;
    @FXML
    private JFXTextField fatherNameTF;
    @FXML
    private JFXTextField motherNameTF;
    @FXML
    private JFXTextField emailTF;
    @FXML
    private JFXDatePicker dobTF;
    @FXML
    private JFXComboBox<String> idTypeComboBox;
    @FXML
    private JFXComboBox<String> casteCategoryComboBox;
    @FXML
    private JFXComboBox<String> religionComboBox;
    @FXML
    private JFXComboBox<String> bloodGroupComboBox;
    @FXML
    private JFXRadioButton maleRadio;
    @FXML
    private JFXRadioButton femaleRadio;
    @FXML
    private JFXRadioButton otherRadio;
    @FXML
    private JFXComboBox<String> maritalStatusComboBox;
    @FXML
    private JFXTextField mobileNoTF;
    @FXML
    private JFXComboBox<String> pwdComboBox;
    @FXML
    private JFXTextField idCardNoTF;
    @FXML
    private JFXRadioButton haveDomecileNoRadio;
    @FXML
    private JFXRadioButton haveDomecileYesRadio;
    @FXML
    private JFXComboBox<String> courseEnrolledCB;
    @FXML
    private JFXComboBox<String> currentSemesterCB;
    @FXML
    private JFXComboBox<String> sessionCB;
    @FXML
    private JFXComboBox<String> nationalityComboBox;
    @FXML
    private JFXComboBox<String> departmentCB;
    private HBox topBar;
    
    StudentManagementServicesImpl studentManagementServicesImpl;
    AcademicManagementServicesImpl academicManagementServicesImpl;
    
    
    String IdTypes[]={"Aadhaar Card","PAN Card","Ration Card","Driving License","Voter ID Card"};
    String casteCategories[]={"General","OBC","SC","ST"};
    String religions[]={"Hinduism","Islam","Christianity","Sikhism","Buddhism","Jainism","Other"};
    String bloodGroups[]={"A+","A-","AB+","B+","B-","O+","O-","Not Known"};
    String maritalStates[]={"Unmarried","Married","Separated","Widow","Divorced"};
    String pwds[]={"No","Yes"};
    String nationalities[]={"Indian","Other"};
    
    
    
    ToggleGroup toggleGroupForGender;
    ToggleGroup toggleGroupForHaveDomecile;
    
    File selectedProfilePicFile;
    File selectedSignFile;
    byte []Profilepic;
    byte []Sign;
    List<Course> courseList;
    List<String> courseNames;
    int noOfSem=0;
    List<Department> departmentList;
    List<String> departmentNames;
    
    private String gEmail;

  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentManagementServicesImpl=new StudentManagementServicesImpl();
        academicManagementServicesImpl=new AcademicManagementServicesImpl();
        
        //setting all items to the combo box
        idTypeComboBox.getItems().addAll(IdTypes);  
        casteCategoryComboBox.getItems().addAll(casteCategories);
        religionComboBox.getItems().addAll(religions);
        bloodGroupComboBox.getItems().addAll(bloodGroups);
        maritalStatusComboBox.getItems().addAll(maritalStates);
        pwdComboBox.getItems().addAll(pwds);
        nationalityComboBox.getItems().addAll(nationalities);
        
        //setting all radio to their respective toggleGroup
        toggleGroupForGender=new ToggleGroup();
        maleRadio.setToggleGroup(toggleGroupForGender);
        femaleRadio.setToggleGroup(toggleGroupForGender);
        otherRadio.setToggleGroup(toggleGroupForGender);
      
        toggleGroupForHaveDomecile=new ToggleGroup();
        haveDomecileNoRadio.setToggleGroup(toggleGroupForHaveDomecile);
        haveDomecileYesRadio.setToggleGroup(toggleGroupForHaveDomecile);
        
        //for adding courseList from DB to combobox
        courseList=academicManagementServicesImpl.displayAllCourse();
        courseNames=new ArrayList<>();
        for(Course course:courseList){
            courseNames.add(course.getCourse_name());
        }
        courseEnrolledCB.getItems().addAll(courseNames);
        
        //for adding departmentList from DB to combobox
        departmentList=academicManagementServicesImpl.showAllDepartments();
        departmentNames=new ArrayList<>();
        for(Department department:departmentList){
            departmentNames.add(department.getDepartmentName());
        }
        departmentCB.getItems().addAll(departmentNames);
        
        
    }    

    @FXML
    private void findStudentUsingStudentId(ActionEvent event) {
        if(! studentIdTF.getText().isEmpty()){
            String studentId=studentIdTF.getText();
            StudentPersonalInformation studentPersonalInformation = studentManagementServicesImpl.findStudentUsingStudentId(studentId);
            if(studentPersonalInformation.getId()!=null && studentPersonalInformation.getId().equals(studentId)){
                //setting all data to UI
                fullNameTF.setText(studentPersonalInformation.getFullName());
                fatherNameTF.setText(studentPersonalInformation.getFatherName());
                motherNameTF.setText(studentPersonalInformation.getMotherName());
                emailTF.setText(studentPersonalInformation.getEmail());
                dobTF.setValue(LocalDate.parse(studentPersonalInformation.getDob()));
                idTypeComboBox.setValue(studentPersonalInformation.getIdCardType());
                casteCategoryComboBox.setValue(studentPersonalInformation.getCasteCategory());
                religionComboBox.setValue(studentPersonalInformation.getReligion());
                nationalityComboBox.setValue(studentPersonalInformation.getNationality());
                bloodGroupComboBox.setValue(studentPersonalInformation.getBloodGroup());
                if(studentPersonalInformation.getGender().equals("Male")){
                    toggleGroupForGender.selectToggle(maleRadio);
                }else if(studentPersonalInformation.getGender().equals("Female")){
                    toggleGroupForGender.selectToggle(femaleRadio);
                }else{
                    toggleGroupForGender.selectToggle(otherRadio);
                }
                maritalStatusComboBox.setValue(studentPersonalInformation.getMaritalStatus());
                mobileNoTF.setText(studentPersonalInformation.getMobileNo());
                pwdComboBox.setValue(studentPersonalInformation.getPwd());
                idCardNoTF.setText(studentPersonalInformation.getIdCardNo());
                if(studentPersonalInformation.getHaveStateDomecile().equals("No")){
                    toggleGroupForHaveDomecile.selectToggle(haveDomecileNoRadio);
                }else if(studentPersonalInformation.getHaveStateDomecile().equals("Yes")){
                    toggleGroupForHaveDomecile.selectToggle(haveDomecileYesRadio);
                }
                courseEnrolledCB.setValue(studentPersonalInformation.getCourse_enrolled());
                departmentCB.setValue(studentPersonalInformation.getDepartment());
                currentSemesterCB.setValue(studentPersonalInformation.getCurrent_semester()+"");
                sessionCB.setValue(studentPersonalInformation.getSession());
                
                ByteArrayInputStream bisProfile=new ByteArrayInputStream(studentPersonalInformation.getProfilePic());
                picImgView.setImage(new Image(bisProfile));
                Profilepic=studentPersonalInformation.getProfilePic();
                ByteArrayInputStream bisSignature=new ByteArrayInputStream(studentPersonalInformation.getSignature());
                signImgView.setImage(new Image(bisSignature));
                Sign=studentPersonalInformation.getSignature();
            }else{
                Notifications.create().position(Pos.TOP_CENTER).title("Student not Found...").text("Please check Student Id").showError();
                studentIdTF.requestFocus();
                clearAllFields();
            }
        }else{
            Notifications.create().position(Pos.TOP_CENTER).title("Student Id is required*").text("Please Enter Student Id").showError();
            studentIdTF.requestFocus();
            clearAllFields();
        }
    
    }

    @FXML
    private void choosePic(ActionEvent event) {
        try{
            FileChooser fileChooser=new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg"));
            selectedProfilePicFile=fileChooser.showOpenDialog(null);
            Image image = null;
            image = new Image(new FileInputStream(selectedProfilePicFile)); //converted using FileInputStream class
            picImgView.setImage(image);        
            FileInputStream f = new FileInputStream(selectedProfilePicFile);        
            Profilepic=new byte[(int)selectedProfilePicFile.length()];
            f.read(Profilepic);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Profile Pic couldn't be loaded...");
            e.printStackTrace();
        }
    }

    @FXML
    private void chooseSign(ActionEvent event) {
        try{
            FileChooser fileChooser=new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg"));
            selectedSignFile=fileChooser.showOpenDialog(null);
            Image image = null;

            image = new Image(new FileInputStream(selectedSignFile)); //converted using FileInputStream class

            signImgView.setImage(image);
        
            FileInputStream f = new FileInputStream(selectedSignFile);
        
            Sign=new byte[(int)selectedSignFile.length()];
            f.read(Sign);        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Signature couldn't be loaded...");
            e.printStackTrace();
        }
    }
    
    
    public String getSelectedGender(){
        String gender;
        Toggle toggle=toggleGroupForGender.getSelectedToggle();
        if(toggle==maleRadio){
            gender="Male";
        }else if(toggle==femaleRadio){
            gender="Female";
        }else{
            gender="Others";
        }
        return gender;
    }
    
    public String getSelectedDomecileOption(){
        String haveDomecile=null;
        Toggle toggle=toggleGroupForHaveDomecile.getSelectedToggle();
        if(toggle==haveDomecileNoRadio){
            haveDomecile="No";
        }else if(toggle==haveDomecileYesRadio){
            haveDomecile="Yes";
        }
        return haveDomecile;
    }
    
    boolean validateAllFieldsForEmpty(){
        if(fullNameTF.getText().isEmpty()){
            Notifications.create().position(Pos.TOP_LEFT).title("Please Enter Full Name").showError();
            fullNameTF.requestFocus();
        }else{
            if(fatherNameTF.getText().isEmpty()){
                Notifications.create().position(Pos.TOP_LEFT).title("Please Enter Father's Name").showError();
                fatherNameTF.requestFocus();
            }else{
                if(motherNameTF.getText().isEmpty()){
                    Notifications.create().position(Pos.TOP_LEFT).title("Please Enter Mother's Name").showError();
                    motherNameTF.requestFocus();
                }else{
                    if(emailTF.getText().isEmpty()){
                        Notifications.create().position(Pos.TOP_LEFT).title("Please Enter Email").showError();
                        emailTF.requestFocus();
                    }else{
                        if(dobTF.getValue()==null){
                            Notifications.create().position(Pos.TOP_LEFT).title("Please Pick Date of Birth").showError();
                            dobTF.requestFocus();
                        }else{
                            if(idTypeComboBox.getSelectionModel().isEmpty()){
                                Notifications.create().position(Pos.TOP_LEFT).title("Please Select Id Card Type").showError();
                                idTypeComboBox.requestFocus();
                            }else{
                                if(casteCategoryComboBox.getSelectionModel().isEmpty()){
                                    Notifications.create().position(Pos.TOP_LEFT).title("Please Select Caste Category").showError();
                                    casteCategoryComboBox.requestFocus();
                                }else{
                                    if(religionComboBox.getSelectionModel().isEmpty()){
                                        Notifications.create().position(Pos.TOP_LEFT).title("Please Select Religion").showError();
                                        religionComboBox.requestFocus();
                                    }else{
                                        if(bloodGroupComboBox.getSelectionModel().isEmpty()){
                                            Notifications.create().position(Pos.TOP_LEFT).title("Please Select Blood Group").showError();
                                            bloodGroupComboBox.requestFocus();
                                        }else{
                                            if(toggleGroupForGender.getSelectedToggle()==null){
                                               Notifications.create().position(Pos.TOP_LEFT).title("Please Select Gender").showError();
                                               maleRadio.requestFocus(); 
                                            }else{
                                                if(maritalStatusComboBox.getSelectionModel().isEmpty()){
                                                    Notifications.create().position(Pos.TOP_LEFT).title("Please Select Marital Status").showError();
                                                    maritalStatusComboBox.requestFocus();
                                                }else{
                                                    if(mobileNoTF.getText().isEmpty()){
                                                        Notifications.create().position(Pos.TOP_LEFT).title("Please Enter Mobile Number").showError();
                                                        mobileNoTF.requestFocus();
                                                    }else{
                                                        if(pwdComboBox.getSelectionModel().isEmpty()){
                                                            Notifications.create().position(Pos.TOP_LEFT).title("Please Select PwD").showError();
                                                            pwdComboBox.requestFocus();
                                                        }else{
                                                            if(idCardNoTF.getText().isEmpty()){
                                                                Notifications.create().position(Pos.TOP_LEFT).title("Please Enter Id Card Number").showError();
                                                                idCardNoTF.requestFocus();
                                                            }else{
                                                                if(toggleGroupForHaveDomecile.getSelectedToggle()==null){
                                                                    Notifications.create().position(Pos.TOP_LEFT).title("Please Select Domecile ").showError();
                                                                    haveDomecileNoRadio.requestFocus();
                                                                }else{
                                                                    if(courseEnrolledCB.getValue()==null){
                                                                        Notifications.create().position(Pos.TOP_LEFT).title("Please Select Course").showError();
                                                                        courseEnrolledCB.requestFocus();
                                                                    }else{
                                                                        if(picImgView.getImage()==null){
                                                                            Notifications.create().position(Pos.TOP_LEFT).title("Please Upload a Profile Pic").showError();
                                                                            picImgView.requestFocus();
                                                                        }else{
                                                                            if(signImgView.getImage()==null){
                                                                                Notifications.create().position(Pos.TOP_LEFT).title("Please Upload Signature").showError();
                                                                                signImgView.requestFocus();
                                                                            }else{
                                                                                if(currentSemesterCB.getValue()==null){
                                                                                    Notifications.create().position(Pos.TOP_LEFT).title("Please Select Semester").showError();
                                                                                    currentSemesterCB.requestFocus();
                                                                                }else{
                                                                                    if(sessionCB.getValue()==null){
                                                                                        Notifications.create().position(Pos.TOP_LEFT).title("Please Select Session").showError();
                                                                                        sessionCB.requestFocus();
                                                                                    }else{
                                                                                        if(nationalityComboBox.getValue()==null){
                                                                                            Notifications.create().position(Pos.TOP_LEFT).title("Please Select Nationality*").showError();
                                                                                            nationalityComboBox.requestFocus();
                                                                                        }else{
                                                                                            if(departmentCB.getValue()==null){
                                                                                                Notifications.create().position(Pos.TOP_LEFT).title("Please Select Department*").showError();
                                                                                                departmentCB.requestFocus();
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
                                                        }
                                                    }
                                                }
                                            }
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
        if(fullNameTF.getText().matches("^[a-zA-Z ]*$")){
            if(fatherNameTF.getText().matches("^[a-zA-Z ]*$")){
                if(motherNameTF.getText().matches("^[a-zA-Z ]*$")){
                    if(emailTF.getText().matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$")){
                        //No need to validate DatePicker since it will not get any other value
                        if(mobileNoTF.getText().length()==10 && mobileNoTF.getText().matches("(0/91)?[6-9][0-9]{9}")){
                            if(!(idCardNoTF.getText().length()<5)){
                                return true;
                            }else{
                                JOptionPane.showMessageDialog(null, "Please enter a valid Id Number");
                                idCardNoTF.requestFocus();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Please enter a valid mobile number");
                            mobileNoTF.requestFocus();
                        }
                      
                    }else{
                        JOptionPane.showMessageDialog(null, "Please enter a valid Email");
                        emailTF.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter valid Mother's Name");
                    motherNameTF.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please Enter valid Father's Name");
                fatherNameTF.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Please Enter a valid Name");
            fullNameTF.requestFocus();
        }
        return false;
    }

    @FXML
    private void updateStudent(ActionEvent event) {
        
        if(validateAllFieldsForEmpty()){
            if(validateAllFieldsForWrongEntry()){
                
                StudentPersonalInformation studentPersonalInformation=new StudentPersonalInformation();
                String id=studentIdTF.getText();
                String fullName=fullNameTF.getText();
                String fatherName=fatherNameTF.getText();
                String motherName=motherNameTF.getText();
                String email=emailTF.getText();
                String dob=dobTF.getValue().toString();
        
                String idCardType=idTypeComboBox.getSelectionModel().getSelectedItem();
                String casteCategory=casteCategoryComboBox.getSelectionModel().getSelectedItem();
                String religion=religionComboBox.getSelectionModel().getSelectedItem();
                String nationality=nationalityComboBox.getValue();
                String bloodGroup=bloodGroupComboBox.getSelectionModel().getSelectedItem();
                String gender=getSelectedGender();
                String maritalStatus=maritalStatusComboBox.getSelectionModel().getSelectedItem();
                String mobileNo=mobileNoTF.getText();
                String pwd=pwdComboBox.getSelectionModel().getSelectedItem();
                String idCardNo=idCardNoTF.getText();
                String haveStateDomecile=getSelectedDomecileOption();
                String courseEnrolled=courseEnrolledCB.getValue();
                String department=departmentCB.getValue();
                int currentSemester=Integer.parseInt(currentSemesterCB.getValue());
                String session=sessionCB.getValue();
        
                studentPersonalInformation.setProfilePic(Profilepic);
                studentPersonalInformation.setSignature(Sign);
                studentPersonalInformation.setId(id);
                studentPersonalInformation.setFullName(fullName);
                studentPersonalInformation.setFatherName(fatherName);
                studentPersonalInformation.setMotherName(motherName);
                studentPersonalInformation.setEmail(email);
                studentPersonalInformation.setDob(dob);
                studentPersonalInformation.setIdCardType(idCardType);
                studentPersonalInformation.setCasteCategory(casteCategory);
                studentPersonalInformation.setReligion(religion);
                studentPersonalInformation.setNationality(nationality);
                studentPersonalInformation.setBloodGroup(bloodGroup);
                studentPersonalInformation.setGender(gender);
                studentPersonalInformation.setMaritalStatus(maritalStatus);
                studentPersonalInformation.setMobileNo(mobileNo);
                studentPersonalInformation.setPwd(pwd);
                studentPersonalInformation.setIdCardNo(idCardNo);
                studentPersonalInformation.setHaveStateDomecile(haveStateDomecile);
                studentPersonalInformation.setCourse_enrolled(courseEnrolled);
                studentPersonalInformation.setDepartment(department);
                studentPersonalInformation.setCurrent_semester(currentSemester);
                studentPersonalInformation.setSession(session);
        
                int flag=studentManagementServicesImpl.updateStudentPersonalDetails(studentPersonalInformation);
                if(flag>0){
                    Notifications.create().title("Updated Successfully").showInformation();
                }else{
                    Notifications.create().title("Data not Updated ").showError();
                }
            }
        }
    }

    private void clearAllFields() {
        picImgView.setImage(null);
        signImgView.setImage(null);
        fullNameTF.clear();
        fatherNameTF.clear();
        motherNameTF.clear();
        emailTF.clear();
        dobTF.setValue(null);
        idTypeComboBox.setValue(null);
        casteCategoryComboBox.setValue(null);
        religionComboBox.setValue(null);
        nationalityComboBox.setValue(null);
        bloodGroupComboBox.setValue(null);
        maritalStatusComboBox.setValue(null);
        mobileNoTF.clear();
        pwdComboBox.setValue(null);
        idCardNoTF.clear();
        toggleGroupForGender.selectToggle(null);
        toggleGroupForHaveDomecile.selectToggle(null);
        courseEnrolledCB.setValue(null);
        departmentCB.setValue(null);
        currentSemesterCB.setValue(null);
        sessionCB.setValue(null);
        
    }

    @FXML
    private void courseEnrolledCBStateChanged(ActionEvent event) {
        currentSemesterCB.getItems().clear();
       for(int i=0;i<courseNames.size();i++){
            if(courseEnrolledCB.getValue().equals(courseNames.get(i))){
                Course course=courseList.get(i);
                noOfSem=course.getCourse_noOfSemester();
            }
        }
       for(int j=1;j<=noOfSem;j++){
          currentSemesterCB.getItems().add(j+"");
       }
       setSession(noOfSem);
    }

    @FXML
    private void currentSemesterCBStateChanged(ActionEvent event) {
        
    }

    @FXML
    private void sessionCBStateChanged(ActionEvent event) {
    }

    @FXML
    private void currentDepartmentCBStateChanged(ActionEvent event) {
    }
 
    void setSession(int noOfSem){
      Calendar calendar=Calendar.getInstance();
       int latestSessionFirstYear=calendar.get(Calendar.YEAR); // current year session
       int latestSessionFinalYear=latestSessionFirstYear+(noOfSem/2);
       sessionCB.getItems().add(latestSessionFirstYear+" - "+latestSessionFinalYear);
       
       int previousSessionFirstYear=calendar.get(Calendar.YEAR)-1; //previous year session
       int previousSessionFinalYear=previousSessionFirstYear+(noOfSem/2);
       sessionCB.getItems().add(previousSessionFirstYear+" - "+previousSessionFinalYear);
       
       int superPreviousSessionFirstYear=calendar.get(Calendar.YEAR)-2;
       int superPreviousSessionFinalYear=superPreviousSessionFirstYear+(noOfSem/2);
       sessionCB.getItems().add(superPreviousSessionFirstYear+" - "+superPreviousSessionFinalYear);
  }
    
    void setUserDetails(String email){
        gEmail=email;
    }
    
    
    void setStudentDetails(String email){
        LoginPageServicesImpl loginPageServicesImpl=new LoginPageServicesImpl();
        LoginUser loginUser=loginPageServicesImpl.doLoginAsStudent(email);
        int studentId=loginUser.getUserid();
        studentIdTF.setText(studentId+"");
        findStudentBtn.setDisable(true);
        studentIdTF.setDisable(true);
        findStudentUsingStudentId(new ActionEvent());
    }

   
    
}
