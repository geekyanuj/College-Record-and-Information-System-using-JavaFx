
package Model_Services;


import Model_Beans.Fees;
import java.util.List;

/**
 *
 * @author anujv
 */
public interface FeesManagementServices {
    int addFees(Fees fees);
    List<Fees> showFeesDetails();
}
