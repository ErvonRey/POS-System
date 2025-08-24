package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Coded By: Ervon Rey Mellisa a BSIT student at DSSC

public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "zumi";
    private static final String PASSWORD = "mellisaAdmin1023!";
    
    /*
    This is just a practice on my local device, thus I have ignored the fact that I had put
    Sensitive information in this class file.
    */
    
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Connected Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed Connecting to Database!");
        }
        return conn;
    }

//    public static void main(String[] args) {
//        Connection conn = getConnection();
//    }
    
}