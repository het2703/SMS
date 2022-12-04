package sms;

public class Admin extends Users{

    public Admin(String fname, String lname, int id, long number, int DOB) {
        super(fname, lname, id, number, DOB, "ADMIN");
    }
}
