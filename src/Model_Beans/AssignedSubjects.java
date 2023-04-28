
package Model_Beans;

/**
 *
 * @author anujv
 */
public class AssignedSubjects {
   private int facultyId;
   private String facultyName;
   private String subjectCode;
   private String subjectName;
   private String department;
   private int sem; 
   private String position; 

    public AssignedSubjects() {
    }

    public AssignedSubjects(int facultyId, String facultyName, String subjectCode, String subjectName, String department, int sem, String position) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.department = department;
        this.sem = sem;
        this.position = position;
    }
    
    

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
   
}
