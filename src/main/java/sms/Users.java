package sms;

import Database.DAO.Login;
import Database.DB;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.sql.SQLException;

public class Users {
    protected String name;
    protected long staff_id;
    protected long contact;
    protected int DOB;
    private String department;
    protected String password;

    public Users(String name,int id,long number,int DOB,String department){
        this.name=name;
        this.staff_id=id;
        contact=number;
        this.DOB=DOB;
        this.department=department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public static boolean login(int id, String password) throws SQLException, ClassNotFoundException {
        return Login.credentials(id,password);
    }

    public static boolean createNewUser(int id, String name, String role, String password) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO `byte_me`.`users`\n" +
                "(`id`,\n" +
                "`name`,\n" +
                "`department`,\n" +
                "`password`)\n" +
                "VALUES\n" +
                "("+id+",\n" +
                "\""+name+"\",\n" +
                "\""+role+"\",\n" +
                "\""+password+"\");";
        return DB.dbExecuteUpdate(query);
    }
}
