
package Model_Beans;


public class StudentPersonalInformation {
        String id;
        private byte[] profilePic;
        private byte[] signature;
        private String fullName;
        private String fatherName;
        private String motherName;
        private String email;
        private String dob;
        private String idCardType;
        private String casteCategory;
        private String religion;
        private String nationality;
        private String bloodGroup;
        private String gender;
        private String maritalStatus;
        private String mobileNo;
        private String pwd;
        private String idCardNo;
        private String haveStateDomecile;
        private String course_enrolled;
        private String department;
        private String session;
        private int current_semester;
        
        //for parent and guardian details 
        private String guardianName;
        private String relationshipWithGuardian;

    public StudentPersonalInformation() {
    }
    //constructor for Parent and Guardian details
    public StudentPersonalInformation(String id,String fatherName,String motherName,String guardianName, String relationshipWithGuardian) {
        this.id = id;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.guardianName = guardianName;
        this.relationshipWithGuardian = relationshipWithGuardian;
    }
    
    

    public StudentPersonalInformation(byte[] profilePic, byte[] signature, String fullName, String fatherName, String motherName, String email, String dob, String idCardType, String casteCategory, String religion, String nationality, String bloodGroup, String gender, String maritalStatus, String mobileNo, String pwd, String idCardNo, String haveStateDomecile, String course_enrolled, String department, String session, int current_semester) {
        this.profilePic = profilePic;
        this.signature = signature;
        this.fullName = fullName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.email = email;
        this.dob = dob;
        this.idCardType = idCardType;
        this.casteCategory = casteCategory;
        this.religion = religion;
        this.nationality = nationality;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.mobileNo = mobileNo;
        this.pwd = pwd;
        this.idCardNo = idCardNo;
        this.haveStateDomecile = haveStateDomecile;
        this.course_enrolled = course_enrolled;
        this.department = department;
        this.session = session;
        this.current_semester = current_semester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    public String getCasteCategory() {
        return casteCategory;
    }

    public void setCasteCategory(String casteCategory) {
        this.casteCategory = casteCategory;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    
    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getHaveStateDomecile() {
        return haveStateDomecile;
    }

    public void setHaveStateDomecile(String haveStateDomecile) {
        this.haveStateDomecile = haveStateDomecile;
    }

    public String getCourse_enrolled() {
        return course_enrolled;
    }

    public void setCourse_enrolled(String course_enrolled) {
        this.course_enrolled = course_enrolled;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

   

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getRelationshipWithGuardian() {
        return relationshipWithGuardian;
    }

    public void setRelationshipWithGuardian(String relationshipWithGuardian) {
        this.relationshipWithGuardian = relationshipWithGuardian;
    }

    
}
