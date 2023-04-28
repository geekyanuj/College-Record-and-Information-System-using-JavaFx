
package Model_Services;

import Model_Beans.Student;
import Model_Beans.StudentAttendance;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author anujv
 */
public interface AttendanceManagementServices {
    List<Student> getAllStudentUsingSemesterAndCourse(String department,int semester);
     int setAndAddStudentAttendance(List<StudentAttendance> studentAttendanceList);
     List<StudentAttendance> getStudentAttendanceListUsingDate(Date date,String department, int semester);
}
