package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static final String dirver="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/good";
    private static final String username="root";
    private static final String password="";
    private static Connection conn=null;
    static
    {
        try {
            Class.forName(dirver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        if(conn == null){
            conn= DriverManager.getConnection(url,username,password);
            return conn;
        }
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection conn=DBHelper.getConnection();
            if(conn != null){
                System.out.println("数据库连接成功");
            }
            else {
                System.out.println("数据库连接失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
