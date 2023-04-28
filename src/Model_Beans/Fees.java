
package Model_Beans;

/**
 *
 * @author anujv
 */
public class Fees {
    private int id;
    private String name;
    private int semester;
    private String department;
    private int courseFee;
    private int paidTillSem;
    private int totalPaidAmt;
    private int dueAmt;
    private int receiptNo;

    public Fees() {
    }

    public Fees(int id, String name, int semester, String department, int courseFee, int paidTillSem, int totalPaidAmt, int dueAmt, int receiptNo) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.department = department;
        this.courseFee = courseFee;
        this.paidTillSem = paidTillSem;
        this.totalPaidAmt = totalPaidAmt;
        this.dueAmt = dueAmt;
        this.receiptNo = receiptNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(int courseFee) {
        this.courseFee = courseFee;
    }

    public int getPaidTillSem() {
        return paidTillSem;
    }

    public void setPaidTillSem(int paidTillSem) {
        this.paidTillSem = paidTillSem;
    }

    public int getTotalPaidAmt() {
        return totalPaidAmt;
    }

    public void setTotalPaidAmt(int totalPaidAmt) {
        this.totalPaidAmt = totalPaidAmt;
    }

    public int getDueAmt() {
        return dueAmt;
    }

    public void setDueAmt(int dueAmt) {
        this.dueAmt = dueAmt;
    }

    public int getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }
    
    
}
