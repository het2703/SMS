package Database.DAO;

import Database.DB;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import sms.Users;
import Profile.CurrentUserInfo;

public class Login {
    public static boolean credentials(int id, String password) throws SQLException, ClassNotFoundException {
        String q = "SELECT * from users where id="+id+" AND password='"+password+"';";
        ResultSet data = DB.dbExecuteQuery(q);
        if (DB.size(data)==1){
            data.absolute(1);
            String name = data.getString("name");
            int user_id = data.getInt("id");
            Long contact = data.getLong("number");
            Date DOB = (data.getDate("DOB"));
            String department = data.getString("department");
            Users user = new Users(user_id,name,contact,DOB,department);
            CurrentUserInfo.setUser(user);
            data.close();
            return true;
        }
        data.close();
        return false;
    }
}
