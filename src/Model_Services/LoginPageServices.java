
package Model_Services;

import Model_Beans.LoginUser;

public interface LoginPageServices {
    public LoginUser doLoginAsAdmin(String email);
    public LoginUser doLoginAsStaff(String email);
    public LoginUser doLoginAsStudent(String email);
    public String getPassword(String username);
    
}
