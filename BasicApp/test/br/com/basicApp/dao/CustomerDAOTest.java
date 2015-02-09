/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.basicApp.dao;

import br.com.basicApp.model.Customer;
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
public class CustomerDAOTest {
    private static Integer idCustomer = 1;
    public CustomerDAOTest() {
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
  
   @Test
    public void testGetCustomer() throws Exception {
        System.out.println("getCustomer");
        CustomerDAO instance = new CustomerDAO();
        assertNull(instance.getCustomer(idCustomer));
    }

    @Test
    public void testAddCustomer() throws Exception {
        System.out.println("addCustomer");
        Customer ctm = new Customer();
        ctm.setName("Eliel das Virgens");
        ctm.setAge(23);
        ctm.setAddress("Rua 4");
        ctm.setTelephone("9898143");
        CustomerDAO instance = new CustomerDAO();
        idCustomer = instance.addCustomer(ctm);
        assertTrue(idCustomer > 0);
    }


    @Test
    public void testUpdateCustomer() throws Exception {
        System.out.println("updateCustomer");
        int id = 1;
        CustomerDAO instance = new CustomerDAO();
        Customer ctm = instance.getCustomer(id);
        ctm.setName("Eliel Now");
        instance.updateCustomer(ctm);
        ctm = instance.getCustomer(id);
        assertEquals("Eliel Now",ctm.getName());
    }


    @Test
    public void testGetCustomersByName() throws Exception {
        System.out.println("getCustomersByName");
        String name = "Eliel";
        CustomerDAO instance = new CustomerDAO();
        List<Customer> result = instance.getCustomersByName(name);
        assertTrue(result.size() > 0);
    }
    
        @Test
    public void testRemoveCustomer() throws Exception {
        System.out.println("removeCustomer");
        CustomerDAO instance = new CustomerDAO();
        instance.removeCustomer(idCustomer);
        assertNull(instance.getCustomer(idCustomer));
    }

}
