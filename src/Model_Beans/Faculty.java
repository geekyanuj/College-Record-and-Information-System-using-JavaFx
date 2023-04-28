
package Model_Beans;

public class Faculty {
    private int facultyId;
    private String facultyName;
    private String facultyGender;
    private String state;
    private String city;
    private String email;
    private String mobileNo;
    private String designation;
    private String qualification;
    private String experience;
    private byte[] pic;
    

    public Faculty() {
    }

    public Faculty(int facultyId, String facultyName, String facultyGender, String state, String city, String email, String mobileNo, String designation, String qualification, String experience, byte[] pic) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyGender=facultyGender;
        this.state = state;
        this.city = city;
        this.email = email;
        this.mobileNo = mobileNo;
        this.designation = designation;
        this.qualification = qualification;
        this.experience = experience;
        this.pic = pic;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }


    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public String getFacultyGender() {
        return facultyGender;
    }

    public void setFacultyGender(String facultyGender) {
        this.facultyGender = facultyGender;
    }
    
}
