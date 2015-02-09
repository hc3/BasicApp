/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.basicApp.dao;

import br.com.basicApp.model.Product;
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

public class ProductDAO  extends GenericDAO {
    private static final long serialVersionUID = 1L;

    public ProductDAO(){

    }
    
    public int addProduct(Product prod) throws SQLException {
        prod.setId(getNextId("PRODUCT"));
        String query = "INSERT INTO APP.PRODUCT (ID,NAME_PRD,PRICE_PRD,STOCK) VALUES (?,?,?,?)";
        executeCommand(query, prod.getId(),prod.getName(),prod.getPrice(),prod.getStock());
        return prod.getId();
    }
    
    public void removeProduct(int idProduct) throws SQLException {
        String query = "DELETE FROM APP.PRODUCT WHERE ID = ?";
        executeCommand(query, idProduct);
    }
    
    public void updateProduct(Product prod) throws SQLException {
        String query = "UPDATE APP.PRODUCT SET NAME_PRD = ?, PRICE_PRD = ?, STOCK = ? WHERE ID = ?";
        executeCommand(query, prod.getName(),prod.getPrice(),prod.getStock(),prod.getId());
    }
    
    public Product getProduct(int idProduct) throws SQLException {
        String query = "SELECT * FROM APP.PRODUCT WHERE ID = ?";
        ResultSet rs = executeQuery(query,idProduct);
        Product prod = null;
        if(rs.next()){
            prod = populateProduct(rs);
        }
        rs.close();
        return prod;
    }
    
    public static Product populateProduct(ResultSet rs) throws SQLException {
        Product toReturn = new Product();
        toReturn.setId(rs.getInt("ID"));
        toReturn.setName(rs.getString("NAME_PRD"));
        toReturn.setPrice(rs.getFloat("PRICE_PRD"));
        toReturn.setStock(rs.getInt("STOCK"));
        return toReturn;
    }
    
    public List<Product> getAllProducts() throws SQLException {
        List<Product> toReturn = new LinkedList<Product>();
        String query = "SELECT * FROM APP.PRODUCT";
        ResultSet rs = executeQuery(query);
        while(rs.next()){
            toReturn.add(populateProduct(rs));
        }
        return toReturn;
    }
}
