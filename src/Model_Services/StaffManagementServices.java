
package Model_Services;

import Model_Beans.Faculty;
import Model_Beans.Staff;
import java.util.List;

/**
 *
 * @author anujv
 */
public interface StaffManagementServices {
    int addFaculty(Faculty faculty);
    List<Staff> showAllStaff();
}
