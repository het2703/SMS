package Database.DAO;

import Database.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

import static Database.DB.size;

public class Login {
    public static boolean credentials(long id, String password) throws SQLException, ClassNotFoundException {
        String q = "SELECT * from users_credentials where user_id="+id+" AND password = "+password;
        ResultSet data = DB.dbExecuteQuery(q);
        if (size(data)==1) return true;
        return false;
    }
}