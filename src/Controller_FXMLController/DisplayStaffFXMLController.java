
package Controller_FXMLController;

import Model_Beans.Staff;
import Model_Services.StaffManagementServicesImpl;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class DisplayStaffFXMLController implements Initializable {

    @FXML
    private TableView<Object> staffTV;
    @FXML
    private TableColumn<Staff, Integer> idCol;
    @FXML
    private TableColumn<Staff, String> nameCol;
    @FXML
    private TableColumn<Staff, String> genderCol;
    @FXML
    private TableColumn<Staff, String> emailCol;
    @FXML
    private TableColumn<Staff, String> mobileCol;
    @FXML
    private TableColumn<Staff, String> qualifiactionCol;
    @FXML
    private TableColumn<Staff, String> designationCol;
    @FXML
    private TableColumn<Staff, String> experienceCol;

    StaffManagementServicesImpl staffManagementServicesImpl;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("staffGender"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobileNo"));
        qualifiactionCol.setCellValueFactory(new PropertyValueFactory<>("qualification"));
        designationCol.setCellValueFactory(new PropertyValueFactory<>("designation"));
        experienceCol.setCellValueFactory(new PropertyValueFactory<>("experience"));
        
        staffManagementServicesImpl=new StaffManagementServicesImpl();
        List<Staff> staffList=new ArrayList<>();
        staffList=staffManagementServicesImpl.showAllStaff();
        staffTV.getItems().clear();
        for(Staff staff:staffList){
           
            staffTV.getItems().add(new Staff(staff.getStaffId(), staff.getStaffName(), staff.getStaffGender(), staff.getEmail(), staff.getMobileNo(), staff.getQualification(), staff.getDesignation(), staff.getExperience()));
        }
       
    }    
    
}
