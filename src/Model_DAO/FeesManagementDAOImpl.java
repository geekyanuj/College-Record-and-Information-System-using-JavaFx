
package Model_DAO;

import Model_Beans.Fees;
import Model_DBA.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author anujv
 */
public class FeesManagementDAOImpl implements FeesManagementDAO{

    @Override
    public int addFees(Fees fees) {
        Connection connection=null;
        int row=0;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO fee(id,name,semester,department,course_fee,paid_till_sem,total_paid_amount,due_amount) VALUES(?,?,?,?,?,?,?,?) ON CONFLICT (id) DO UPDATE SET semester=?,paid_till_sem=?,total_paid_amount=?,due_amount=?");
            ps.setInt(1, fees.getId());
            ps.setString(2, fees.getName());
            ps.setInt(3, fees.getSemester());
            ps.setString(4, fees.getDepartment());
            ps.setInt(5, fees.getCourseFee());
            ps.setInt(6, fees.getPaidTillSem());
            ps.setInt(7, fees.getTotalPaidAmt());
            ps.setInt(8, fees.getDueAmt());
            
            ps.setInt(9, fees.getSemester());
            ps.setInt(10, fees.getPaidTillSem());
            ps.setInt(11, fees.getTotalPaidAmt());
            ps.setInt(12, fees.getDueAmt());

            row=ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<Fees> showFeesDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
