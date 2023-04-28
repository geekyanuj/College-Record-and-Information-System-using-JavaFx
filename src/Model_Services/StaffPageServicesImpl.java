
package Model_Services;


import Model_Beans.LoginUser;
import Model_DAO.StaffPageDAOImpl;


public class StaffPageServicesImpl implements StaffPageServices{
    
    StaffPageDAOImpl staffPageDAOImpl;

    public StaffPageServicesImpl() {
        staffPageDAOImpl=new StaffPageDAOImpl();
    }

    @Override
    public int updateStaffProfile(LoginUser loginUser) {
        return staffPageDAOImpl.updateStaffProfile(loginUser);
    }

}



    

