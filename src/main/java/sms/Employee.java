package sms;
import Database.DB;
import java.sql.Date;
import java.sql.SQLException;
public class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private long phone_number;
    private Date hire_date;
    private Date DOB;
    private String gender;
    private int salary;

    public Employee(int employee_id, String first_name, String last_name, String email, long phone_number, Date hire_date, Date DOB, String gender, int salary) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.DOB = DOB;
        this.gender = gender;
        this.salary = salary;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean createNewEmployee(int id, String fname, String lname, String email, long phone_number, Date hire_date, Date DOB, String gender,int salary) throws SQLException, ClassNotFoundException {
        String query = "\n" +
                "INSERT INTO `byte_me`.`employee`\n" +
                "(`EMPLOYRR_ID`,\n" +
                "`FIRST_NAME`,\n" +
                "`LAST_NAME`,\n" +
                "`EMAIL`,\n" +
                "`PHONE_NUMBER`,\n" +
                "`HIRE_DATE`,\n" +
                "`DOB`,\n" +
                "`GENDER`,\n" +
                "`SALARY`)\n" +
                "VALUES\n" +
                "("+id+",\n" +
                "\""+fname+"\",\n" +
                "\""+lname+"\",\n" +
                "\""+email+"\",\n" +
                "\""+phone_number+"\",\n" +
                "\""+hire_date+"\",\n" +
                "\""+DOB+"\",\n" +
                "\""+gender+"\",\n" +
                "\""+salary+"\");";
        return DB.dbExecuteUpdate(query);
    }
}
