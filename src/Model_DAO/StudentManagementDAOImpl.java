
package Model_DAO;

import Model_DBA.MyConnection;
import Model_Beans.Student;
import Model_Beans.StudentAddressDetails;
import Model_Beans.StudentDocumentDetails;
import Model_Beans.StudentPersonalInformation;
import Model_Beans.StudentPreviousAcademicDetails;
import Model_Beans.Subject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author anujv
 */
public class StudentManagementDAOImpl implements StudentManagementDAO{

    @Override
    public int addStudent(StudentPersonalInformation studentPersonalInformation, StudentAddressDetails studentAddressDetails, StudentPreviousAcademicDetails studentPreviousAcademicDetails, StudentDocumentDetails studentDocumentDetails) {
        Connection connection=null;
        String columnNames[] = new String[] { "id" };
        int generatedStudentId = 0;
//        
        try {
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO student(name,father_name,mother_name,dob,gender,mobile_no,email,admission_on,course_enrolled,session,current_semester,password,profile_pic,signature,department_hail) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",columnNames);
            ps.setString(1, studentPersonalInformation.getFullName());
            ps.setString(2, studentPersonalInformation.getFatherName());
            ps.setString(3, studentPersonalInformation.getMotherName());
            String dob=studentPersonalInformation.getDob();
            String dob2=dob.replace('/', '-'); //converting to date format
            ps.setDate(4, Date.valueOf(dob2));
            ps.setString(5, studentPersonalInformation.getGender());
            ps.setString(6, studentPersonalInformation.getMobileNo());
            ps.setString(7, studentPersonalInformation.getEmail());
            ps.setDate(8, java.sql.Date.valueOf(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE))); //admission on
            ps.setString(9, studentPersonalInformation.getCourse_enrolled());
            ps.setString(10, studentPersonalInformation.getSession());
            ps.setInt(11, studentPersonalInformation.getCurrent_semester());
            ps.setString(12, "PKROY@123"); //default Password, students can change their password in update profile section
            ps.setBytes(13, studentPersonalInformation.getProfilePic());
            ps.setBytes(14, studentPersonalInformation.getSignature());
            ps.setString(15, studentPersonalInformation.getDepartment());

             if(ps.executeUpdate()>0){
                  java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                  if(generatedKeys.next()){
                    generatedStudentId = generatedKeys.getInt(1);
                  }
             }else{
                 System.err.println("Not inserted data");
             }
            
            
            
            PreparedStatement ps0=connection.prepareStatement("INSERT INTO student_personal_information(id,full_name,father_name,mother_name,email,dob,gender,mobile_no,blood_group,religion,idcard_type,idcard_no,marital_status,pwd,caste_category,have_state_domecile,nationality,profile_pic,signature,admission_on) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps0.setInt(1, generatedStudentId);
            ps0.setString(2, studentPersonalInformation.getFullName());
            ps0.setString(3, studentPersonalInformation.getFatherName());
            ps0.setString(4, studentPersonalInformation.getMotherName());
            ps0.setString(5, studentPersonalInformation.getEmail());
//            System.err.println(studentPersonalInformation.getDob());
//            String dobpersonalInfo=studentPersonalInformation.getDob();
//            String dobPersonalInfo2=dob.replace('/', '-'); 
            ps0.setDate(6, Date.valueOf(dob2));
            ps0.setString(7, studentPersonalInformation.getGender());
            ps0.setString(8, studentPersonalInformation.getMobileNo());
            ps0.setString(9, studentPersonalInformation.getBloodGroup());
            ps0.setString(10, studentPersonalInformation.getReligion());
            ps0.setString(11, studentPersonalInformation.getIdCardType());
            ps0.setString(12, studentPersonalInformation.getIdCardNo());
            ps0.setString(13, studentPersonalInformation.getMaritalStatus());
            ps0.setString(14, studentPersonalInformation.getPwd());
            ps0.setString(15, studentPersonalInformation.getCasteCategory());
            ps0.setString(16, studentPersonalInformation.getHaveStateDomecile());
            ps0.setString(17, studentPersonalInformation.getNationality());
            ps0.setBytes(18, studentPersonalInformation.getProfilePic());
            ps0.setBytes(19, studentPersonalInformation.getSignature());
            ps0.setDate(20, java.sql.Date.valueOf(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)));
            
            
             ps0.executeUpdate();
            
             
             PreparedStatement ps1=connection.prepareStatement("INSERT INTO student_address_details(student_id,present_address_line1,present_cityname,present_statename,present_districtname,present_pincode,permanent_address_line1,permanent_cityname,permanent_statename,permanent_districtname,permanent_pincode) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
             ps1.setInt(1, generatedStudentId);
             ps1.setString(2, studentAddressDetails.getPresentAddressLine1());
             ps1.setString(3, studentAddressDetails.getPresentCityName());
             ps1.setString(4, studentAddressDetails.getPresentStateName());
             ps1.setString(5, studentAddressDetails.getPresentDistrictName());
             ps1.setString(6, studentAddressDetails.getPresentPinCode());
             ps1.setString(7, studentAddressDetails.getPermanentAddressLine1());
             ps1.setString(8, studentAddressDetails.getPermanentCityName());
             ps1.setString(9, studentAddressDetails.getPermanentStateName());
             ps1.setString(10, studentAddressDetails.getPermanentDistrictName());
             ps1.setString(11, studentAddressDetails.getPermanentPinCode());
             
             
             ps1.executeUpdate();
             
             
             PreparedStatement ps2=connection.prepareStatement("INSERT INTO student_previous_academic_details(student_id,last_passed_examination,stream_name,course_medium,course_type,passing_year,overall_percentage,name_of_university_board,school_college_name,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps2.setInt(1, generatedStudentId);
             ps2.setString(2, studentPreviousAcademicDetails.getLastPassedExamination());
             ps2.setString(3, studentPreviousAcademicDetails.getStreamName());
             ps2.setString(4, studentPreviousAcademicDetails.getCourseMedium());
             ps2.setString(5, studentPreviousAcademicDetails.getCourseType());
             ps2.setInt(6, Integer.parseInt(studentPreviousAcademicDetails.getPassingYear()));
             ps2.setInt(7, Integer.parseInt(studentPreviousAcademicDetails.getOverallPercentage()));
             ps2.setString(8, studentPreviousAcademicDetails.getNameofUniversityBoard());
             ps2.setString(9, studentPreviousAcademicDetails.getSchoolCollegeName());
             List<Subject> list=studentPreviousAcademicDetails.getSubjectList();
             ps2.setString(10, "Not Filled");
             ps2.setString(11, "Not Filled");
             ps2.setString(12, "Not Filled");
             ps2.setString(13, "Not Filled");
             ps2.setString(14, "Not Filled");
             ps2.setString(15, "Not Filled");
             ps2.setString(16, "Not Filled");
             ps2.setString(17, "Not Filled");
             for(int i=0;i<list.size();i++){
                 ps2.setString(10+i, list.get(i).getSubjectName()+"  -> "+list.get(i).getMarksSecured());
             }
             
             ps2.executeUpdate();
             
            
             PreparedStatement ps3=connection.prepareStatement("INSERT INTO student_documents_details(student_id,id_proof,tenth_marksheet,twelfth_marksheet,twelfth_migration,twelfth_tc) VALUES(?,?,?,?,?,?)");
             ps3.setInt(1, generatedStudentId);
             ps3.setBytes(2,studentDocumentDetails.getIdProof());
             ps3.setBytes(3,studentDocumentDetails.getTenthMarksheet());
             ps3.setBytes(4,studentDocumentDetails.getTwelfthMarksheet());
             ps3.setBytes(5,studentDocumentDetails.getTwelfthMigration());
             ps3.setBytes(6,studentDocumentDetails.getTwelfthTC());
             
             ps3.executeUpdate();
            
           
            
        } catch (Exception e){
            e.printStackTrace();
            System.err.println("Error in inserting ");
        }
       return generatedStudentId;
       
    }

    @Override
    public List<Student> displayAllStudent() {
        List<Student> studentList=new ArrayList<>();
        Connection connection=null;
        try{   
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT profile_pic,id,name,father_name,dob,gender,mobile_no,email,admission_on,department_hail,session,current_semester FROM student");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student.setProfilePic(rs.getBytes(1));
                student.setStudentId(rs.getInt(2));
                student.setStudentName(rs.getString(3));
                student.setFatherName(rs.getString(4));
                student.setDob(rs.getDate(5)+"");
                student.setGender(rs.getString(6));
                student.setMobileNo(rs.getString(7));
                student.setEmail(rs.getString(8));
                student.setAdmission_on(rs.getString(9));
                student.setDepartment(rs.getString(10));
                student.setSession(rs.getString(11));
                student.setCurrent_semester(rs.getInt(12));

               studentList.add(student);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student displayStudentUsingStudentId(int studentId) {
        Connection connection=null;
        Student student=new Student();
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT profile_pic,id,name,father_name,dob,gender,mobile_no,email,admission_on,department_hail,session,current_semester FROM student WHERE id = ?");
            ps.setInt(1, studentId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                student.setProfilePic(rs.getBytes(1));
                student.setStudentId(rs.getInt(2));
                student.setStudentName(rs.getString(3));
                student.setFatherName(rs.getString(4));
                student.setDob(String.valueOf(rs.getDate(5)));
                student.setGender(rs.getString(6));
                student.setMobileNo(rs.getString(7));
                student.setEmail(rs.getString(8));
                student.setAdmission_on(rs.getDate(9)+"");
                student.setDepartment(rs.getString(10));
                student.setSession(rs.getString(11)+"");
                student.setCurrent_semester(rs.getInt(12));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return student;
        
    }

    @Override
    public StudentPersonalInformation findStudentUsingStudentId(String studentId) {
        Connection connection=null;
        StudentPersonalInformation studentPersonalInformation=new StudentPersonalInformation();
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT id,full_name,father_name,mother_name,email,dob,gender,mobile_no,blood_group,religion,idcard_type,idcard_no,marital_status,pwd,caste_category,have_state_domecile,nationality,profile_pic,signature,guardian_name,relationshipwith_guardian FROM student_personal_information WHERE id = ?");
            ps.setInt(1, Integer.parseInt(studentId));
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                studentPersonalInformation.setId(String.valueOf(rs.getInt(1)));
                studentPersonalInformation.setFullName(rs.getString(2));
                studentPersonalInformation.setFatherName(rs.getString(3));
                studentPersonalInformation.setMotherName(rs.getString(4));
                studentPersonalInformation.setEmail(rs.getString(5));
                studentPersonalInformation.setDob(String.valueOf(rs.getDate(6)));
                studentPersonalInformation.setGender(rs.getString(7));
                studentPersonalInformation.setMobileNo(rs.getString(8));
                studentPersonalInformation.setBloodGroup(rs.getString(9));
                studentPersonalInformation.setReligion(rs.getString(10));
                studentPersonalInformation.setIdCardType(rs.getString(11));
                studentPersonalInformation.setIdCardNo(rs.getString(12));
                studentPersonalInformation.setMaritalStatus(rs.getString(13));
                studentPersonalInformation.setPwd(rs.getString(14));
                studentPersonalInformation.setCasteCategory(rs.getString(15));
                studentPersonalInformation.setHaveStateDomecile(rs.getString(16));
//                studentPersonalInformation.set(rs.getString(17));
                
                studentPersonalInformation.setProfilePic(rs.getBytes(18));
                studentPersonalInformation.setSignature(rs.getBytes(19));
                
                studentPersonalInformation.setGuardianName(rs.getString(20));
                studentPersonalInformation.setRelationshipWithGuardian(rs.getString(21));
                
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return studentPersonalInformation;
    }

    @Override
    public int updateStudentPersonalDetails(StudentPersonalInformation studentPersonalInformation) {
        Connection connection=null;
        int row = 0;
        try {
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("UPDATE student SET name=?,father_name=?,mother_name=?,dob=?,gender=?,mobile_no=?,email=?,course_enrolled=?,department_hail=?,session=?,current_semester=?,profile_pic=?,signature=? WHERE id=?");
            ps.setString(1, studentPersonalInformation.getFullName());
            ps.setString(2, studentPersonalInformation.getFatherName());
            ps.setString(3, studentPersonalInformation.getMotherName());
            String dob=studentPersonalInformation.getDob();
            String dob2=dob.replace('/', '-');
            ps.setDate(4, Date.valueOf(dob2));
            ps.setString(5, studentPersonalInformation.getGender());
            ps.setString(6, studentPersonalInformation.getMobileNo());
            ps.setString(7, studentPersonalInformation.getEmail());
            ps.setString(8, studentPersonalInformation.getCourse_enrolled());
            ps.setString(9, studentPersonalInformation.getDepartment());
            ps.setString(10, studentPersonalInformation.getSession());
            ps.setInt(11, studentPersonalInformation.getCurrent_semester());
            ps.setBytes(12, studentPersonalInformation.getProfilePic());
            ps.setBytes(13, studentPersonalInformation.getSignature());
            ps.setInt(14, Integer.parseInt(studentPersonalInformation.getId()));
            
            
            PreparedStatement ps0=connection.prepareStatement("UPDATE student_personal_information SET full_name=?,father_name=?,mother_name=?,email=?,dob=?,gender=?,mobile_no=?,blood_group=?,religion=?,idcard_type=?,idcard_no=?,marital_status=?,pwd=?,caste_category=?,have_state_domecile=?,profile_pic=?,signature=?,nationality=? WHERE id=?");
            ps0.setString(1, studentPersonalInformation.getFullName());
            ps0.setString(2, studentPersonalInformation.getFatherName());
            ps0.setString(3, studentPersonalInformation.getMotherName());
            ps0.setString(4, studentPersonalInformation.getEmail());
//            System.err.println(studentPersonalInformation.getDob());
            

            ps0.setDate(5, Date.valueOf(dob2));
            ps0.setString(6, studentPersonalInformation.getGender());
            ps0.setString(7, studentPersonalInformation.getMobileNo());
            ps0.setString(8, studentPersonalInformation.getBloodGroup());
            ps0.setString(9, studentPersonalInformation.getReligion());
            ps0.setString(10, studentPersonalInformation.getIdCardType());
            ps0.setString(11, studentPersonalInformation.getIdCardNo());
            ps0.setString(12, studentPersonalInformation.getMaritalStatus());
            ps0.setString(13, studentPersonalInformation.getPwd());
            ps0.setString(14, studentPersonalInformation.getCasteCategory());
            ps0.setString(15, studentPersonalInformation.getHaveStateDomecile());
            ps0.setBytes(16, studentPersonalInformation.getProfilePic());
            ps0.setBytes(17, studentPersonalInformation.getSignature());
            ps0.setString(18, studentPersonalInformation.getNationality());
            ps0.setInt(19, Integer.parseInt(studentPersonalInformation.getId()));
            
            if(ps.executeUpdate()>0){
                row=ps0.executeUpdate();
            }else{
                System.err.println("Student table not update somehow");
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    
       return row;
       
    }

    @Override
    public int deleteStudent(String studentId) {
        Connection connection=null;
        int isDeleted=0;
        try{
            connection=MyConnection.getConnection();
            PreparedStatement ps0=connection.prepareStatement("DELETE FROM student_documents_details WHERE student_id =?");
            ps0.setInt(1, Integer.parseInt(studentId));
            
            
            PreparedStatement ps1=connection.prepareStatement("DELETE FROM student_previous_academic_details WHERE student_id =?");
            ps1.setInt(1, Integer.parseInt(studentId));
           
            
            PreparedStatement ps2=connection.prepareStatement("DELETE FROM student_address_details WHERE student_id =?");
            ps2.setInt(1, Integer.parseInt(studentId));
            
            
            PreparedStatement ps3=connection.prepareStatement("DELETE FROM student_personal_information WHERE id =?");
            ps3.setInt(1, Integer.parseInt(studentId));
            
            PreparedStatement ps4=connection.prepareStatement("DELETE FROM student WHERE id =?");
            ps4.setInt(1, Integer.parseInt(studentId));
            
            ps2.executeUpdate();
            ps0.executeUpdate();
            ps1.executeUpdate();
            ps3.executeUpdate();
            isDeleted=ps4.executeUpdate();
            
            
//            if(ps0.executeUpdate()>0){
//                if( ps1.executeUpdate()>0){
//                    if(ps2.executeUpdate()>0){
//                        if(ps3.executeUpdate()>0){
//                            isDeleted=ps4.executeUpdate();
//                        }
//                    }
//                }
//            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public int updateStudentParentDetails(StudentPersonalInformation studentPersonalInformation) {
        Connection connection=null;
        int row=0;
        try
        {
            connection=MyConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("UPDATE student SET father_name=?,mother_name=?,guardian_name=?,relationshipwith_guardian=? WHERE id=?");
            ps.setString(1, studentPersonalInformation.getFatherName());
            ps.setString(2, studentPersonalInformation.getMotherName());
            ps.setString(3, studentPersonalInformation.getGuardianName());
            ps.setString(4, studentPersonalInformation.getRelationshipWithGuardian());
            ps.setInt(5, Integer.parseInt(studentPersonalInformation.getId()));
            row=ps.executeUpdate();
            
        } catch (Exception e){
            System.out.println("Error while updating parent details");
            e.printStackTrace();
        }
        return  row;
    }
        
}
