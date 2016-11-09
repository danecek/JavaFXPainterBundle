/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class MyRectangleTest {
    
    public MyRectangleTest() {
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
     * Test of getWidth method, of class MyRectangle.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        MyRectangle instance = new MyRectangle(new MyElementId(0), 1, 1, 1, 1);
        double expResult = 1;
        double result = instance.getWidth();
        assertEquals(expResult, result, 0.1);
    }

 
    
}
