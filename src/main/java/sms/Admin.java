package sms;

import java.util.Date;

public class Admin extends Users{

    public Admin(int id,String name,  long number, Date DOB) {
        super(id,name,number, DOB, "ADMIN");
    }
}
