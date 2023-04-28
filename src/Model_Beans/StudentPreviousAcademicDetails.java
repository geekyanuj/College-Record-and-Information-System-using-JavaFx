
package Model_Beans;

import java.util.List;


public class StudentPreviousAcademicDetails {
    private String lastPassedExamination;
    private String streamName;
    private String courseMedium;
    private String courseType;
    private String passingYear;
    private String overallPercentage;
    private String nameofUniversityBoard;
    private String schoolCollegeName;
        
    private List<Subject> subjectList;

    public StudentPreviousAcademicDetails() {
    }

    public StudentPreviousAcademicDetails(String lastPassedExamination, String streamName, String courseMedium, String courseType, String passingYear, String overallPercentage, String nameofUniversityBoard, String schoolCollegeName, List<Subject> subjectList) {
        this.lastPassedExamination = lastPassedExamination;
        this.streamName = streamName;
        this.courseMedium = courseMedium;
        this.courseType = courseType;
        this.passingYear = passingYear;
        this.overallPercentage = overallPercentage;
        this.nameofUniversityBoard = nameofUniversityBoard;
        this.schoolCollegeName = schoolCollegeName;
        this.subjectList = subjectList;
    }

    public String getLastPassedExamination() {
        return lastPassedExamination;
    }

    public void setLastPassedExamination(String lastPassedExamination) {
        this.lastPassedExamination = lastPassedExamination;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public String getCourseMedium() {
        return courseMedium;
    }

    public void setCourseMedium(String courseMedium) {
        this.courseMedium = courseMedium;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(String passingYear) {
        this.passingYear = passingYear;
    }

    public String getOverallPercentage() {
        return overallPercentage;
    }

    public void setOverallPercentage(String overallPercentage) {
        this.overallPercentage = overallPercentage;
    }

    public String getNameofUniversityBoard() {
        return nameofUniversityBoard;
    }

    public void setNameofUniversityBoard(String nameofUniversityBoard) {
        this.nameofUniversityBoard = nameofUniversityBoard;
    }

    public String getSchoolCollegeName() {
        return schoolCollegeName;
    }

    public void setSchoolCollegeName(String schoolCollegeName) {
        this.schoolCollegeName = schoolCollegeName;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
    
    
}
