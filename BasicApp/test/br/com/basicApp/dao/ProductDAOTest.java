/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.basicApp.dao;

import br.com.basicApp.model.Product;
import java.sql.ResultSet;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eliel
 */
public class ProductDAOTest {
    private static Integer idProduct = 1;
    
    public ProductDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /*
    @Test
    public void testGetProduct() throws Exception {
        System.out.println("getCustomer");
        CustomerDAO instance = new CustomerDAO();
        assertNull(instance.getCustomer(idProduct));
    }
    */
    
    @Test
    public void testAddProduct() throws Exception {
        System.out.println("addCustomer");
        Product prd = new Product();
        prd.setId(idProduct);
        prd.setName("cerpa gold");
        prd.setPrice(10f);
        prd.setStock(15);
        ProductDAO instance = new ProductDAO();
        idProduct = instance.addProduct(prd);
        assertTrue(idProduct > 0);
    }
 /*   
 
    @Test
    public void testUpdateProduct() throws Exception {
        System.out.println("updateCustomer");
        ProductDAO instance = new ProductDAO();
        Product prod = instance.getProduct(idProduct);
        prod.setName("cerpa draft");
        instance.updateProduct(prod);
        prod = instance.getProduct(idProduct);
        assertEquals(prod.getName(),"cerpa draft");
    }
*/
    
    @Test
    public void testeGetAllProducts() throws Exception {
        System.out.println("getAllProducts");
        ProductDAO instance = new ProductDAO();
        List result = instance.getAllProducts();
    
        assertTrue(result.size() > 0);
    }
 /*   
    @Test
    public void testeRemoveProduct() throws Exception {
        System.out.println("removeProduct");
        ProductDAO instance = new ProductDAO();
        instance.removeProduct(idProduct);
        assertNull(instance.getProduct(idProduct));
    }
 */
}
