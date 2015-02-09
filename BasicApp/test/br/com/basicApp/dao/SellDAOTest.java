/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.basicApp.dao;

import br.com.basicApp.model.Sell;
import br.com.basicApp.model.SellItem;
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
public class SellDAOTest {
    
    public SellDAOTest() {
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
     * Test of addSell method, of class SellDAO.
     */
    @Test
    public void testAddSell() throws Exception {
        System.out.println("addSell");
        Sell sl = null;
        boolean cascade = false;
        SellDAO instance = new SellDAO();
        int expResult = 0;
        int result = instance.addSell(sl, cascade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSellItem method, of class SellDAO.
     */
    @Test
    public void testAddSellItem() throws Exception {
        System.out.println("addSellItem");
        SellItem sli = null;
        SellDAO instance = new SellDAO();
        int expResult = 0;
        int result = instance.addSellItem(sli);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSell method, of class SellDAO.
     */
    @Test
    public void testUpdateSell() throws Exception {
        System.out.println("updateSell");
        Sell sl = null;
        boolean cascade = false;
        SellDAO instance = new SellDAO();
        instance.updateSell(sl, cascade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSellItem method, of class SellDAO.
     */
    @Test
    public void testUpdateSellItem() throws Exception {
        System.out.println("updateSellItem");
        SellItem sli = null;
        SellDAO instance = new SellDAO();
        instance.updateSellItem(sli);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSell method, of class SellDAO.
     */
    @Test
    public void testRemoveSell() throws Exception {
        System.out.println("removeSell");
        int idSell = 0;
        SellDAO instance = new SellDAO();
        instance.removeSell(idSell);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSellItem method, of class SellDAO.
     */
    @Test
    public void testRemoveSellItem() throws Exception {
        System.out.println("removeSellItem");
        int idSellItem = 0;
        SellDAO instance = new SellDAO();
        instance.removeSellItem(idSellItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSell method, of class SellDAO.
     */
    @Test
    public void testGetSell() throws Exception {
        System.out.println("getSell");
        int idSell = 0;
        SellDAO instance = new SellDAO();
        Sell expResult = null;
        Sell result = instance.getSell(idSell);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllSells method, of class SellDAO.
     */
    @Test
    public void testGetAllSells() throws Exception {
        System.out.println("getAllSells");
        SellDAO instance = new SellDAO();
        List<Sell> expResult = null;
        List<Sell> result = instance.getAllSells();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateSell method, of class SellDAO.
     */
    @Test
    public void testPopulateSell() throws Exception {
        System.out.println("populateSell");
        ResultSet rs = null;
        boolean populateItens = false;
        SellDAO instance = new SellDAO();
        Sell expResult = null;
        Sell result = instance.populateSell(rs, populateItens);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSellItem method, of class SellDAO.
     */
    @Test
    public void testGetSellItem() throws Exception {
        System.out.println("getSellItem");
        int idSellItem = 0;
        SellDAO instance = new SellDAO();
        SellItem expResult = null;
        SellItem result = instance.getSellItem(idSellItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSellItens method, of class SellDAO.
     */
    @Test
    public void testGetSellItens() throws Exception {
        System.out.println("getSellItens");
        Sell sl = null;
        SellDAO instance = new SellDAO();
        List<SellItem> expResult = null;
        List<SellItem> result = instance.getSellItens(sl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateSellItem method, of class SellDAO.
     */
    @Test
    public void testPopulateSellItem() throws Exception {
        System.out.println("populateSellItem");
        ResultSet rs = null;
        Sell[] sell = null;
        SellDAO instance = new SellDAO();
        SellItem expResult = null;
        SellItem result = instance.populateSellItem(rs, sell);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
