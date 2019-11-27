
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mehdi Miri
 */
public class DatabaseConnection {
    
    private static String url="jdbc:oracle:thin:@localhost:1521:xe";
    private static String user="HR";
    private static String pwd="hr";
    
    private static Connection conn;
    
    public static Connection getConnection() {
        if(conn == null){
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(url, user, pwd);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return conn;
    }
    
}
