
package Model_DAO;

import Model_Beans.LoginUser;


public interface LoginPageDAO {
    public LoginUser doLoginAsAdmin(String email);
    public LoginUser doLoginAsStaff(String email);
    public LoginUser doLoginAsStudent(String email);
    public String getPassword(String username);
}
