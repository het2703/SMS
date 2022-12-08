package sms;

public class Cashier extends Users{
    public Cashier(String name, int id, long number, int DOB) {
        super(name, id, number, DOB, "CASHIER", pass);
    }
}
