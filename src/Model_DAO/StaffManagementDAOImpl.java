
package Model_DAO;

import Model_Beans.Faculty;
import Model_Beans.Staff;
import Model_DBA.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anujv
 */
public class StaffManagementDAOImpl implements StaffManagementDAO{

    @Override
    public int addFaculty(Faculty faculty) {
        int generatedFacultyId = 0;
        String columnNames[]=new String[]{"faculty_id"};
        Connection connection=null;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO faculty(faculty_name,faculty_gender,faculty_city,faculty_state,faculty_email,faculty_mobile,faculty_qualification,faculty_designation,faculty_experience,pic,password) VALUES (?,?,?,?,?,?,?,?,?,?,?);",columnNames);
            ps.setString(1, faculty.getFacultyName());
            ps.setString(2, faculty.getFacultyGender());
            ps.setString(3, faculty.getCity());
            ps.setString(4, faculty.getState());
            ps.setString(5, faculty.getEmail());
            ps.setString(6, faculty.getMobileNo());
            ps.setString(7, faculty.getQualification());
            ps.setString(8, faculty.getDesignation());
            ps.setString(9, faculty.getExperience());
            ps.setBytes(10, faculty.getPic());
            ps.setString(11, "PKROY@123");
           
            if(ps.executeUpdate()>0){
                  java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                  if(generatedKeys.next()){
                    generatedFacultyId = generatedKeys.getInt(1);
                  }
             }else{
                 System.err.println("Not inserted faculty");
             }
        } catch (Exception e){
            e.printStackTrace();
        }
        return generatedFacultyId;
    }

    @Override
    public List<Staff> showAllStaff() {
        Connection connection=null;
        List<Staff> staffList=new ArrayList<>();
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM faculty");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                staffList.add(new Staff(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBytes(11)));
            }
        }catch (Exception e){
            
        }
        return staffList;
    }
    
}
