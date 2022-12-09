package Database.DAO;

import sms.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    public static void dataToArray(ResultSet data,Employee[] emp) throws SQLException
    {
        int counter = 0;
        while(data.next()) {
            int e_id = data.getInt("EMPLOYEE_ID");
            String e_fname = data.getString("FIRST_NAME");
            String e_lname = data.getString("LAST_NAME");
            String email = data.getString("EMAIL");
            long contact = data.getLong("PHONE_NUMBER");
            String hire = data.getString("HIRE_DATE");
            String DOB = data.getString("DOB");
            String gender = data.getString("GENDER");
            int salary = data.getInt("SALARY");
            emp[counter++] = new Employee(e_id,e_fname,e_lname,email,contact,hire,DOB,gender,salary);
        }
    }

}
