/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.business;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mu.model.MyElement;
import org.mu.model.MyElementId;

/**
 *
 * @author Administrator
 */
public class FacadeServiceTest {
    
    public FacadeServiceTest() {
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
     * Test of create method, of class FacadeService.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create all");
        MyElement elm = new MyElement(new MyElementId(0), 0, 0);
        FacadeService instance = FacadeService.getService();
        instance.create(elm);
        Collection<MyElement> elems = instance.all();
        assertTrue(elems.contains(elm));
    }

    
}
