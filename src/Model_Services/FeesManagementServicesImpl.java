
package Model_Services;

import Model_Beans.Fees;
import Model_DAO.FeesManagementDAOImpl;
import java.util.List;

/**
 *
 * @author anujv
 */
public class FeesManagementServicesImpl implements FeesManagementServices{

    FeesManagementDAOImpl feesManagementDAOImpl;
    public FeesManagementServicesImpl() {
        feesManagementDAOImpl=new FeesManagementDAOImpl();
    }

    
    
    @Override
    public int addFees(Fees fees) {
        return feesManagementDAOImpl.addFees(fees);
    }

    @Override
    public List<Fees> showFeesDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
