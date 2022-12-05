package Database.DAO;
import Database.DB;
import sms.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
    public static Customer[] searchCustomers (int custId) throws SQLException, ClassNotFoundException {
        String id = String.valueOf(custId);
        String query = "select * from customer where CUSTOMER_ID Regexp '^"+id+"'";
        ResultSet data = DB.dbExecuteQuery(query);
        assert data != null;
        int size = data.getRow();
        Customer[] cust = new Customer[size];
        dataToArray(data,cust);
        return cust;
    }

    public static Customer[] searchCustomers (String cust_name) throws SQLException, ClassNotFoundException {
        String query = "select * from customer where FIRST_NAME Regexp '^"+cust_name+"'";
        ResultSet data = DB.dbExecuteQuery(query);
        assert data != null;
        int size = data.getRow();
        Customer[] cust = new Customer[size];
        dataToArray(data,cust);
        return cust;
    }

    public static void dataToArray(ResultSet data, Customer[] cust) throws SQLException {
        int counter = 0;
        while (data.next()){
            long c_id = data.getLong("CUSTOMER_ID");
            String c_fname = data.getString("FIRST_NAME");
            String c_lname = data.getString("LAST_NAME");
            long contact = data.getLong("PHONE_NUMBER");
            int exp = data.getInt("EXPENDITURE");
            cust[counter] = new Customer(c_id,c_fname,c_lname,contact,exp);
            counter++;
        }
    }
}
