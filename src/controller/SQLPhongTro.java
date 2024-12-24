package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLPhongTro {
    // Hãy đảm bảo rằng bạn cung cấp đúng thông tin kết nối tới cơ sở dữ liệu
    private static final String jdbcUrl = "jdbc:sqlserver://ADMIN-PC\\SQLEXPRESS:1433;databaseName=QLPhongTro_Java;encrypt=false;trustServerCertificate=true";
    private static final String username = "sa";
    private static final String password = "123456@Ab";

    public static Connection getSQLPhongTro() {
        Connection conn = null;
        try {
            // Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Kết nối SQL thành công!");
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối SQL Server: " + e.getMessage());
        }
        return conn;
    }
}
