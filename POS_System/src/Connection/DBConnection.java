package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Coded By: Ervon Rey Mellisa a BSIT student at DSSC

public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/";   //URL of the Database
    private static final String USER = "zumi";                          //USERNAME of the Database
    private static final String PASSWORD = "mellisaAdmin1023!";         //PASSWORD of the Database
    
    /*
    
    This is just a practice on my local device,
    thus I have ignored the fact that I had put
    Sensitive information in this class.
    
    */
    
    public static void main(String[] args) {
        DBConnection.getConnection();
    }
    
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Connected Successfully");     //debugging
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at connecting to Database");
        }
        return connection;
    }
    
}