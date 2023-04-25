package Database.DAO;

import Database.DB;
import sms.Users;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileDAO {
    public static Users showProfile (int uid) throws SQLException, ClassNotFoundException {
        String id = String.valueOf(uid);
        String query = "select * from users where id = "+id;
        ResultSet data = DB.dbExecuteQuery(query);
        Users user = new Users();
        assert data != null;
        dataToArray(data,user);
        return user;
    }

    private static void dataToArray(ResultSet data, Users user) throws SQLException {
        while (data.next()){
            int u_id = data.getInt("ID");
            String u_name = data.getString("NAME");
            long contact = data.getInt("NUMBER");
            Date DOB = data.getDate("DOB");
            String department = data.getString("DEPARTMENT");
            user = new Users(u_id, u_name, contact, DOB, department);

        }
    }
}
