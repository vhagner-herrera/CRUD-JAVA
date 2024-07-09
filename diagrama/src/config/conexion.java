package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    private static  String url="jdbc:mysql://localhost:3306/persona";
    private static  String user="root";
    private static  String pas="admin";

    private static  Connection con;

    public static Connection getConnection () throws SQLException{
        return DriverManager.getConnection(url,user,pas);

    }


}
