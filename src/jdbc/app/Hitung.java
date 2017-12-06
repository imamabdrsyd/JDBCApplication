
package jdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *sdfssaas
 * @author imam
 */
public class Hitung {

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
            String sqlquery = "select po.quantity, p.purchase_cost, p.DESCRIPTION\n" +
                                "from purchase_order po\n" +
                                "join product p \n" +
                                "on p.PRODUCT_ID = po.PRODUCT_ID";
            ResultSet result;
            result = stmt.executeQuery(sqlquery);
            
            double totalOrder = 0.0;
            while(result.next()){
                String namaProduk = result.getString("description");
                int quantity = result.getInt("quantity");
                double cost = result.getDouble("purchase_cost");
                double lineCost = quantity * cost;
                        
                System.out.println(namaProduk + quantity + lineCost);
                System.out.println("");
                totalOrder += lineCost;
            } 
            System.out.println("TOTAL ORDER COST = $" + totalOrder);
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
