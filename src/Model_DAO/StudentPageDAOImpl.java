
package Model_DAO;

import Model_Beans.LoginUser;
import Model_DBA.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author anujv
 */
public class StudentPageDAOImpl implements StudentPageDAO{

    @Override
    public int updateStudentProfile(LoginUser user) {
        int row=0;
        Connection connection=null;
        try
        {
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("UPDATE student SET name=?,email=?,mobile_no=?,profile_pic=?,password=? WHERE email=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setBytes(4, user.getUserPic());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getEmail());
            row=ps.executeUpdate();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return row;
    }
    
}
