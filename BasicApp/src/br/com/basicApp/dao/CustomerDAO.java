/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.basicApp.dao;

import br.com.basicApp.model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @date 
 * @author Eliel
 * @email eliel.floyd@bol.com.br
 *
 */

public class CustomerDAO extends GenericDAO {
    
    private static final long serialVersionUID = 1L;

    public CustomerDAO(){

    }
    
    public int addCustomer(Customer ctm) throws SQLException {
        ctm.setId(getNextId("CUSTOMER"));
        String query = "INSERT INTO APP.CUSTOMER(ID,NAME_CST,AGE_CST,ADDRESS_CST,TEL_CST)" + "VALUES (?,?,?,?,?)";
        executeCommand(query,ctm.getId(),ctm.getName(),ctm.getAge(),ctm.getAddress(),ctm.getTelephone());
        return ctm.getId();
    }
    
    public void removeCustomer(int idCustomer) throws SQLException {
        String query = "DELETE FROM APP.CUSTOMER WHERE ID = ?";
        executeCommand(query,idCustomer);
    }
    
    public void updateCustomer(Customer ctm) throws SQLException {
        String query = "UPDATE APP.CUSTOMER SET NAME_CST = ?, AGE_CST = ?, ADDRESS_CST = ?, TEL_CST = ? WHERE ID = ?";
        executeCommand(query,ctm.getName(),ctm.getAge(),ctm.getAddress(),ctm.getTelephone(),ctm.getId());
    }
    
    public Customer getCustomer(int idCustomer) throws SQLException {
        String query = "SELECT * FROM APP.CUSTOMER WHERE ID = ?";
        ResultSet rs = executeQuery(query,idCustomer);
        Customer ctm = null;
        if(rs.next()){
            ctm = populateCustomer(rs);
        }
        rs.close();
        return ctm;
    }
    
    public List<Customer> getAllCustomers() throws SQLException {
        String query = "SELECT * FROM APP.CUSTOMER";
        ResultSet rs = executeQuery(query);
        List<Customer> toReturn = new LinkedList<Customer>();
        while(rs.next()){
            toReturn.add(populateCustomer(rs));
        }
        rs.close();
        return toReturn;
    }
    
    public static Customer populateCustomer(ResultSet rs) throws SQLException {
        Customer toReturn = new Customer();
        toReturn.setId(rs.getInt("ID"));
        toReturn.setName(rs.getString("NAME_CST"));
        toReturn.setAge(rs.getInt("AGE_CST"));
        toReturn.setAddress(rs.getString("ADDRESS_CST"));
        toReturn.setTelephone(rs.getString("TEL_CST"));
        return toReturn;
    }
    
    public List<Customer> getCustomersByName(String name) throws SQLException {
        List<Customer> toReturn = new LinkedList<Customer>();
        String query = "SELECT * FROM APP.CUSTOMER WHERE NAME_CST LIKE ? ";
        ResultSet rs = executeQuery(query,"%"+name+"%");
        while(rs.next()){
            toReturn.add(populateCustomer(rs));
        }
        rs.close();
        return toReturn;
    }
}
