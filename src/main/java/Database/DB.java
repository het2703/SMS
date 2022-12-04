package Database;

import java.sql.*;

public class DB {
    private static Connection conn = null;
    public static void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/byte_me","root","1234");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
            throw e;
        }
    }
    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        ResultSet data = null;
        Statement stmt = null;
        try {
            connect();
            System.out.println("Select statement: " + queryStmt + "\n");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            data = stmt.executeQuery(queryStmt);
            return data;
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
        } finally {
            if (data != null) {
                data.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            disconnect();
        }
        return null;
    }
    public static boolean dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            connect();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt.executeUpdate(sqlStmt);
            return true;
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            disconnect();
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