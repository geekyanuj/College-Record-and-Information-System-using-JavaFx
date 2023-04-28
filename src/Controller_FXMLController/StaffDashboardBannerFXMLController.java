
package Controller_FXMLController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author anujv
 */
public class StaffDashboardBannerFXMLController implements Initializable {

    private String gEmail;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 
    void setUserDetails(String email){
        gEmail=email;
        System.err.println("from staffBanener" +gEmail);
    }
}
