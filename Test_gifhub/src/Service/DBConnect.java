/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "Polypro";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "12345678";

    private static Connection conn;
    
    private DBConnect() {
    }
  
    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        }

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String strConn = String.format("jdbc:sqlserver://%s;DatabaseName=%s;TrustServerCertificate=true;",
                    HOSTNAME, DBNAME);
            conn = DriverManager.getConnection(strConn, USERNAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
            conn = null;
        }

        return conn;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
