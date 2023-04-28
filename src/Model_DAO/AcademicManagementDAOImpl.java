
package Model_DAO;

import Model_Beans.AssignedSubjects;
import Model_Beans.Course;
import Model_Beans.Department;
import Model_Beans.Routine;
import Model_Beans.Subject;
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
public class AcademicManagementDAOImpl implements AcademicManagementDAO{

    @Override
    public int addDepartment(Department dept) {
        Connection connetion=null;
        String columnNames[] = new String[] { "department_id" };
        int generatedDeptId = 0;
        try
        {
            connetion=MyConnection.getConnection();
            PreparedStatement ps=connetion.prepareStatement("INSERT INTO department(department_name,department_hod,department_capacity) VALUES(?,?,?)",columnNames);
            ps.setString(1, dept.getDepartmentName());
            ps.setString(2, dept.getDepartmentHod());
            ps.setInt(3, dept.getDepartmentCapacity());
            
            if(ps.executeUpdate()>0){
                  java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                  if(generatedKeys.next()){
                    generatedDeptId = generatedKeys.getInt(1);
                  }
             }else{
                 System.err.println("Not inserted data");
             }
        } catch (Exception e){
            System.err.println("Problem while inserting department");
            e.printStackTrace();
        }
        return generatedDeptId;
    }

