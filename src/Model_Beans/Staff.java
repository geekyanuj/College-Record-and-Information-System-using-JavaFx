
package Model_Beans;

/**
 *
 * @author anujv
 */
public class Staff {
    private int staffId;
    private String staffName;
    private String staffGender;
    private String state;
    private String city;
    private String email;
    private String mobileNo;
    private String qualification;
    private String designation;
    private String experience;
    private byte[] pic;

    public Staff() {
    }

    public Staff(int staffId, String staffName, String staffGender, String email, String mobileNo, String qualification, String designation, String experience) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffGender = staffGender;
        this.email = email;
        this.mobileNo = mobileNo;
        this.qualification = qualification;
        this.designation = designation;
        this.experience = experience;
    }
    
    

    public Staff(int staffId, String staffName, String staffGender, String state, String city, String email, String mobileNo, String qualification, String designation,String experience, byte[] pic) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffGender = staffGender;
        this.state = state;
        this.city = city;
        this.email = email;
        this.mobileNo = mobileNo;
        this.designation = designation;
        this.qualification = qualification;
        this.experience = experience;
        this.pic = pic;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
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
    
    
}
