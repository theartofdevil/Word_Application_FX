package db_connectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionClass {
    public static Connection myConn = null;
    public static String JDBC_DRIVER;
    public static String DATABASE_URL;
    public static String USERNAME ;
    public static String PASSWORD ;
    public static Statement myStat=null;
    public static ResultSet myRs=null;
    public ConnectionClass() {
        JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        DATABASE_URL = "jdbc:mysql://localhost:3306/wordApp";
        USERNAME = "root";
        PASSWORD = "trade2245466";
    }
    public static boolean makeConnection(){

        try {
            Class.forName(JDBC_DRIVER);
            myConn = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
            if(myConn != null){
                return true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
