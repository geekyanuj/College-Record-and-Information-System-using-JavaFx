
package Model_Beans;


public class Student {
    byte []profilePic;
    byte []sign;
    int studentId;
    String studentName;
    String fatherName;
    String motherName;
    String dob;
    String gender;
    String mobileNo;
    String email;
    String admission_on;
    String course_enrolled;
    String department;
    String session;
    int current_semester;
         
    
    

    public Student() {
    }

    public Student(byte[] profilePic, byte[] sign, int studentId, String studentName, String fatherName, String motherName, String dob, String gender, String mobileNo, String email, String admission_on, String course_enrolled, String session, int current_semester) {
        this.profilePic = profilePic;
        this.sign = sign;
        this.studentId = studentId;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.dob = dob;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.email = email;
        this.admission_on = admission_on;
        this.course_enrolled = course_enrolled;
        this.session = session;
        this.current_semester = current_semester;
    }

    //constructor for display student
    public Student(byte[] profilePic, int studentId, String studentName, String fatherName, String dob, String gender, String mobileNo, String email,String admission_on, String department, String session, int current_semester) {
        this.profilePic = profilePic;
        this.studentId = studentId;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.dob = dob;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.email = email;
        this.admission_on = admission_on;
        this.department = department;
        this.session = session;
        this.current_semester = current_semester;
    }

    
    public Student(int studentId, String studentName, String fatherName, String motherName, String dob, String gender, String mobileNo, String email, String admission_on) {
        this.studentId=studentId;
        this.studentName=studentName;
        this.fatherName=fatherName;
        this.motherName=motherName;
        this.dob=dob;
        this.gender=gender;
        this.mobileNo=mobileNo;
        this.email=email;
        this.admission_on=admission_on;
    }

    
    //constructor for attendances

    public Student(int studentId, String studentName, String course_enrolled, int current_semester) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course_enrolled = course_enrolled;
        this.current_semester = current_semester;
    }
    
    
   

    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    public byte[] getSign() {
        return sign;
    }

    public void setSign(byte[] sign) {
        this.sign = sign;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdmission_on() {
        return admission_on;
    }

    public void setAdmission_on(String admission_on) {
        this.admission_on = admission_on;
    }

    public String getCourse_enrolled() {
        return course_enrolled;
    }

    public void setCourse_enrolled(String course_enrolled) {
        this.course_enrolled = course_enrolled;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getCurrent_semester() {
        return current_semester;
    }

    public void setCurrent_semester(int current_semester) {
        this.current_semester = current_semester;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

   

    
    
    
    
    
}
