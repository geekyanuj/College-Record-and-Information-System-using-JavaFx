
package Model_DAO;

import Model_Beans.Student;
import Model_Beans.StudentAddressDetails;
import Model_Beans.StudentDocumentDetails;
import Model_Beans.StudentPersonalInformation;
import Model_Beans.StudentPreviousAcademicDetails;
import java.util.List;

/**
 *
 * @author anujv
 */
public interface StudentManagementDAO {
    public int addStudent(StudentPersonalInformation studentPersonalInformation,StudentAddressDetails studentAddressDetails,StudentPreviousAcademicDetails studentPreviousAcademicDetails,StudentDocumentDetails studentDocumentDetails);
    List<Student> displayAllStudent();
    Student displayStudentUsingStudentId(int studentId);
    StudentPersonalInformation findStudentUsingStudentId(String studentId);
    int updateStudentPersonalDetails(StudentPersonalInformation studentPersonalInformation);
    int deleteStudent(String studentId);
    public int updateStudentParentDetails(StudentPersonalInformation studentPersonalInformation);
}
