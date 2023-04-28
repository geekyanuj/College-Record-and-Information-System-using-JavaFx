
package Model_DAO;

import Model_DBA.MyConnection;
import Model_Beans.LoginUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

public class LoginPageDAOImpl implements LoginPageDAO{

    @Override
    public LoginUser doLoginAsAdmin(String email) {
        LoginUser user = new LoginUser();
        Connection connection=null;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT admin_id,name,email,password,pic,phone FROM admin WHERE email=?");
            ps.setString(1, email);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                user.setUserid(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setUserPic(rs.getBytes(5));
                user.setPhone(rs.getString(6));
                user.setUsertype("Admin");
            }
            rs.close();
            ps.close();
            
        } catch (Exception e){
            e.printStackTrace();
            Notifications.create().darkStyle().position(Pos.TOP_LEFT).title("Error Occured while Connecting to DB").showError();
        }
        
    return user;
    }

    @Override
    public String getPassword(String username) {
        Connection connection=null;
        String password = null;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("select password from userlist where username=?");
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                password=rs.getString(1);
            }
        } catch (Exception e){
            
        }
        return password;
    }

    @Override
    public LoginUser doLoginAsStaff(String email) {
        LoginUser user = new LoginUser();
        Connection connection=null;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT faculty_id,faculty_name,faculty_email,password,pic,faculty_mobile FROM faculty WHERE faculty_email=?");
            ps.setString(1, email);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                user.setUserid(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setUserPic(rs.getBytes(5));
                user.setPhone(rs.getString(6));
                user.setUsertype("Staff");
            }
            rs.close();
            ps.close();
            
        } catch (Exception e){
            e.printStackTrace();
            Notifications.create().darkStyle().position(Pos.TOP_LEFT).title("Error Occured while Connecting to DB").showError();
        }
        return user;
    }

    @Override
    public LoginUser doLoginAsStudent(String email) {
        LoginUser user = new LoginUser();
        Connection connection=null;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT id,name,email,password,profile_pic,mobile_no FROM student WHERE email=?");
            ps.setString(1, email);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                user.setUserid(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setUserPic(rs.getBytes(5));
                user.setPhone(rs.getString(6));
                user.setUsertype("Student");
            }
            rs.close();
            ps.close();
            
        } catch (Exception e){
            e.printStackTrace();
            Notifications.create().darkStyle().position(Pos.TOP_LEFT).title("Error Occured while Connecting to DB").showError();
        }
        
    return user;
    }
    
}
