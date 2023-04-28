
package Model_Services;

import Model_Beans.LoginUser;
import Model_DAO.StudentPageDAOImpl;

/**
 *
 * @author anujv
 */
public class StudentPageServicesImpl implements StudentPageServices{
    StudentPageDAOImpl studentPageDAOImpl;
    public StudentPageServicesImpl() {
        studentPageDAOImpl=new StudentPageDAOImpl();
    }

    
    @Override
    public int updateStudentProfile(LoginUser loginUser) {
        return studentPageDAOImpl.updateStudentProfile(loginUser);
    }
    
}
