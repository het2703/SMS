package Database.DAO;

import Database.DB;
import sms.Products;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {
    public static Products[] searchProducts (int pId) throws SQLException, ClassNotFoundException {
        String id = String.valueOf(pId);
        String query = "select * from products where PRODUCT_ID Regexp '^"+id+"'";
        ResultSet data = DB.dbExecuteQuery(query);
        assert data != null;
        int size = data.getRow();
        Products[] pro = new Products[size];
        dataToArray(data,pro);
        return pro;
    }

    public static Products[] searchProducts (String p_name) throws SQLException, ClassNotFoundException {
        String query = "select * from products where name Regexp '^"+p_name+"'";
        ResultSet data = DB.dbExecuteQuery(query);
        assert data != null;
        int size = data.getRow();
        Products[] pro = new Products[size];
        dataToArray(data,pro);
        return pro;
    }

    private static void dataToArray(ResultSet data, Products[] pro) throws SQLException {
        int counter = 0;
        while (data.next()){
            int p_id = data.getInt("PRODUCT_ID");
            String p_name = data.getString("P_NAME");
            int price = data.getInt("PRICE");
            int stock = data.getInt("STOCK");
            pro[counter] = new Products(p_id,p_name,price,stock);
            counter++;
        }
    }
}
