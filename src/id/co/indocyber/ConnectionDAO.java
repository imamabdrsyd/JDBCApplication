/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.indocyber;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ConnectionDAO {
    private List<Customer> getCustomers() throws SQLException {
        Statement st = connection.createStatement();
        ResultSet results = st.executeQuery("SELECT * FROM CUSTOMER");
        List<Customer> customers = new ArrayList<>();
        while (results.next()) {
            Customer c = new Customer();
            c.setName(results.getString("name"));
            c.setAddressline1(results.getString("addressline1"));
            c.setAddressline2(results.getString("addressline2"));
            c.setCity(results.getString("city"));
            c.setCustomerId(results.getInt("customer_id"));
            c.setDiscountCode(results.getString("discount_code"));
            c.setCreditLimit(results.getDouble("credit_limit"));
            c.setEmail(results.getString("email"));
            c.setFax(results.getString("fax"));
            c.setPhone(results.getString("phone"));
            c.setState(results.getString("state"));
            c.setZip(results.getString("zip"));
            customers.add(c);
        }
        return customers;
    }
}
