
package Controller_FXMLController;

import Model_Beans.Fees;
import Model_Beans.LoginUser;
import Model_Beans.StudentPersonalInformation;
import Model_Services.FeesManagementServicesImpl;
import Model_Services.LoginPageServicesImpl;
import Model_Services.StudentManagementServicesImpl;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class FeesCollectionBoardFXMLController implements Initializable {

    @FXML
    private TextField studentIdTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField fnameTF;
    @FXML
    private TextField dobTF;
    @FXML
    private TextField semesterTF;
    @FXML
    private TextField deptTF;
    @FXML
    private TextField courseFeeTF;
    @FXML
    private TextField paidTillSemTF;
    @FXML
    private TextField totalPaidAmtTF;
    @FXML
    private TextField dueAmtTF;
    @FXML
    private TextArea area;
    @FXML
    private Button backBtn;
    @FXML
    private Button printBtn;

    StudentManagementServicesImpl studentManagementServicesImpl;
    StudentPersonalInformation student;
    FeesManagementServicesImpl feesManagementServicesImpl;
    
    String gemail,gusertype;
    
    boolean isReceiptGenerated=false;
    boolean isReceiptPrinted=false;
    boolean isFeeCollected=false;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       studentManagementServicesImpl=new StudentManagementServicesImpl();
       student=new StudentPersonalInformation();
       feesManagementServicesImpl=new FeesManagementServicesImpl();
    }    

    @FXML
    private void findStudent(ActionEvent event) {
        if(studentIdTF.getText().isEmpty()){
            Notifications.create().position(Pos.TOP_RIGHT).title("Student Id is required*").showError();
            studentIdTF.requestFocus();   
        }else{
            if(studentIdTF.getText().matches("^[0-9]*$")){
                //all logic finished
                String studentId=studentIdTF.getText();
                student=studentManagementServicesImpl.findStudentUsingStudentId(studentId);
                if(student.getId()!=null){
                    if(student.getId().equals(studentId)){
                     nameTF.setText(student.getFullName());
                    fnameTF.setText(student.getFatherName());
                    dobTF.setText(student.getDob());
//                  deptTF.setText("");
//                  cousefee amount
//                  paidTillSemTF.setText();
//                  totalPaidAmtTF.setText();
//                  dueAmtTF.setText();
                    }else{
                        Notifications.create().position(Pos.TOP_RIGHT).title("No student find againt Student Id "+studentId).showError();
                        studentIdTF.requestFocus();
                    }
                }else{
                    Notifications.create().position(Pos.TOP_RIGHT).title("No student find againt Student Id "+studentId).showError();
                    studentIdTF.requestFocus();
                }
                
                
            }else{
                Notifications.create().position(Pos.TOP_RIGHT).title("Student Id is not valid digit*").showError();
                 studentIdTF.requestFocus();
            }
        }
    }

    @FXML
    private void generateReceipt(ActionEvent event) {
        if(isFeeCollected){
            area.setText("*******************************************************************************\n");
            area.setText(area.getText()+"                                           Fees Receipt                             \n");
            area.setText(area.getText()+"*******************************************************************************\n");
        
//        
            Date obj= new Date();
            String date= obj.toString();
            area.setText(area.getText()+"\nDate/Time :     "+date+"\n\n");
            area.setText(area.getText()+"Roll No  :    "+studentIdTF.getText()+"\n\n");
            area.setText(area.getText()+"Student Name  :   "+nameTF.getText()+"\n\n");
            area.setText(area.getText()+"Semester(for which fees is to be collected)  :   "+semesterTF.getText()+"\n\n");
            area.setText(area.getText()+"Department  :  "+deptTF.getText()+"\n\n");
            area.setText(area.getText()+"Course Fee  :  "+courseFeeTF.getText()+"\n\n");
            area.setText(area.getText()+"Paid Till Semester  :  "+paidTillSemTF.getText()+"\n");
            area.setText(area.getText()+"Total Paid Amount  :  "+totalPaidAmtTF.getText()+"\n");
            area.setText(area.getText()+"Due Amount  :  "+dueAmtTF.getText()+"\n");
            area.setText(area.getText()+"\n                                                                                             Signature");
        
            isReceiptGenerated=true;
            
        }else{
            Notifications.create().title("Save Details First...").showInformation();  
        }  
    }
    
    boolean validateAllFieldsForEmpty(){
        if(studentIdTF.getText().isEmpty()){
            Notifications.create().title("Student Id is required*").showError();
            studentIdTF.requestFocus();
        }else{
            if(nameTF.getText().isEmpty()){
                Notifications.create().title("Student Name is required*").showError();
                nameTF.requestFocus();
            }else{
                if(semesterTF.getText().isEmpty()){
                    Notifications.create().title("Semester is required*").showError();
                    semesterTF.requestFocus();
                }else{
                    if(deptTF.getText().isEmpty()){
                        Notifications.create().title("Department is required*").showError();
                        deptTF.requestFocus();
                    }else{
                        if(courseFeeTF.getText().isEmpty()){
                            Notifications.create().title("Course Fee is required*").showError();
                            courseFeeTF.requestFocus();
                        }else{
                            if(paidTillSemTF.getText().isEmpty()){
                                Notifications.create().title("Paid Till Semester is required*").showError();
                                paidTillSemTF.requestFocus();
                            }else{
                                if(totalPaidAmtTF.getText().isEmpty()){
                                    Notifications.create().title("Total Paid Amount is required*").showError();
                                    totalPaidAmtTF.requestFocus();
                                }else{
                                    if(dueAmtTF.getText().isEmpty()){
                                        Notifications.create().title("Due Amount is required*").showError();
                                        dueAmtTF.requestFocus();
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
        return false;
    }
    boolean validateAllFieldsForWrongEntry(){
       if(studentIdTF.getText().matches("[0-9]+")){
            Notifications.create().title("Student Id is not valid*").showError();
            studentIdTF.requestFocus();
        }else{
            if(nameTF.getText().matches("^[a-zA-Z]*$")){
                Notifications.create().title("Student Name is not valid*").showError();
                nameTF.requestFocus();
            }else{
                if(semesterTF.getText().matches("[0-9]+")){
                    Notifications.create().title("Semester is not valid*").showError();
                    semesterTF.requestFocus();
                }else{
                    if(deptTF.getText().matches("^[a-zA-Z]*$")){
                        Notifications.create().title("Department is not valid*").showError();
                        deptTF.requestFocus();
                    }else{
                        if(courseFeeTF.getText().matches("[0-9]+")){
                            Notifications.create().title("Course Fee is not valid*").showError();
                            courseFeeTF.requestFocus();
                        }else{
                            if(paidTillSemTF.getText().matches("[0-9]+")){
                                Notifications.create().title("Paid Till Semester is not valid*").showError();
                                paidTillSemTF.requestFocus();
                            }else{
                                if(totalPaidAmtTF.getText().matches("[0-9]+")){
                                    Notifications.create().title("Total Paid Amount is not valid*").showError();
                                    totalPaidAmtTF.requestFocus();
                                }else{
                                    if(dueAmtTF.getText().matches("[0-9]+")){
                                        Notifications.create().title("Due Amount is not valid*").showError();
                                        dueAmtTF.requestFocus();
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
        return false;
    }

    @FXML
    private void saveDetails(ActionEvent event) {
        if(validateAllFieldsForEmpty()){
            if(validateAllFieldsForWrongEntry()){
                int studentId=Integer.parseInt(studentIdTF.getText());
                String studentName=nameTF.getText();
                int semester=Integer.parseInt(semesterTF.getText());
                String department=deptTF.getText();
                int courseFee=Integer.parseInt(courseFeeTF.getText());
                int paidTillSem=Integer.parseInt(paidTillSemTF.getText());
                int totalPaidAmount=Integer.parseInt(totalPaidAmtTF.getText());
                int dueAmount=Integer.parseInt(dueAmtTF.getText());
                int receiptNo=0;
                Fees  fees=new Fees(studentId, studentName, semester, department, courseFee, paidTillSem, totalPaidAmount, dueAmount, receiptNo);
                int r=feesManagementServicesImpl.addFees(fees);
        
                if(r>0){
                    Notifications.create().title("Fee Submitted Successfully").showInformation();  
                    isFeeCollected=true;
                }else{
                    Notifications.create().title("Fee Not Submitted ").showError();
                }
            }
          }
      }
        

    @FXML
    private void reset(ActionEvent event) {
        studentIdTF.clear();
        nameTF.clear();
        fnameTF.clear();
        dobTF.clear();
        semesterTF.clear();
        deptTF.clear();
        courseFeeTF.clear();
        paidTillSemTF.clear();
        totalPaidAmtTF.clear();
        dueAmtTF.clear();
        area.clear();
    }

    @FXML
    private void printReceipt(ActionEvent event) {
      if(area!=null && !dueAmtTF.getText().isEmpty() && isFeeCollected && isReceiptGenerated){
        print(area); 
        isReceiptPrinted=true;
        printBtn.setText("REPRINT");
      }else{
          Notifications.create().title("Fill all details and Generate Fee Recipt").showError();
      }
    }

    @FXML
    private void backToDashboard(ActionEvent event) {
        int flag=JOptionPane.showConfirmDialog(null, "Do you want to go back? All unsaved data will be lost...");
        if(flag==0){
            Stage stage=(Stage)area.getScene().getWindow();
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
                    if(gemail!=null){
                        adminDashboardFXMLController.setUserDetails(gemail);
                    }
                    Scene scene = new Scene(root,screenWidth,screenHeight);
                    
                    stage.setScene(scene);
                    stage.setTitle("Admin - P.K. Roy Memorial College,Dhanbad  Smart-Ed College ERP v1.1.1");
                    stage.setX(0);
                    stage.setY(0);
                  
                    stage.show();
            }catch(Exception ex){
                ex.printStackTrace();;
            }
        }
    }

    
    
    
    
    
    
     private void print(Node node) {
//    System.out.println("Creating a printer job...");

    PrinterJob job = PrinterJob.createPrinterJob();
    if (job != null && job.showPrintDialog(node.getScene().getWindow())) {
      // Show the printer job status 
            printBtn.textProperty().bind(job.jobStatusProperty().asString()); 
          
       // Print the node 
      boolean printed = job.printPage(node);
      if (printed) {
        job.endJob();
      } else {
        printBtn.textProperty().unbind(); 
        printBtn.setText("Printing Failed."); 
      }
    } else {
      printBtn.setText("Couldn't Printed"); 
    }
  }
     
     void setUserDetails(String email,String usertype){
         gemail=email;
         
         //for auto studentORadminfind
         if(usertype.equals("Student")){
             
             LoginUser loginUser=new LoginUser();
             LoginPageServicesImpl loginPageServicesImpl=new LoginPageServicesImpl();
             loginUser=loginPageServicesImpl.doLoginAsStudent(email);
             int studentId=loginUser.getUserid();
             setStudentIdForStudents(studentId);
         }
      }
     
     void setStudentIdForStudents(int studentId){
         studentIdTF.setText(studentId+"");
         studentIdTF.setDisable(true);
         findStudent(new ActionEvent());
         nameTF.setDisable(true);
         fnameTF.setDisable(true);
         dobTF.setDisable(true);
     }
     
     
}
