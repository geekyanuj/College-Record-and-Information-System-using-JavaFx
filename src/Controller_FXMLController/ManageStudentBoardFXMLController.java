
package Controller_FXMLController;

import Model_Services.LoginPageServicesImpl;
import Model_Services.StudentManagementServicesImpl;
import Model_Beans.LoginUser;
import Model_Beans.StudentAddressDetails;
import Model_Beans.StudentDocumentDetails;
import Model_Beans.StudentPersonalInformation;
import Model_Beans.StudentPreviousAcademicDetails;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ManageStudentBoardFXMLController implements Initializable {
    
    LoginUser loginUser=new LoginUser();
    LoginPageServicesImpl loginPageServicesImpl=new LoginPageServicesImpl();
    StudentManagementServicesImpl studentManagementServicesImpl;

    @FXML
    private BorderPane bp;
    @FXML
    private JFXButton previousBtn;
    @FXML
    private JFXButton nextBtn;
    @FXML
    private JFXButton submitBtn;
    @FXML
    private Button backBtn;


    @FXML
    private Line arrow1;
    @FXML
    private Line arrow2;
    @FXML
    private Circle circle2;
    @FXML
    private Line arrow3;
    @FXML
    private Circle circle3;
    @FXML
    private Circle circle4;
    
    @FXML
    private BorderPane displayTabBP;
    @FXML
    private BorderPane updateTabBP;
    @FXML
    private BorderPane deleteTabBP;

    
    FXMLLoader currentLoader;
    
    StudentPersonalInformation studentPersonalInformation;
    StudentAddressDetails studentAddressDetails;
    StudentPreviousAcademicDetails studentPreviousAcademicDetails;
    StudentDocumentDetails studentDocumentDetails;


    
    String gusername;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
        try{
            loadPage1();
            studentManagementServicesImpl =new StudentManagementServicesImpl();
            //for laoding Display Tab contents
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/DisplayStudent1FXML.fxml"));
            Node node=loader.load();
            displayTabBP.setCenter(node);
            
            //for loading Update Tab contents
            FXMLLoader loader1=new FXMLLoader(getClass().getResource("/View_FXMLGUI/UpdateStudent1FXML.fxml"));
            Node node1=loader1.load();
            updateTabBP.setCenter(node1);
            
            //for loading Delete Tab contents
            FXMLLoader loader2=new FXMLLoader(getClass().getResource("/View_FXMLGUI/DeleteStudent1FXML.fxml"));
            Node node2=loader2.load();
            deleteTabBP.setCenter(node2);
            
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }    

    @FXML
    private void pervious(ActionEvent event) throws IOException {
        AddStudent1FXMLController addStudent1FXMLController;
        AddStudent2FXMLController addStudent2FXMLController;
        AddStudent3FXMLController addStudent3FXMLController;
        AddStudent4FXMLController addStudent4FXMLController;
        
        int pageNo=Integer.parseInt(bp.getCenter().lookup(".Heading").getId()); //This is done by setting every fxml file to a common heading class and id 1,2,3 & 4 respectively and retriving a single id. 
        switch (pageNo){
            case 1:
                break;
            case 2:
                addStudent2FXMLController=currentLoader.getController();
                studentAddressDetails=addStudent2FXMLController.getDataFromPage2AndSendDataToMainBoard();
                loadPage1();
                addStudent1FXMLController=currentLoader.getController();
                addStudent1FXMLController.getExistingDataFromMainBoardAndSetToPage1(studentPersonalInformation);
                break;
            case 3:
                addStudent3FXMLController=currentLoader.getController();
                studentPreviousAcademicDetails=addStudent3FXMLController.getDataFromPage3AndSendDataToMainBoard();
                loadPage2();
                /*AddStudent2FXMLController*/ addStudent2FXMLController=currentLoader.getController();
                addStudent2FXMLController.getExistingDataFromMainBoardAndSetToPage2(studentAddressDetails);
                break;
            case 4:
                addStudent4FXMLController=currentLoader.getController();
                if(addStudent4FXMLController.validateAllFieldsForEmpty()){
                    studentDocumentDetails=addStudent4FXMLController.getDataFromPage4AndSendDataToMainBoard();
                    loadPage3();
                    addStudent3FXMLController=currentLoader.getController();
                    addStudent3FXMLController.getExistingDataFromMainBoardAndSetToPage3(studentPreviousAcademicDetails);
                    break;
                }else{
                    break;
                }
                
            default:
                break;
        }

            

            


    }

    @FXML
    private void next(ActionEvent event) {
        AddStudent1FXMLController addStudent1FXMLController;
        AddStudent2FXMLController addStudent2FXMLController;
        AddStudent3FXMLController addStudent3FXMLController;
        AddStudent4FXMLController addStudent4FXMLController;
        int pageNo=Integer.parseInt(bp.getCenter().lookup(".Heading").getId());
        switch (pageNo){
            case 1:
                addStudent1FXMLController=currentLoader.getController();
                //validation testing code are to be written here 
                if(addStudent1FXMLController.validateAllFieldsForEmpty() && addStudent1FXMLController.validateAllFieldsForWrongEntry()){
                    studentPersonalInformation=addStudent1FXMLController.getDataFromPage1AndSendDataToMainBoard();
                    loadPage2();
                    addStudent2FXMLController=currentLoader.getController();
                    addStudent2FXMLController.getExistingDataFromMainBoardAndSetToPage2(studentAddressDetails);
                    break;
                 }else{
                    break;
                }
            case 2:
                addStudent2FXMLController=currentLoader.getController();
                //validation testing code are to be written here 
                if(addStudent2FXMLController.validateAllFieldsForEmpty() && addStudent2FXMLController.validateAllFieldsForWrongEntry()){
                    studentAddressDetails=addStudent2FXMLController.getDataFromPage2AndSendDataToMainBoard();
                    loadPage3();
                    addStudent3FXMLController=currentLoader.getController();
                    addStudent3FXMLController.getExistingDataFromMainBoardAndSetToPage3(studentPreviousAcademicDetails);
                    break;
                }else{
                    break;
                }
            case 3:
                addStudent3FXMLController=currentLoader.getController();
                 //validation testing code are to be written here 
                if(addStudent3FXMLController.validateAllFieldsForEmpty() && addStudent3FXMLController.validateAllFieldsForWrongEntry()){
                    studentPreviousAcademicDetails=addStudent3FXMLController.getDataFromPage3AndSendDataToMainBoard();
                    loadPage4();
                    addStudent4FXMLController=currentLoader.getController();
                    addStudent4FXMLController.getExistingDataFromMainBoardAndSetToPage4(studentDocumentDetails);
                    break;
                }else{
                    break;
                }
                
            default:
                break;
        }
  
    }

    @FXML
    private void submit(ActionEvent event) throws IOException {
       AddStudent4FXMLController addStudent4FXMLController=currentLoader.getController();
                if(addStudent4FXMLController.validateAllFieldsForEmpty()){
                    studentDocumentDetails=addStudent4FXMLController.getDataFromPage4AndSendDataToMainBoard();
                    int x=studentManagementServicesImpl.addStudent(studentPersonalInformation, studentAddressDetails, studentPreviousAcademicDetails, studentDocumentDetails);
                    JOptionPane.showMessageDialog(null, "Student added successfully.... ");
                    JOptionPane.showMessageDialog(null, "Please Note Student Id "+x);
                    
                    loadPage1();
                    studentPersonalInformation=null;
                    studentAddressDetails=null;
                    studentDocumentDetails=null;
                    studentPreviousAcademicDetails=null;
                    
                    
//                    System.out.println("Full Name "+studentPersonalInformation.getFullName());
//                    System.out.println("Father Name "+studentPersonalInformation.getFatherName());
//                    System.out.println("Mother Name "+studentPersonalInformation.getMotherName());
//                    System.out.println("Email "+studentPersonalInformation.getEmail());
//                    System.out.println("DOB "+studentPersonalInformation.getDob());
//                    System.out.println("Id card Type "+studentPersonalInformation.getIdCardType());
//                    System.out.println("caste category "+studentPersonalInformation.getCasteCategory());
//                    System.out.println("Religion "+studentPersonalInformation.getReligion());
//                    System.out.println("Blood Group "+studentPersonalInformation.getBloodGroup());
//                    System.out.println("Gender "+studentPersonalInformation.getGender());
//                    System.out.println("Marital Status "+studentPersonalInformation.getMaritalStatus());
//                    System.out.println("Mobile No "+studentPersonalInformation.getMobileNo());
//                    System.out.println("Pwd"+studentPersonalInformation.getPwd());
//                    System.out.println("Id No"+studentPersonalInformation.getIdCardNo());
//                    System.out.println("Have domecile"+studentPersonalInformation.getHaveStateDomecile());
//                    System.out.println("Nationality"+studentPersonalInformation.getNationality());
//                    System.out.println();
//                    System.out.println("PresentAddress Line 1"+studentAddressDetails.getPresentAddressLine1());
//                    System.out.println("City Name"+studentAddressDetails.getPresentCityName());
//                    System.out.println("State Name"+studentAddressDetails.getPresentStateName());
//                    System.out.println("District Name"+studentAddressDetails.getPresentDistrictName());
//                    System.out.println("Pin Code"+studentAddressDetails.getPresentPinCode());
//                    System.out.println("Permanent Address Line 1"+studentAddressDetails.getPermanentAddressLine1());
//                    System.out.println("City Name"+studentAddressDetails.getPermanentCityName());
//                    System.out.println("State Name"+studentAddressDetails.getPermanentStateName());
//                    System.out.println("District Name"+studentAddressDetails.getPermanentDistrictName());
//                    System.out.println("Pin Code"+studentAddressDetails.getPermanentPinCode());
//                    System.out.println();
//                    System.out.println("Last Passed Exam "+studentPreviousAcademicDetails.getLastPassedExamination());
//                    System.out.println(" Stream Name"+studentPreviousAcademicDetails.getStreamName());
//                    System.out.println("Course Medium "+studentPreviousAcademicDetails.getCourseMedium());
//                    System.out.println("Course Type "+studentPreviousAcademicDetails.getCourseType());
//                    System.out.println("Passing Year "+studentPreviousAcademicDetails.getPassingYear());
//                    System.out.println("% "+studentPreviousAcademicDetails.getOverallPercentage());
//                    System.out.println("University "+studentPreviousAcademicDetails.getNameofUniversityBoard());
//                    System.out.println("School "+studentPreviousAcademicDetails.getSchoolCollegeName());
//                    List<Subject> list =studentPreviousAcademicDetails.getSubjectList();
//                    for(int i=0;i<list.size();i++){
//                        System.out.println("Subject"+i+ "  is  "+list.get(i).getSubjectName()+list.get(i).getMarksSecured()  );
//                    }
//                    
//                    System.out.println("");
//                    
//                    System.out.println("Id Card Proof "+studentDocumentDetails.getIdProof());
//                    System.out.println("10th Marksheet "+studentDocumentDetails.getTenthMarksheet());
//                    System.out.println("12 Marksheet "+studentDocumentDetails.getTwelfthMarksheet());
//                    System.out.println("12 migration "+studentDocumentDetails.getTwelfthMigration());
//                    System.out.println("12th TC "+studentDocumentDetails.getTwelfthTC());
                    
                }

    }

    @FXML
    private void backToDashboard(ActionEvent event) {
        int flag=JOptionPane.showConfirmDialog(null, "Do you want to go back? All unsaved data will be lost...");
        if(flag==0){
            Stage stage=(Stage)bp.getScene().getWindow();
            stage.close();
            stage=(Stage) stage.getUserData();
            stage.setMaximized(true);
            stage.show();
             int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
             int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
            try{
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AdminDashboardFXML.fxml"));
                    Parent root=loader.load();
                    AdminDashboardFXMLController adminDashboardFXMLController=loader.getController();
                    if(gusername!=null){
                        adminDashboardFXMLController.setUserDetails(gusername);
                    }
                    Scene scene = new Scene(root,screenWidth,screenHeight);
                    
                    stage.setScene(scene);
                    stage.setTitle("Admin - P.K. Roy Memorial College,Dhanbad  Smart-Ed College ERP v1.1.1");
                    stage.setX(0);
                    stage.setY(0);
                   
          
                    stage.show();
                    
                    
                }catch (IOException ex){
                    System.out.println(ex);
                    ex.printStackTrace();
              //  }
            
        }
    }
    
    }
    
    
    
    void fetchUserDetails(String username){
        gusername=username;
    }
    
    

    

    void loadPage1(){
        try{
            currentLoader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AddStudent1FXML.fxml"));
            Node currentNode=currentLoader.load();
            
            bp.setCenter(currentNode);
            previousBtn.setDisable(true);
            nextBtn.setDisable(false);
            submitBtn.setDisable(true);
            arrow1.setStroke(Paint.valueOf("#708fab"));
            circle2.setFill(Paint.valueOf("#708fab"));
            arrow2.setFill(Paint.valueOf("#708fab"));
            circle3.setFill(Paint.valueOf("#708fab"));
            arrow3.setFill(Paint.valueOf("#708fab"));
            circle4.setFill(Paint.valueOf("#708fab"));
        } catch (IOException ex){
            System.err.println("Couldn't load page1");
            ex.printStackTrace();
        }
    }
    
    void loadPage2(){
        try{
            currentLoader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AddStudent2FXML.fxml"));
            Node node=currentLoader.load();
            bp.setCenter(node);
            previousBtn.setDisable(false);
            nextBtn.setDisable(false);
            submitBtn.setDisable(true);
            arrow1.setStroke(Paint.valueOf("#4DD637"));
            circle2.setFill(Paint.valueOf("#4DD637"));
            arrow2.setStroke(Paint.valueOf("#708fab"));
            circle3.setFill(Paint.valueOf("#708fab"));
            arrow3.setFill(Paint.valueOf("#708fab"));
            circle4.setFill(Paint.valueOf("#708fab"));
        } catch (IOException ex){
            System.err.println("Couldn't load page2");
            ex.printStackTrace();
        }
    }
    
    void loadPage3(){
        try{
            currentLoader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AddStudent3FXML.fxml"));
            Node node=currentLoader.load();
            bp.setCenter(node);
            previousBtn.setDisable(false);
            nextBtn.setDisable(false);
            submitBtn.setDisable(true);
            arrow1.setStroke(Paint.valueOf("#4DD637"));
            circle2.setFill(Paint.valueOf("#4DD637"));
            arrow2.setStroke(Paint.valueOf("#4DD637"));
            circle3.setFill(Paint.valueOf("#4DD637"));
            arrow3.setStroke(Paint.valueOf("#708fab"));
            circle4.setFill(Paint.valueOf("#708fab"));
        } catch (IOException ex){
            System.err.println("Couldn't load page3");
            ex.printStackTrace();
        }
    }
    
    
    void loadPage4(){
        try{
            currentLoader=new FXMLLoader(getClass().getResource("/View_FXMLGUI/AddStudent4FXML.fxml"));
            Node node=currentLoader.load();
            bp.setCenter(node);
            
            previousBtn.setDisable(false);
            nextBtn.setDisable(true);
            submitBtn.setDisable(false);
            arrow1.setStroke(Paint.valueOf("#4DD637"));
            circle2.setFill(Paint.valueOf("#4DD637"));
            arrow2.setStroke(Paint.valueOf("#4DD637"));
            circle3.setFill(Paint.valueOf("#4DD637"));
            arrow3.setStroke(Paint.valueOf("#4DD637"));
            circle4.setFill(Paint.valueOf("#4DD637"));

        } catch (IOException ex){
            System.err.println("Couldn't load page4");
            ex.printStackTrace();
        }
    }
    
    
    
    
    }
    
    
    
