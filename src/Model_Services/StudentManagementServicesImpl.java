
package Model_Services;

import Model_DAO.StudentManagementDAOImpl;
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
public class StudentManagementServicesImpl implements StudentManagementServices{
    
    StudentManagementDAOImpl studentManagementDAOImpl;

    public StudentManagementServicesImpl() {
        studentManagementDAOImpl=new StudentManagementDAOImpl();
    }
    
        @Override
        public int addStudent(StudentPersonalInformation studentPersonalInformation, StudentAddressDetails studentAddressDetails, StudentPreviousAcademicDetails studentPreviousAcademicDetails, StudentDocumentDetails studentDocumentDetails) {
        return studentManagementDAOImpl.addStudent(studentPersonalInformation, studentAddressDetails, studentPreviousAcademicDetails, studentDocumentDetails);
    }

    @Override
    public List<Student> displayAllStudent() {
        return studentManagementDAOImpl.displayAllStudent();
    }

    @Override
    public Student displayStudentUsingStudentId(int studentId) {
        return studentManagementDAOImpl.displayStudentUsingStudentId(studentId);
    }

    @Override
    public StudentPersonalInformation findStudentUsingStudentId(String studentId) {
        return studentManagementDAOImpl.findStudentUsingStudentId(studentId);
    }

    @Override
    public int updateStudentPersonalDetails(StudentPersonalInformation studentPersonalInformation) {
        return studentManagementDAOImpl.updateStudentPersonalDetails(studentPersonalInformation);
    }

    @Override
    public int deleteStudent(String studentId) {
        return studentManagementDAOImpl.deleteStudent(studentId);
    }

    public int updateStudentParentDetails(StudentPersonalInformation studentPersonalInformation) {
        return studentManagementDAOImpl.updateStudentParentDetails(studentPersonalInformation);
    }
}
