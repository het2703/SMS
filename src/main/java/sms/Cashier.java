package sms;

import java.util.Date;

public class Cashier extends Users{
    public Cashier(int id,String name,  long number, Date DOB) {
        super(id, name, number, DOB, "CASHIER");
    }
}
