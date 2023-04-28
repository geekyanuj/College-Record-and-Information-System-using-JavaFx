
package Model_Services;

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
public interface StudentManagementServices {
    public int addStudent(StudentPersonalInformation studentPersonalInformation,StudentAddressDetails studentAddressDetails,StudentPreviousAcademicDetails studentPreviousAcademicDetails,StudentDocumentDetails studentDocumentDetails);
    public List<Student> displayAllStudent();
    Student displayStudentUsingStudentId(int studentId);
    StudentPersonalInformation findStudentUsingStudentId(String studentId);
    int updateStudentPersonalDetails(StudentPersonalInformation studentPersonalInformation);
    int deleteStudent(String studentId);
    int updateStudentParentDetails(StudentPersonalInformation studentPersonalInformation);
}
