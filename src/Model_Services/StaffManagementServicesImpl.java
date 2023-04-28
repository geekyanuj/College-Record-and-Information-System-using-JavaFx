
package Model_Services;

import Model_Beans.Faculty;
import Model_Beans.Staff;
import Model_DAO.StaffManagementDAOImpl;
import java.util.List;

/**
 *
 * @author anujv
 */
public class StaffManagementServicesImpl implements StaffManagementServices{
    StaffManagementDAOImpl staffManagementDAOImpl;
    public StaffManagementServicesImpl() {
        staffManagementDAOImpl=new StaffManagementDAOImpl();
    }
    
    

    @Override
    public int addFaculty(Faculty faculty) {
        return staffManagementDAOImpl.addFaculty(faculty);
    }

    @Override
    public List<Staff> showAllStaff() {
        return staffManagementDAOImpl.showAllStaff();  
    }
    
}
