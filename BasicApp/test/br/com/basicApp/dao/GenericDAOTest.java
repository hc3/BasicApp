/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.basicApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class GenericDAOTest {
    
    public GenericDAOTest() {
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

    /**
     * Test of getConnection method, of class GenericDAO.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        GenericDAO instance = new GenericDAOImpl();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatement method, of class GenericDAO.
     */
    @Test
    public void testGetStatement_0args() throws Exception {
        System.out.println("getStatement");
        GenericDAO instance = new GenericDAOImpl();
        Statement expResult = null;
        Statement result = instance.getStatement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatement method, of class GenericDAO.
     */
    @Test
    public void testGetStatement_String() throws Exception {
        System.out.println("getStatement");
        String st = "";
        GenericDAO instance = new GenericDAOImpl();
        PreparedStatement expResult = null;
        PreparedStatement result = instance.getStatement(st);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeQuery method, of class GenericDAO.
     */
    @Test
    public void testExecuteQuery() throws Exception {
        System.out.println("executeQuery");
        String query = "";
        Object[] params = null;
        GenericDAO instance = new GenericDAOImpl();
        ResultSet expResult = null;
        ResultSet result = instance.executeQuery(query, params);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeCommand method, of class GenericDAO.
     */
    @Test
    public void testExecuteCommand() throws Exception {
        System.out.println("executeCommand");
        String query = "";
        Object[] params = null;
        GenericDAO instance = new GenericDAOImpl();
        int expResult = 0;
        int result = instance.executeCommand(query, params);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextId method, of class GenericDAO.
     */
    @Test
    public void testGetNextId() throws Exception {
        System.out.println("getNextId");
        String tableName = "";
        GenericDAO instance = new GenericDAOImpl();
        Integer expResult = null;
        Integer result = instance.getNextId(tableName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class GenericDAOImpl extends GenericDAO {
    }
    
}
