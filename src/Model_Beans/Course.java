
package Model_Beans;


/**
 *
 * @author anujv
 */
public class Course {
    
    String course_id;
    String course_name;
    String course_type;
    int course_noOfSemester;
    String course_duration;
//    List<Subject>  subjects;

    public Course() {
    }

    public Course(String course_id, String course_name, String course_type, int course_noOfSemester, String course_duration) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_type = course_type;
        this.course_noOfSemester = course_noOfSemester;
        this.course_duration = course_duration;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    
    public int getCourse_noOfSemester() {
        return course_noOfSemester;
    }

    public void setCourse_noOfSemester(int course_noOfSemester) {
        this.course_noOfSemester = course_noOfSemester;
    }

    public String getCourse_duration() {
        return course_duration;
    }

    public void setCourse_duration(String course_duration) {
        this.course_duration = course_duration;
    }
    
    
}
