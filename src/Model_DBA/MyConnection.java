package Model_DBA;
import java.sql.*;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;


public class MyConnection {
    public static Connection getConnection() throws InterruptedException{
          Connection connection =null;
           try
        {
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Smart-Ed College ERP","postgres","Root@123");
            
        } catch (Exception e)
        {
            Notifications.create().position(Pos.TOP_RIGHT).text("Problem while Connecting to database").title("Error Occurred in MyConnection Class").showError();
            Thread.sleep(3000);
        }
        return connection;
    }
 
}
