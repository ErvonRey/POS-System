package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Coded By: Zumi BSIT 1-A student at DSSC

public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "zumi";
    private static final String PASSWORD = "mellisaAdmin1023!";
    
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed Connecting to Database!");
        }
        return conn;
    }

    public static void main(String[] args) {

        //INSERT YOUR CODE HERE
        Connection conn = getConnection();

    }
}