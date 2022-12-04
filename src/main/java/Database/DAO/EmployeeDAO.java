package Database.DAO;

import Database.DB;
import sms.Employee;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
    public static Employee[] searchEmployees (int empId) throws SQLException, ClassNotFoundException {
        String id = String.valueOf(empId);
        String query = "select * from employee where EMPLOYEE_ID Regexp '^"+id+"'";
        ResultSet data = DB.dbExecuteQuery(query);
        assert data != null;
        int size = data.getRow();
        Employee[] emp = new Employee[size];
        dataToArray(data,emp);
        return emp;
    }
    public static Employee[] searchEmployees (String emp_name) throws SQLException, ClassNotFoundException {
        String query = "select * from employee where FIRST_NAME Regexp '^"+emp_name+"'";
        ResultSet data = DB.dbExecuteQuery(query);
        assert data != null;
        int size = data.getRow();
        Employee[] emp = new Employee[size];
        dataToArray(data,emp);
        return emp;
    }


    private static void dataToArray(ResultSet data,Employee[] emp) throws SQLException
    {
        int counter = 0;
        while(data.next()) {
            long e_id = data.getLong("EMPLOYEE_ID");
            String e_fname = data.getString("FIRST_NAME");
            String e_lname = data.getString("LAST_NAME");
            String email = data.getString("EMAIL");
            long contact = data.getInt("PHONE_NUMBER");
            Date hire = data.getDate("HIRE_DATE");
            Date DOB = data.getDate("DOB");
            String gender = data.getString("GENDER");
            int salary = data.getInt("SALARY");
            emp[counter] = new Employee(e_id,e_fname,e_lname,email,contact,hire,DOB,gender,salary);
            counter++;
        }
    }
    public static void updateEmpEmail (String empId, String empEmail) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "BEGIN\n" +
                        "   UPDATE employees\n" +
                        "      SET EMAIL = '" + empEmail + "'\n" +
                        "    WHERE EMPLOYEE_ID = " + empId + ";\n" +
                        "   COMMIT;\n" +
                        "END;";
        try {
            DB.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
    public static void deleteEmpWithId (String empId) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM employees\n" +
                        "         WHERE employee_id ="+ empId +";\n" +
                        "   COMMIT;\n" +
                        "END;";
        try {
            DB.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
    public static void insertEmp (String name, String lastname, String email) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO employees\n" +
                        "(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID)\n" +
                        "VALUES\n" +
                        "(sequence_employee.nextval, '"+name+"', '"+lastname+"','"+email+"', SYSDATE, 'IT_PROG');\n" +
                        "END;";
        try {
            DB.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
}
