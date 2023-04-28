
package Controller_FXMLController;

import Model_Beans.StudentDocumentDetails;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

public class AddStudent4FXMLController implements Initializable {

    @FXML
    private TextField idProofTF;
    @FXML
    private JFXButton idProofChooseBtn;
    @FXML
    private TextField tenthMarksheetTF;
    @FXML
    private JFXButton tenthMarksheetChooseBtn;
    @FXML
    private TextField twelfthMarksheetTF;
    @FXML
    private JFXButton twelfthMarksheetChooseBtn;
    @FXML
    private TextField twelfthMigrationTF;
    @FXML
    private JFXButton twelfthMigrationChooseBtn;
    @FXML
    private TextField twelfthTCTF;
    @FXML
    private JFXButton twelfthTCChooseBtn;
    
    
    
    byte[] idProof;
    byte[] tenthMarksheet;
    byte[] twelfthMarksheet;
    byte[] twelfthMigration;
    byte[] twelfthTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void idProofChoose(ActionEvent event) {
        try{
            FileChooser fileChooser=new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Document Files", "*.pdf"));
            File idProofFile=fileChooser.showOpenDialog(null);    
            FileInputStream f = new FileInputStream(idProofFile);        
            idProof=new byte[(int)idProofFile.length()];
            f.read(idProof);
            idProofTF.setText(idProofFile.getAbsolutePath());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Choose Id Proof...");
            e.printStackTrace();
        }
        
    }

    @FXML
    private void tenthMarksheetChoose(ActionEvent event) {
        try{
            FileChooser fileChooser=new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Document Files", "*.pdf"));
            File tenthMarksheetFile=fileChooser.showOpenDialog(null);    
            FileInputStream f = new FileInputStream(tenthMarksheetFile);        
            tenthMarksheet=new byte[(int)tenthMarksheetFile.length()];
            f.read(tenthMarksheet);
            tenthMarksheetTF.setText(tenthMarksheetFile.getAbsolutePath());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Choose 10th Marksheet...");
            e.printStackTrace();
        }
    }

    @FXML
    private void twelfthMarksheetChoose(ActionEvent event) {
        try{
            FileChooser fileChooser=new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Document Files", "*.pdf"));
            File twelfthMarksheetFile=fileChooser.showOpenDialog(null);    
            FileInputStream f = new FileInputStream(twelfthMarksheetFile);        
            twelfthMarksheet=new byte[(int)twelfthMarksheetFile.length()];
            f.read(twelfthMarksheet);
            twelfthMarksheetTF.setText(twelfthMarksheetFile.getAbsolutePath());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Choose 12th Marksheet...");
            e.printStackTrace();
        }
    }

    @FXML
    private void twelfthMigrationChoose(ActionEvent event) {
        try{
            FileChooser fileChooser=new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Document Files", "*.pdf"));
            File twelfthMigrationFile=fileChooser.showOpenDialog(null);    
            FileInputStream f = new FileInputStream(twelfthMigrationFile);        
            twelfthMigration=new byte[(int)twelfthMigrationFile.length()];
            f.read(twelfthMigration);
            twelfthMigrationTF.setText(twelfthMigrationFile.getAbsolutePath());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Choose 12th Migration Certificate...");
            e.printStackTrace();
        }
    }

    @FXML
    private void twelfthTCChoose(ActionEvent event) {
        try{
            FileChooser fileChooser=new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Document Files", "*.pdf"));
            File twelfthTCFile=fileChooser.showOpenDialog(null);    
            FileInputStream f = new FileInputStream(twelfthTCFile);        
            twelfthTC=new byte[(int)twelfthTCFile.length()];
            f.read(twelfthTC);
            twelfthTCTF.setText(twelfthTCFile.getAbsolutePath());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Choose 12th Transfer Certificate...");
            e.printStackTrace();
        }
    }
    
    
    boolean validateAllFieldsForEmpty(){
        if(idProof==null){
            Notifications.create().title("Please Choose Id Proof").showError();
            idProofChooseBtn.requestFocus();
        }else{
            if(tenthMarksheet==null){
                Notifications.create().title("Please Choose 10th Marksheet").showError();
                tenthMarksheetChooseBtn.requestFocus();
            }else{
                if(twelfthMarksheet==null){
                    Notifications.create().title("Please Choose 12th Marksheet").showError();
                    twelfthMarksheetChooseBtn.requestFocus();
                }else{
                    if(twelfthMigration==null){
                        Notifications.create().title("Please Choose 12th Migration").showError();
                        twelfthMigrationChooseBtn.requestFocus();
                    }else{
                        if(twelfthTC==null){
                            Notifications.create().title("Please Choose 12th Transfer Certificate").showError();
                            twelfthTCChooseBtn.requestFocus();
                        }else{
                            return true;
                        }
                    }
                }
            }
        }
        return false;
        
    }
    
    StudentDocumentDetails getDataFromPage4AndSendDataToMainBoard(){
        StudentDocumentDetails studentDocumentDetails=new StudentDocumentDetails();
        studentDocumentDetails.setIdProof(idProof);
        studentDocumentDetails.setTenthMarksheet(tenthMarksheet);
        studentDocumentDetails.setTwelfthMarksheet(twelfthMarksheet);
        studentDocumentDetails.setTwelfthMigration(twelfthMigration);
        studentDocumentDetails.setTwelfthTC(twelfthTC);
        studentDocumentDetails.setPathIdProof(idProofTF.getText());
        studentDocumentDetails.setPathTenthMarksheet(tenthMarksheetTF.getText());
        studentDocumentDetails.setPathTwelfthMarksheet(twelfthMarksheetTF.getText());
        studentDocumentDetails.setPathTwelfthMigration(twelfthMigrationTF.getText());
        studentDocumentDetails.setPathTwelfthTC(twelfthTCTF.getText());
        
        
        return studentDocumentDetails;
    }
    
    void getExistingDataFromMainBoardAndSetToPage4(StudentDocumentDetails studentDocumentDetails){
        if(studentDocumentDetails!=null){ 
            idProof=studentDocumentDetails.getIdProof();
            tenthMarksheet=studentDocumentDetails.getTenthMarksheet();
            twelfthMarksheet=studentDocumentDetails.getTwelfthMarksheet();
            twelfthMigration=studentDocumentDetails.getTwelfthMigration();
            twelfthTC=studentDocumentDetails.getTwelfthTC();
            idProofTF.setText(studentDocumentDetails.getPathIdProof());
            tenthMarksheetTF.setText(studentDocumentDetails.getPathTenthMarksheet());
            twelfthMarksheetTF.setText(studentDocumentDetails.getPathTwelfthMarksheet());
            twelfthMarksheetTF.setText(studentDocumentDetails.getPathTwelfthMarksheet());
            twelfthMigrationTF.setText(studentDocumentDetails.getPathTwelfthMigration());
            twelfthTCTF.setText(studentDocumentDetails.getPathTwelfthTC());
        }
    }
    
}
