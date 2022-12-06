package Database;

import java.sql.*;

public class DB {
    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connString = "jdbc:mysql://127.0.0.1:3306/byte_me";
            conn = DriverManager.getConnection(connString,"root","1234");
            System.out.println("Select statement: " + queryStmt + "\n");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet data = stmt.executeQuery(queryStmt);
            return data;
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
        }
        return null;
    }
    public static boolean dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connString = "jdbc:mysql://127.0.0.1:3306/byte_me";
            conn = DriverManager.getConnection(connString,"root","1234");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.execute(sqlStmt);
            return true;
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
        }
        return false;
    }

    public static int size(ResultSet data) throws SQLException{
        int size = 0;
        if (data !=null){
            data.last();
            size = data.getRow();
        }
        data.absolute(0);
        return size;
    }
}