    @Override
    public List<Department> showAllDepartments() {
        Connection connetion=null;
        List<Department> departmentList=new ArrayList<>();
        try
        {
            connetion=MyConnection.getConnection();
            PreparedStatement ps=connetion.prepareStatement("SELECT * FROM department");
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
               Department department=new Department(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
               departmentList.add(department);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return departmentList;
    }

    @Override
    public Department findDepartmentUsingDeptId(int departementId) {
        Connection connection=null;
        Department department=new Department();
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM department WHERE department_id=?");
            ps.setInt(1, departementId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                department.setDepartmentId(rs.getInt(1));
                department.setDepartmentName(rs.getString(2));
                department.setDepartmentHod(rs.getString(3));
                department.setDepartmentCapacity(rs.getInt(4));
            }
     
        } catch (Exception e){
            System.out.println("Error while finding department");
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public int updateDepartment(Department dept) {
        Connection connetion=null;
        int row=0;
        try{
            connetion=MyConnection.getConnection();
            PreparedStatement ps=connetion.prepareStatement("UPDATE department SET department_name=?,department_hod=?,department_capacity=? WHERE department_id=?");
            ps.setString(1, dept.getDepartmentName());
            ps.setString(2, dept.getDepartmentHod());
            ps.setInt(3, dept.getDepartmentCapacity());
            ps.setInt(4, dept.getDepartmentId());
            row=ps.executeUpdate();
            
        } catch (Exception e){
            System.err.println("Problem while updating department");
            System.err.println("Not inserted data");
            e.printStackTrace();
        }
        return row;
    }
    
    @Override
    public int addSubject(Subject subject) {
        Connection connection=null;
        int row=0;
         try
        {
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO Subject(subject_code, subject_name, subject_type, subject_theory_marks, subject_practical_marks, subject_total_marks,semester) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, subject.getSubjectCode());
            ps.setString(2, subject.getSubjectName());
            ps.setString(3, subject.getSubjectType());
            ps.setInt(4, subject.getSubjectTheoryMarks());
            ps.setInt(5, subject.getSubjectPracticalMarks());
            ps.setInt(6, subject.getSubjectTotalMarks());
            ps.setInt(7, subject.getSemester());
            
            row=ps.executeUpdate();
                  
        } catch (Exception e){
            System.err.println("Problem while inserting Subject");
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<Subject> displayAllSubject() {
        List<Subject> subjectList=new ArrayList<>();
        Connection connection=null;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM subject");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                subjectList.add(new Subject(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),rs.getInt(7)));
            }
            
        } catch (Exception e){
        }
        return subjectList;
    }

    @Override
    public int addAssignedSubject(AssignedSubjects assignedSubjects) {
        Connection connection=null;
        int row=0;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO assigned_subjects(faculty_id,faculty_name,subject_code,subject_name,semester,position) VALUES(?,?,?,?,?,?)");
            ps.setInt(1, assignedSubjects.getFacultyId());
            ps.setString(2,assignedSubjects.getFacultyName());
            ps.setString(3,assignedSubjects.getSubjectCode());
            ps.setString(4,assignedSubjects.getSubjectName());
            ps.setInt(5,assignedSubjects.getSem());
            ps.setString(6,assignedSubjects.getPosition());
            row=ps.executeUpdate();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<AssignedSubjects> displayAssignedSubject(int faculty_id) {
        List<AssignedSubjects> assignedSubjectList=new ArrayList<>();
        Connection connection=null;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM assigned_subjects WHERE faculty_id=?");
            ps.setInt(1, faculty_id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                assignedSubjectList.add(new AssignedSubjects(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), rs.getInt(5), rs.getString(6)));
//                assignedSubjects.setFacultyId(rs.getInt(1));
//                assignedSubjects.setFacultyName(rs.getString(2));
//                assignedSubjects.setSubjectCode(rs.getString(3));
//                assignedSubjects.setSubjectName(rs.getString(4));
//                assignedSubjects.setSem(rs.getInt(5));
//                assignedSubjects.setPosition(rs.getString(6));
            }
         
        } catch (Exception e){
            e.printStackTrace();
        }
        return assignedSubjectList;
    }
    
    

    @Override
    public int addCourse(Course course) {
        Connection connection=null;
        int row=0;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO courses(course_id,course_name,course_type,course_no_of_semester,course_duration) VALUES(?,?,?,?,?)");
            ps.setString(1, course.getCourse_id());
            ps.setString(2, course.getCourse_name());
            ps.setString(3, course.getCourse_type());
            ps.setInt(4, course.getCourse_noOfSemester());
            ps.setString(5, course.getCourse_duration());
            
            row=ps.executeUpdate();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<Course> displayAllCourse() {
        Connection connection=null;
        List<Course> courseList=new ArrayList<>();
        try{
            connection=MyConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM courses");
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                courseList.add(new Course(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return courseList;
    }

    @Override
    public int addRoutine(Routine routine) {
        Connection connection=null;
        int row=0;
        try
        {
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO routine(department,semester,mon_p1_subejct,mon_p2_subejct,mon_p3_subejct,mon_p4_subejct,tue_p1_subejct,tue_p2_subejct,tue_p3_subejct,tue_p4_subejct,wed_p1_subejct,wed_p2_subejct,wed_p3_subejct,wed_p4_subejct,thu_p1_subejct,thu_p2_subejct,thu_p3_subejct,thu_p4_subejct,fri_p1_subejct,fri_p2_subejct,fri_p3_subejct,fri_p4_subejct,sat_p1_subejct,sat_p2_subejct,sat_p3_subejct,sat_p4_subejct) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, routine.getDepartment());
            ps.setInt(2, routine.getSemester());
            ps.setString(3, routine.getMon_p1_subejct());
            ps.setString(4, routine.getMon_p2_subejct());
            ps.setString(5, routine.getMon_p3_subejct());
            ps.setString(6, routine.getMon_p4_subejct());
            ps.setString(7, routine.getTue_p1_subejct());
            ps.setString(8, routine.getTue_p2_subejct());
            ps.setString(9, routine.getTue_p3_subejct());
            ps.setString(10, routine.getTue_p4_subejct());
            ps.setString(11, routine.getWed_p1_subejct());
            ps.setString(12, routine.getWed_p2_subejct());
            ps.setString(13, routine.getWed_p3_subejct());
            ps.setString(14, routine.getWed_p4_subejct());
            ps.setString(15, routine.getThu_p1_subejct());
            ps.setString(16, routine.getThu_p2_subejct());
            ps.setString(17, routine.getThu_p3_subejct());
            ps.setString(18, routine.getThu_p4_subejct());
            ps.setString(19, routine.getFri_p1_subejct());
            ps.setString(20, routine.getFri_p2_subejct());
            ps.setString(21, routine.getFri_p3_subejct());
            ps.setString(22, routine.getFri_p4_subejct());
            ps.setString(23, routine.getSat_p1_subejct());
            ps.setString(24, routine.getSat_p2_subejct());
            ps.setString(25, routine.getSat_p3_subejct());
            ps.setString(26, routine.getSat_p4_subejct());
            
            row=ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Routine showRoutineUsingDepartmentAndSemester(String department, int semester) {
        Routine routine = null;
        Connection connection=null;
        try
        {
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM routine WHERE department=? AND semester=?");
            ps.setString(1, department);
            ps.setInt(2, semester);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                routine=new Routine(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return routine;
    }

}
