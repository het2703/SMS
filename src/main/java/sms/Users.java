package sms;

import Database.DAO.Login;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.sql.SQLException;

public class Users {
    protected String fname;
    protected String lname;
    protected long staff_id;
    protected long contact;
    protected int DOB;
    private String department;
    protected String password;

    public Users(String fname,String lname,int id,long number,int DOB,String department){
        this.fname=fname;
        this.lname=lname;
        this.staff_id=id;
        contact=number;
        this.DOB=DOB;
        this.department=department;
    }
    public Users(){

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(long staff_id) {
        this.staff_id = staff_id;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact_no) {
        this.contact = contact_no;
    }

    public int getDate_of_birth() {
        return DOB;
    }

    public void setDOB(int date_of_birth) {
        this.DOB = date_of_birth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean login(long id, String password) throws SQLException, ClassNotFoundException {
        return Login.credentials(id,password);
    }
}
