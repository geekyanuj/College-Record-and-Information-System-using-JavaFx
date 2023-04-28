
package Model_DAO;

import Model_Beans.Fees;
import java.util.List;


/**
 *
 * @author anujv
 */
public interface FeesManagementDAO {

    int addFees(Fees fees);
    List<Fees> showFeesDetails();
}
