
package Controller_FXMLController;

import Model_Beans.Department;
import Model_Beans.Routine;
import Model_DBA.MyConnection;
import Model_Services.AcademicManagementServicesImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class ShowRoutineFXMLController implements Initializable {

    @FXML
    private JFXComboBox<String> departmentCB;
    @FXML
    private JFXComboBox<String> semesterCB;
    @FXML
    private Label mon_p1_subejctLabel;
    @FXML
    private Label tue_p1_subejctLabel;
    @FXML
    private Label wed_p1_subejctLabel;
    @FXML
    private Label thu_p1_subejctLabel;
    @FXML
    private Label fri_p1_subejctLabel;
    @FXML
    private Label sat_p1_subejctLabel;
    @FXML
    private Label mon_p2_subejctLabel;
    @FXML
    private Label tue_p2_subejctLabel;
    @FXML
    private Label wed_p2_subejctLabel;
    @FXML
    private Label thu_p2_subejctLabel;
    @FXML
    private Label fri_p2_subejctLabel;
    @FXML
    private Label sat_p2_subejctLabel;
    @FXML
    private Label mon_p3_subejctLabel;
    @FXML
    private Label tue_p3_subejctLabel;
    @FXML
    private Label wed_p3_subejctLabel;
    @FXML
    private Label thu_p3_subejctLabel;
    @FXML
    private Label fri_p3_subejctLabel;
    @FXML
    private Label sat_p3_subejctLabel;
    @FXML
    private Label mon_p4_subejctLabel;
    @FXML
    private Label tue_p4_subejctLabel;
    @FXML
    private Label wed_p4_subejctLabel;
    @FXML
    private Label thu_p4_subejctLabel;
    @FXML
    private Label fri_p4_subejctLabel;
    @FXML
    private Label sat_p4_subejctLabel;
    @FXML
    private JFXButton printBtn;
    @FXML
    private AnchorPane printArea;
    @FXML
    private Button backBtn;

    AcademicManagementServicesImpl academicManagementServicesImpl;
    List<Department> departmentList;
    List<String> departmentNameList;
    Routine routine;
    String semesters[]={"1","2","3","4","5","6","7","8"};
    
    private String gUsertype;
    private String gEmail;
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
    }    

    @FXML
    private void print(ActionEvent event) {
        try
        {
            String report = "C:\\Users\\anujv\\Documents\\NetBeansProjects\\College Record and Information System v1.1.1\\src\\View_JasperJRXML\\Routine_A4_Landscape.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(report);
            
            Map<String,Object> data=new HashMap<>();
            data.put("department",departmentCB.getValue());
            data.put("semester",Integer.parseInt(semesterCB.getValue()));
            
            JasperPrint jp=JasperFillManager.fillReport(jr,data,MyConnection.getConnection());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void semesterCBStateChanged(ActionEvent event) {
        String department=departmentCB.getValue();
        int semester=Integer.parseInt(semesterCB.getValue());
        routine=academicManagementServicesImpl.showRoutineUsingDepartmentAndSemester(department, semester);
        if(routine==null){
            mon_p1_subejctLabel.setText("-");
            mon_p2_subejctLabel.setText("-");
            mon_p3_subejctLabel.setText("-");
            mon_p4_subejctLabel.setText("-");
            tue_p1_subejctLabel.setText("-");
            tue_p2_subejctLabel.setText("-");
            tue_p3_subejctLabel.setText("-");
            tue_p4_subejctLabel.setText("-");
            wed_p1_subejctLabel.setText("-");
            wed_p2_subejctLabel.setText("-");
            wed_p3_subejctLabel.setText("-");
            wed_p4_subejctLabel.setText("-");
            thu_p1_subejctLabel.setText("-");
            thu_p2_subejctLabel.setText("-");
            thu_p3_subejctLabel.setText("-");
            thu_p4_subejctLabel.setText("-");
            fri_p1_subejctLabel.setText("-");
            fri_p2_subejctLabel.setText("-");
            fri_p3_subejctLabel.setText("-");
            fri_p4_subejctLabel.setText("-");
            sat_p1_subejctLabel.setText("-");
            sat_p2_subejctLabel.setText("-");
            sat_p3_subejctLabel.setText("-");
            sat_p4_subejctLabel.setText("-");
            Notifications.create().title("No data found agaist this criteria").showError();
        }else{
            mon_p1_subejctLabel.setText(routine.getMon_p1_subejct());
            mon_p2_subejctLabel.setText(routine.getMon_p2_subejct());
            mon_p3_subejctLabel.setText(routine.getMon_p3_subejct());
            mon_p4_subejctLabel.setText(routine.getMon_p4_subejct());
            tue_p1_subejctLabel.setText(routine.getTue_p1_subejct());
            tue_p2_subejctLabel.setText(routine.getTue_p2_subejct());
            tue_p3_subejctLabel.setText(routine.getTue_p3_subejct());
            tue_p4_subejctLabel.setText(routine.getTue_p4_subejct());
            wed_p1_subejctLabel.setText(routine.getWed_p1_subejct());
            wed_p2_subejctLabel.setText(routine.getWed_p2_subejct());
            wed_p3_subejctLabel.setText(routine.getWed_p3_subejct());
            wed_p4_subejctLabel.setText(routine.getWed_p4_subejct());
            thu_p1_subejctLabel.setText(routine.getThu_p1_subejct());
            thu_p2_subejctLabel.setText(routine.getThu_p2_subejct());
            thu_p3_subejctLabel.setText(routine.getThu_p3_subejct());
            thu_p4_subejctLabel.setText(routine.getThu_p4_subejct());
            fri_p1_subejctLabel.setText(routine.getFri_p1_subejct());
            fri_p2_subejctLabel.setText(routine.getFri_p2_subejct());
            fri_p3_subejctLabel.setText(routine.getFri_p3_subejct());
            fri_p4_subejctLabel.setText(routine.getFri_p4_subejct());
            sat_p1_subejctLabel.setText(routine.getSat_p1_subejct());
            sat_p2_subejctLabel.setText(routine.getSat_p2_subejct());
            sat_p3_subejctLabel.setText(routine.getSat_p3_subejct());
            sat_p4_subejctLabel.setText(routine.getSat_p4_subejct());
            
        }
    }
    
//    private void print(Node node) {
//        node.setScaleX(1.3);
//        node.setScaleY(1);
//        
//    PrinterJob job = PrinterJob.createPrinterJob();
//    if (job != null && job.showPrintDialog(node.getScene().getWindow())) {
//      // Show the printer job status 
//      printBtn.textProperty().bind(job.jobStatusProperty().asString()); 
//       // Print the node 
//      boolean printed = job.printPage(node);
//      if (printed) {
//        job.endJob();
//        printBtn.setText("PRINT AGAIN");
//      } else {
//        printBtn.textProperty().unbind(); 
//        printBtn.setText("Printing Failed."); 
//      }
//    } else {
//      printBtn.setText("Couldn't Printed"); 
//    }
//  }

    void setUserDetails(String email,String usertype){
        gEmail=email;
        gUsertype=usertype;
        
        if(usertype.equals("Admin")||usertype.equals("Staff")){
            backBtn.setVisible(false);
        }
    }
    
    @FXML
    private void backToDashboard(ActionEvent event) {
        int flag=JOptionPane.showConfirmDialog(null, "Do you want to go back? All unsaved data will be lost...");
        if(flag==0){
            Stage stage=(Stage)backBtn.getScene().getWindow();
            stage.close();
//            stage=new Stage();
//             int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
//             int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
//            try{
//                    FXMLLoader loaders=new FXMLLoader(getClass().getResource("/View_FXMLGUI/StudentDashboardFXML.fxml"));
//                    Parent root=loaders.load();
//                    StudentDashboardFXMLController studentDashboardFXMLController=loaders.getController();
//                    if(gEmail!=null){
//                        studentDashboardFXMLController.setUserDetails(gEmail);
//                    }
//                    Scene scene = new Scene(root,screenWidth,screenHeight);
//                    
//                    stage.setScene(scene);
//                    stage.setTitle("Show Routine -Student - P.K. Roy Memorial College,Dhanbad - College Record and Information System v1.1.1");
//                    stage.getIcons().add(new Image("/MultimediaResources/pkroylogo.png")); 
//                    stage.setX(0);
//                    stage.setY(0);
//                    stage.setMaximized(true);
//                    stage.show();
                    
//                    
//                }catch (IOException ex){
//                    ex.printStackTrace();
//                }
        }
    }
}
