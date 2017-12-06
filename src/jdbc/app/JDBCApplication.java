//testdsfsdfsasa
package jdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author imam
 */
public class JDBCApplication {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
    
        try {
            // TODO code application logic here
            String dburl = "jdbc:derby://localhost:1527/sample";
            String username = "app";
            String password = "app";
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            conn = DriverManager.getConnection(dburl, username, password);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("Select * from customer");
            while(result.next()){
                String name = result.getString("name");
                String alamat = result.getString("addressLine1")
                        + ", " + result.getString("addressLine2");
                int creditLama = result.getInt("credit_Limit");
                System.out.println(name + ", " + alamat);
                System.out.println(creditLama);
            }   
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException err) {
            Logger.getLogger(JDBCApplication.class.getName()).log(Level.SEVERE, null, err);
        } finally {
           try{
            stmt.close();
            conn.close();
        } catch (SQLException ex){
            Logger.getLogger(JDBCApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    }
}
