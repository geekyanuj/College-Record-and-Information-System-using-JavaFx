
package Model_Beans;

import java.io.Serializable;

public class LoginUser implements Serializable {


    private Integer userid;

    private String usertype;

    private String email;

    private String password;
    
    private byte[] userPic;
    
    private String phone;
    
    private String name;

    public LoginUser() {
    }

    public LoginUser(Integer userid) {
        this.userid = userid;
    }

    public LoginUser(Integer userid, String usertype, String email, String password) {
        this.userid = userid;
        this.usertype = usertype;
        this.email  = email;
        this.password = password;
    }
    
        public LoginUser(Integer userid, String usertype, String email, String password,byte[] userPic,String phone,String name ) {
        this.userid = userid;
        this.usertype = usertype;
        this.email = email;
        this.password = password;
        this.userPic = userPic;
        this.phone = phone;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        
        
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
        
    public byte[] getUserPic() {
        return userPic;
    }

    public void setUserPic(byte[] userPic) {
        this.userPic = userPic;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginUser))
        {
            return false;
        }
        LoginUser other = (LoginUser) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model_Beans.LoginUser[ userid=" + userid + " ]";
    }
    
}
