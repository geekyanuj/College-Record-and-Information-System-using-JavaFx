
package Model_Beans;


public class StudentAddressDetails {
    private String presentAddressLine1;
    private String presentCityName;
    private String presentStateName;
    private String presentDistrictName;
    private String presentPinCode;
    
    private String permanentAddressLine1;
    private String permanentCityName;
    private String permanentStateName;
    private String permanentDistrictName;
    private String permanentPinCode;

    public StudentAddressDetails() {
    }
    
    

    public StudentAddressDetails(String presentAddressLine1, String presentCityName, String presentStateName, String presentDistrictName, String presentPinCode, String permanentAddressLine1, String permanentCityName, String permanentStateName, String permanentDistrictName, String permanentPinCode) {
        this.presentAddressLine1 = presentAddressLine1;
        this.presentCityName = presentCityName;
        this.presentStateName = presentStateName;
        this.presentDistrictName = presentDistrictName;
        this.presentPinCode = presentPinCode;
        this.permanentAddressLine1 = permanentAddressLine1;
        this.permanentCityName = permanentCityName;
        this.permanentStateName = permanentStateName;
        this.permanentDistrictName = permanentDistrictName;
        this.permanentPinCode = permanentPinCode;
    }

    public String getPresentAddressLine1() {
        return presentAddressLine1;
    }

    public void setPresentAddressLine1(String presentAddressLine1) {
        this.presentAddressLine1 = presentAddressLine1;
    }

    public String getPresentCityName() {
        return presentCityName;
    }

    public void setPresentCityName(String presentCityName) {
        this.presentCityName = presentCityName;
    }

    public String getPresentStateName() {
        return presentStateName;
    }

    public void setPresentStateName(String presentStateName) {
        this.presentStateName = presentStateName;
    }

    public String getPresentDistrictName() {
        return presentDistrictName;
    }

    public void setPresentDistrictName(String presentDistrictName) {
        this.presentDistrictName = presentDistrictName;
    }

    public String getPresentPinCode() {
        return presentPinCode;
    }

    public void setPresentPinCode(String presentPinCode) {
        this.presentPinCode = presentPinCode;
    }

    public String getPermanentAddressLine1() {
        return permanentAddressLine1;
    }

    public void setPermanentAddressLine1(String permanentAddressLine1) {
        this.permanentAddressLine1 = permanentAddressLine1;
    }

    public String getPermanentCityName() {
        return permanentCityName;
    }

    public void setPermanentCityName(String permanentCityName) {
        this.permanentCityName = permanentCityName;
    }

    public String getPermanentStateName() {
        return permanentStateName;
    }

    public void setPermanentStateName(String permanentStateName) {
        this.permanentStateName = permanentStateName;
    }

    public String getPermanentDistrictName() {
        return permanentDistrictName;
    }

    public void setPermanentDistrictName(String permanentDistrictName) {
        this.permanentDistrictName = permanentDistrictName;
    }

    public String getPermanentPinCode() {
        return permanentPinCode;
    }

    public void setPermanentPinCode(String permanentPinCode) {
        this.permanentPinCode = permanentPinCode;
    }
    
    
    
}
