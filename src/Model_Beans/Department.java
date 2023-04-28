
package Model_Beans;

/**
 *
 * @author anujv
 */
public class Department {
    private int departmentId;
    private String departmentName;
    private String departmentHod;
    private int departmentCapacity;

    public Department() {
    }

    public Department(int departmentId, String departmentName, String departmentHod, int departmentCapacity) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentHod = departmentHod;
        this.departmentCapacity = departmentCapacity;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentHod() {
        return departmentHod;
    }

    public void setDepartmentHod(String departmentHod) {
        this.departmentHod = departmentHod;
    }

    public int getDepartmentCapacity() {
        return departmentCapacity;
    }

    public void setDepartmentCapacity(int departmentCapacity) {
        this.departmentCapacity = departmentCapacity;
    }
    
    
}
