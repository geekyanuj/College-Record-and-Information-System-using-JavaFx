
package Model_Services;

import Model_Beans.Student;
import Model_Beans.StudentAttendance;
import Model_DAO.AttendanceManagementDAOImpl;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author anujv
 */
public class AttendanceManagementServicesImpl implements AttendanceManagementServices{
    AttendanceManagementDAOImpl attendanceManagementDAOImpl;
    
    
    public AttendanceManagementServicesImpl() {
        attendanceManagementDAOImpl=new AttendanceManagementDAOImpl();
    }
    
    
    

    @Override
    public List<Student> getAllStudentUsingSemesterAndCourse(String department, int semester) {
        return attendanceManagementDAOImpl.getAllStudentUsingSemesterAndCourse(department, semester);
    }

    @Override
    public int setAndAddStudentAttendance(List<StudentAttendance> studentAttendanceList) {
        return attendanceManagementDAOImpl.setAndAddStudentAttendance(studentAttendanceList);
    }

    @Override
    public List<StudentAttendance> getStudentAttendanceListUsingDate(Date date, String department, int semester) {
        return attendanceManagementDAOImpl.getStudentAttendanceListUsingDate(date, department, semester);
    }
    
}
