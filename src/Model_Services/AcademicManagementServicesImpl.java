
package Model_Services;

import Model_Beans.AssignedSubjects;
import Model_Beans.Course;
import Model_Beans.Department;
import Model_Beans.Routine;
import Model_Beans.Subject;
import Model_DAO.AcademicManagementDAOImpl;
import java.util.List;

/**
 *
 * @author anujv
 */
public class AcademicManagementServicesImpl implements AcademicManagementServices{
    AcademicManagementDAOImpl academicManagementDAOImpl;

    public AcademicManagementServicesImpl() {
        academicManagementDAOImpl=new AcademicManagementDAOImpl();
    }

    @Override
    public int addDepartment(Department dept) {
        return academicManagementDAOImpl.addDepartment(dept);
    }

    @Override
    public List<Department> showAllDepartments() {
        return academicManagementDAOImpl.showAllDepartments();
    }

    @Override
    public Department findDepartmentUsingDeptId(int departementId) {
        return academicManagementDAOImpl.findDepartmentUsingDeptId(departementId);
    }

    @Override
    public int updateDepartment(Department dept) {
        return academicManagementDAOImpl.updateDepartment(dept);
    }

    @Override
    public int addSubject(Subject subject) {
        return academicManagementDAOImpl.addSubject(subject);
    }

    @Override
    public List<Subject> displayAllSubject() {
        return academicManagementDAOImpl.displayAllSubject();
    }

    @Override
    public int addAssignedSubject(AssignedSubjects assignedSubjects) {
        return academicManagementDAOImpl.addAssignedSubject(assignedSubjects);
    }

    @Override
    public List<AssignedSubjects> displayAssignedSubject(int faculty_id) {
        return academicManagementDAOImpl.displayAssignedSubject(faculty_id);
    }

    @Override
    public int addCourse(Course course) {
        return academicManagementDAOImpl.addCourse(course);
    }

    @Override
    public List<Course> displayAllCourse() {
        return academicManagementDAOImpl.displayAllCourse();
    }

    @Override
    public int addRoutine(Routine routine) {
        return academicManagementDAOImpl.addRoutine(routine);
    }

    @Override
    public Routine showRoutineUsingDepartmentAndSemester(String department, int semester) {
        return academicManagementDAOImpl.showRoutineUsingDepartmentAndSemester(department, semester);
    }
    

    
}
