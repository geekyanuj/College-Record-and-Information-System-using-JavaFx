
package Model_Beans;

import java.sql.Date;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;


public class StudentAttendance {
    int studentId;
    String name;
    String department;
    int semester;
    Date date;
    Pane pane;
    RadioButton presentRadio;
    RadioButton absentRadio;
    ToggleGroup toggleGroup;
    char status;

    //constructor for setting data to table
    public StudentAttendance(int studentId, String name, String department, int semester,Pane pane) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.semester = semester;
        toggleGroup=new ToggleGroup();
        presentRadio=new RadioButton("Present");
        presentRadio.setToggleGroup(toggleGroup);
        absentRadio=new RadioButton("Absent");
        absentRadio.setTranslateX(100);
        absentRadio.setToggleGroup(toggleGroup);
        pane.getChildren().addAll(presentRadio,absentRadio);
        this.pane = pane;
    }
    
    //constructor for sending data to DB

    public StudentAttendance(int studentId, String name, String department, int semester, Date date, char status) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.semester = semester;
        this.date = date;
        this.status = status;
    }
    //constructor for receiving data from DB
    public StudentAttendance(Date date, int studentId, String name, String department, int semester, char status) {
        this.date = date;
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.semester = semester;
        this.status = status;
    }
    
    

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Pane getPane() {
        
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public char getStatus() {
        return status;
    }
    
    

 
    
}


