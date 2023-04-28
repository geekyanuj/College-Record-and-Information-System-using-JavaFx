
package Model_Services;

import Model_DAO.LoginPageDAOImpl;
import Model_Beans.LoginUser;

public class LoginPageServicesImpl implements LoginPageServices{

    LoginPageDAOImpl loginPageDAOImpl;
    
    //constructor
    public LoginPageServicesImpl() {
        loginPageDAOImpl=new LoginPageDAOImpl();
    }

    @Override
    public LoginUser doLoginAsAdmin(String email) {
        return loginPageDAOImpl.doLoginAsAdmin(email);
    }

    @Override
    public String getPassword(String username) {
        return loginPageDAOImpl.getPassword(username);
    }

    @Override
    public LoginUser doLoginAsStaff(String email) {
        return loginPageDAOImpl.doLoginAsStaff(email);
    }

    @Override
    public LoginUser doLoginAsStudent(String email) {
        return loginPageDAOImpl.doLoginAsStudent(email);
    }
        
    
}
