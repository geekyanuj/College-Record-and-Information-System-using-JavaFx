
package Model_DAO;

import Model_Beans.Student;
import Model_Beans.StudentAttendance;
import Model_DBA.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anujv
 */
public class AttendanceManagementDAOImpl implements AttendanceManagementDAO{

    @Override
    public List<Student> getAllStudentUsingSemesterAndCourse(String department, int semester) {
        List<Student> studentList = new ArrayList<>();
        Connection connection=null;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT id,name,department_hail,current_semester FROM student WHERE department_hail=? AND current_semester=?");
            ps.setString(1, department);
            ps.setInt(2, semester);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                studentList.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            ps.close();
            rs.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public int setAndAddStudentAttendance(List<StudentAttendance> studentAttendanceList) {
        Connection connection=null;
        int row=0;
        try{
            connection=MyConnection.getConnection();
            for(StudentAttendance studentAttendance:studentAttendanceList){
               
                PreparedStatement ps=connection.prepareStatement("INSERT INTO student_attendance(date,student_id,student_name,department,semester,status) VALUES(?,?,?,?,?,?) ON CONFLICT(student_id) DO UPDATE SET status=?");
                ps.setDate(1, studentAttendance.getDate());
                ps.setInt(2, studentAttendance.getStudentId());
                ps.setString(3, studentAttendance.getName());
                ps.setString(4, studentAttendance.getDepartment());
                ps.setInt(5, studentAttendance.getSemester());
                ps.setString(6, studentAttendance.getStatus()+"");
                
                ps.setString(7, studentAttendance.getStatus()+"");
                row=ps.executeUpdate();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<StudentAttendance> getStudentAttendanceListUsingDate(Date date, String department, int semester) {
        List<StudentAttendance> studentAttendanceList = new ArrayList<>();
        Connection connection=null;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT date,student_id,student_name,department,semester,status FROM student_attendance WHERE date=? AND department=? AND semester=?");
            ps.setDate(1, date);
            ps.setString(2, department);
            ps.setInt(3, semester);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                studentAttendanceList.add(new StudentAttendance(rs.getDate(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6).charAt(0))); 
            }
            ps.close();
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return studentAttendanceList;
    }
  
}