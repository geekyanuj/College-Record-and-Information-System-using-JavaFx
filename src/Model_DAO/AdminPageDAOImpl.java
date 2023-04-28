
package Model_DAO;

import Model_DBA.MyConnection;
import Model_Beans.LoginUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;


public class AdminPageDAOImpl implements AdminPageDAO{

    @Override
    public int updateUser(LoginUser user) {
        
        int row = 0;
        Connection connection=null;
        try{
            
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("UPDATE admin SET email=?,password=?,pic=?,phone=?,name=? WHERE admin_id=?");
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setBytes(3, user.getUserPic());
            ps.setLong(4, Long.parseLong(user.getPhone()));
            ps.setString(5, user.getName());
            ps.setInt(6, user.getUserid());
            
            row=ps.executeUpdate();   
        } catch (Exception e){
            Notifications.create().darkStyle().position(Pos.TOP_CENTER).title("Error Occured while Connecting to DB").showError();
        }
        return row; 
    }
  
}
