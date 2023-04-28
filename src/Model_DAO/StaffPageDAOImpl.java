
package Model_DAO;

import Model_Beans.LoginUser;
import Model_DBA.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author anujv
 */
public class StaffPageDAOImpl implements StaffPageDAO{

    @Override
    public int updateStaffProfile(LoginUser user) {
        int row=0;
        Connection connection=null;
        try
        {
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("UPDATE faculty SET faculty_name=?,faculty_email=?,faculty_mobile=?,pic=?,password=? WHERE faculty_email=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setBytes(4, user.getUserPic());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getEmail());
            row=ps.executeUpdate();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
        return row;
    }
    
}
