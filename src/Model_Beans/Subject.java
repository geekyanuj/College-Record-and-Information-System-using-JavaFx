
package Model_Beans;


public class Subject {

    private int slNo=0;
    private String subjectCode=null;
    private String subjectName = null;
    private String subjectType=null;  //for Core and other
    private int subjectTheoryMarks=0;
    private int subjectPracticalMarks=0;
    private int subjectTotalMarks=0;
    private String marksSecured = null;
    private int semester;

    public Subject() {
    }

    public Subject(String subjectCode,String subjectName,String subjectType,int subjectTheoryMarks,int subjectPracticalMarks,int subjectTotalMarks,int semester){
        this.subjectCode=subjectCode;
        this.subjectName=subjectName;
        this.subjectType=subjectType;
        this.subjectTheoryMarks=subjectTheoryMarks;
        this.subjectPracticalMarks=subjectPracticalMarks;
        this.subjectTotalMarks=subjectTotalMarks;
        this.semester=semester;
    }
    
    public Subject(int slNo,String subjectName, String marksSecured) {
        this.slNo=slNo;
        this.subjectName = subjectName;
        this.marksSecured = marksSecured;
    }

    public int getSlNo() {
        return slNo;
    }

    public void setSlNo(int slNo) {
        this.slNo = slNo;
    }


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMarksSecured() {
        return marksSecured;
    }

    public void getmarksSecured(String marksSecured) {
        this.marksSecured = marksSecured;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public int getSubjectTheoryMarks() {
        return subjectTheoryMarks;
    }

    public void setSubjectTheoryMarks(int subjectTheoryMarks) {
        this.subjectTheoryMarks = subjectTheoryMarks;
    }

    public int getSubjectPracticalMarks() {
        return subjectPracticalMarks;
    }

    public void setSubjectPracticalMarks(int subjectPracticalMarks) {
        this.subjectPracticalMarks = subjectPracticalMarks;
    }

    public int getSubjectTotalMarks() {
        return subjectTotalMarks;
    }

    public void setSubjectTotalMarks(int subjectTotalMarks) {
        this.subjectTotalMarks = subjectTotalMarks;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    
}
