package sms;

import Database.DAO.Login;
import Database.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class Users {
    protected String name;
    protected int staff_id;
    protected long contact;
    protected Date DOB;
    private String department;
    protected String password;

    public Users(int id, String name, long number, Date DOB, String department){
        this.name=name;
        this.staff_id=id;
        contact=number;
        this.DOB=DOB;
        this.department=department;
    }

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact_no) {
        this.contact = contact_no;
    }

    public Date getDate_of_birth() {
        return DOB;
    }

    public void setDOB(Date date_of_birth) {
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

    public static boolean createNewUser(int id, String name, String role, long number, Date date, String password) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO `byte_me`.`users`\n" +
                "(`id`,\n" +
                "`name`,\n" +
                "`department`,\n" +
                "`number`,\n" +
                "`DOB`,\n" +
                "`password`)\n" +
                "VALUES\n" +
                "("+id+",\n" +
                "\""+name+"\",\n" +
                "\""+role+"\",\n" +
                "\""+number+"\",\n" +
                "\""+date+"\",\n" +
                "\""+password+"\");";
        return DB.dbExecuteUpdate(query);
    }

    public static boolean editAccountDetails(Users user) throws SQLException, ClassNotFoundException {
        String query = "UPDATE `byte_me`.`users` SET `name` = ?, `number` = ?, `DOB` = ?, `department` = ? WHERE (`id` = ?)";
        PreparedStatement ps = DB.getstmt(query);
        assert ps !=null;
        ps.setString(1,user.getName());
        ps.setLong(2,user.getContact());
        ps.setDate(3,user.getDate_of_birth());
        ps.setString(4,user.getDepartment());
        ps.setInt(5,user.getStaff_id());
        return DB.dbExecutePS(ps);
    }

    public static boolean changePassword(int id, String password) throws SQLException {
        String query = "UPDATE `byte_me`.`users` SET `password` = ? WHERE (`id` = ?)";
        PreparedStatement ps = DB.getstmt(query);
        assert ps != null;
        ps.setString(1,password);
        ps.setInt(2,id);
        return DB.dbExecutePS(ps);
    }
}
