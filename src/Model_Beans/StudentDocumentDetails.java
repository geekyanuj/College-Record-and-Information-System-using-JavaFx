
package Model_Beans;


public class StudentDocumentDetails {
    private byte[] idProof;
    private byte[] tenthMarksheet;
    private byte[] twelfthMarksheet;
    private byte[] twelfthMigration;
    private byte[] twelfthTC;
    private String pathIdProof;
    private String pathTenthMarksheet;
    private String pathTwelfthMarksheet;
    private String pathTwelfthMigration;
    private String pathTwelfthTC;
   

    public StudentDocumentDetails() {
    }

    public StudentDocumentDetails(byte[] idProof, byte[] tenthMarksheet, byte[] twelfthMarksheet, byte[] twelfthMigration, byte[] twelfthTC, String pathIdProof, String pathTenthMarksheet, String pathTwelfthMarksheet, String pathTwelfthMigration, String pathTwelfthTC) {
        this.idProof = idProof;
        this.tenthMarksheet = tenthMarksheet;
        this.twelfthMarksheet = twelfthMarksheet;
        this.twelfthMigration = twelfthMigration;
        this.twelfthTC = twelfthTC;
        this.pathIdProof = pathIdProof;
        this.pathTenthMarksheet = pathTenthMarksheet;
        this.pathTwelfthMarksheet = pathTwelfthMarksheet;
        this.pathTwelfthMigration = pathTwelfthMigration;
        this.pathTwelfthTC = pathTwelfthTC;
    }

    public byte[] getIdProof() {
        return idProof;
    }

    public void setIdProof(byte[] idProof) {
        this.idProof = idProof;
    }

    public byte[] getTenthMarksheet() {
        return tenthMarksheet;
    }

    public void setTenthMarksheet(byte[] tenthMarksheet) {
        this.tenthMarksheet = tenthMarksheet;
    }

    public byte[] getTwelfthMarksheet() {
        return twelfthMarksheet;
    }

    public void setTwelfthMarksheet(byte[] twelfthMarksheet) {
        this.twelfthMarksheet = twelfthMarksheet;
    }

    public byte[] getTwelfthMigration() {
        return twelfthMigration;
    }

    public void setTwelfthMigration(byte[] twelfthMigration) {
        this.twelfthMigration = twelfthMigration;
    }

    public byte[] getTwelfthTC() {
        return twelfthTC;
    }

    public void setTwelfthTC(byte[] twelfthTC) {
        this.twelfthTC = twelfthTC;
    }

    public String getPathIdProof() {
        return pathIdProof;
    }

    public void setPathIdProof(String pathIdProof) {
        this.pathIdProof = pathIdProof;
    }

    public String getPathTenthMarksheet() {
        return pathTenthMarksheet;
    }

    public void setPathTenthMarksheet(String pathTenthMarksheet) {
        this.pathTenthMarksheet = pathTenthMarksheet;
    }

    public String getPathTwelfthMarksheet() {
        return pathTwelfthMarksheet;
    }

    public void setPathTwelfthMarksheet(String pathTwelfthMarksheet) {
        this.pathTwelfthMarksheet = pathTwelfthMarksheet;
    }

    public String getPathTwelfthMigration() {
        return pathTwelfthMigration;
    }

    public void setPathTwelfthMigration(String pathTwelfthMigration) {
        this.pathTwelfthMigration = pathTwelfthMigration;
    }

    public String getPathTwelfthTC() {
        return pathTwelfthTC;
    }

    public void setPathTwelfthTC(String pathTwelfthTC) {
        this.pathTwelfthTC = pathTwelfthTC;
    }

    
    
    
    
}
