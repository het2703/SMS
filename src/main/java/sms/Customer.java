package sms;
import Database.DB;
import java.sql.SQLException;

public class Customer {
    private long customer_id;
    private String fname;
    private String lname;
    private long phone_number;
    private int expenditure;

    public Customer(long customer_id, String fname, String lname, long phone_number, int expenditure) {
        this.customer_id = customer_id;
        this.fname = fname;
        this.lname = lname;
        this.phone_number = phone_number;
        this.expenditure = expenditure;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
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

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public int getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(int expenditure) {
        this.expenditure = expenditure;
    }

    public static boolean createNewCustomer(int id, String fname, String lname, long contact, int exp) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO `byte_me`.`customer`\n" +
                "(`customer_id`,\n" +
                "`first_name`,\n" +
                "`last_name`,\n" +
                "`phone_number`,\n" +
                "`expenditure`)\n" +
                "VALUES\n" +
                "("+id+",\n" +
                "\""+fname+"\",\n" +
                "\""+lname+"\",\n" +
                "\""+contact+"\",\n" +
                "\""+exp+"\");";
        return DB.dbExecuteUpdate(query);
    }
}
