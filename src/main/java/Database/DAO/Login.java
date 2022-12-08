package Database.DAO;

import Database.DB;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public static boolean credentials(int id, String password) throws SQLException, ClassNotFoundException {
        String q = "SELECT * from users where id="+id+" AND password='"+password+"';";
        ResultSet data = DB.dbExecuteQuery(q);
        return DB.size(data) == 1;
    }
}
