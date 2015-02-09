/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.basicApp.dao;

import br.com.basicApp.model.User;
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
public class UserDAOTest {
    
    public UserDAOTest() {
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
     * Test of isValidUserAndPassword method, of class UserDAO.
     */
    @Test
    public void testIsValidUserAndPassword() throws Exception {
        System.out.println("isValidUserAndPassword");
        String name = "";
        String password = "";
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.isValidUserAndPassword(name, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewUser method, of class UserDAO.
     */
    @Test
    public void testCreateNewUser() throws Exception {
        System.out.println("createNewUser");
        User usr = null;
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.createNewUser(usr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class UserDAO.
     */
    @Test
    public void testRemoveUser() throws Exception {
        System.out.println("removeUser");
        int idUser = 0;
        UserDAO instance = new UserDAO();
        instance.removeUser(idUser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class UserDAO.
     */
    @Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        User usr = null;
        UserDAO instance = new UserDAO();
        instance.updateUser(usr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class UserDAO.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        int idUser = 0;
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.getUser(idUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUsers method, of class UserDAO.
     */
    @Test
    public void testGetAllUsers() throws Exception {
        System.out.println("getAllUsers");
        UserDAO instance = new UserDAO();
        List<User> expResult = null;
        List<User> result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
