
package Model_DAO;

import Model_Beans.Faculty;
import Model_Beans.Staff;
import java.util.List;

/**
 *
 * @author anujv
 */
public interface StaffManagementDAO {
    int addFaculty(Faculty faculty);
    List<Staff> showAllStaff();
}
