package sms;

public class Admin extends Users{

    public Admin(String name, int id, long number, int DOB) {
        super(name, id, number, DOB, "ADMIN");
    }
}
