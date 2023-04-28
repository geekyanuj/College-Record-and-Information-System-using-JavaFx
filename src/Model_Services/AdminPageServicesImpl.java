
package Model_Services;

import Model_DAO.AdminPageDAOImpl;
import Model_Beans.LoginUser;


public class AdminPageServicesImpl implements AdminPageServices{
    
    AdminPageDAOImpl adminPageDAOImpl;

    public AdminPageServicesImpl() {
        adminPageDAOImpl=new AdminPageDAOImpl();
    }
    
    

    @Override
    public int updateUser(LoginUser loginUser) {
        return adminPageDAOImpl.updateUser(loginUser);
        
    }



    
}
