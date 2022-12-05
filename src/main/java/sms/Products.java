package sms;
import Database.DB;
import java.sql.SQLException;

public class Products {
    private long product_id;
    private String name;
    private int price;
    private int Stock;

    public Products(long product_id, String name, int price, int stock) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        Stock = stock;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public boolean createNewProduct() throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO products VALUES (";
        return DB.dbExecuteUpdate(query);
    }
}
