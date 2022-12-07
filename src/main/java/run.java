import sms.Users;

import java.sql.SQLException;

public class run {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        boolean b = Users.createNewUser(40,"het","ADMIN","lul1");
        System.out.println(b);
    }
}
