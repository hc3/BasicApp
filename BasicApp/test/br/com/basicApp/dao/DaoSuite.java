/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.basicApp.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Eliel
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({br.com.basicApp.dao.ProductDAOTest.class, br.com.basicApp.dao.UserDAOTest.class, br.com.basicApp.dao.GenericDAOTest.class, br.com.basicApp.dao.SellDAOTest.class, br.com.basicApp.dao.CustomerDAOTest.class})
public class DaoSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
