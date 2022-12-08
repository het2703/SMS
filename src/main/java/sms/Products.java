package sms;
import Database.DB;
import java.sql.SQLException;

public class Products {
    private int product_id;
    private String name;
    private float price;
    private int Stock;

    public Products(int product_id, String name, float price, int stock) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        Stock = stock;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public static boolean createNewProduct(int id, String pname, float price, int stock) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO `byte_me`.`products`\n" +
                "(`PRODUCT_ID`,\n" +
                "`P_NAME`,\n" +
                "`PRICE`,\n" +
                "`STOCK`)\n" +
                "VALUES\n" +
                "("+id+",\n" +
                "\""+pname+"\",\n" +
                "\""+price+"\",\n" +
                "\""+stock+"\");";
        return DB.dbExecuteUpdate(query);
    }
}
