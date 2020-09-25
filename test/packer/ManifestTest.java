/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominic Martindale
 */
public class ManifestTest {
    
    //test data
    Product p1 = new Product("Tennis Ball",1,false,false);
    Product p2 = new Product("Tennis Racket",3,false,false);
    Product phazard = new Product("TNT",5,true,false);
    Product pfragile = new Product("Antique Vase",10,false,true);
    Product pheavy = new Product("Heavy Statue",15,false,false);
    Product p2big = new Product("Very Heavy Statue",1000,false,false);
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
    }
    
    @Test
    public void testAddProductSingle() {
        System.out.println("AddProductSingle");
        
        Manifest m = new Manifest();
        m.addProduct(p1);
        assertEquals("Tennis Ball x 1", m.toString());
        m.addProduct(p1);
        assertEquals("Tennis Ball x 2", m.toString());
        
        Manifest m2 = new Manifest();
        m2.addProduct(phazard);
        assertEquals("TNT x 1", m2.toString());
    }
    
    @Test
    public void testAddProductMultiple() {
        System.out.println("AddProductMultiple");
        
        Manifest m = new Manifest();
        m.addProduct(p1, 5);
        assertEquals("Tennis Ball x 5", m.toString());
        m.addProduct(p2, 2);
        assertEquals("Tennis Ball x 5\nTennis Racket x 2", m.toString());
        m.addProduct(p1, 5);
        assertEquals("Tennis Ball x 10\nTennis Racket x 2", m.toString());
    }
    
    @Test
    public void testRemoveProduct() {
        System.out.println("RemoveProduct");
        
        Manifest m = new Manifest();
        m.addProduct(p1, 5);
        assertEquals("Tennis Ball x 5", m.toString()); //confirm there are tennis balls
        m.removeProduct(p1);
        assertEquals("Tennis Ball x 4", m.toString());
        m.removeProduct(p1);
        assertEquals("Tennis Ball x 3", m.toString());
        m.removeProduct(p1);
        assertEquals("Tennis Ball x 2", m.toString());
        m.removeProduct(p1);
        assertEquals("Tennis Ball x 1", m.toString());
        m.removeProduct(p1);
    }
    
    @Test
    public void testGetTotalWeight() {
        System.out.println("testPacker");
        
        Manifest m = new Manifest();
        m.addProduct(p2, 1);
        assertEquals(3, m.getTotalWeight(), 0.0);
        m.addProduct(p2, 1);
        assertEquals(6, m.getTotalWeight(), 0.0);
        m.addProduct(p1, 5);
        assertEquals(11, m.getTotalWeight(), 0.0);
    }
    
    @Test
    public void testGetHeaviestUnder() {
        System.out.println("GetHeaviestUnder");
        
        // p1 w = 1, p2 w = 3, phazard w = 5, pfragile w = 10
        
        Manifest m = new Manifest();
        m.addProduct(p1);
        m.addProduct(p2);
        assertEquals(p1, m.getHeaviestUnder(2));
        assertEquals(p2, m.getHeaviestUnder(4));
        
        m.addProduct(phazard);
        assertEquals(p1, m.getHeaviestUnder(2));
        assertEquals(p2, m.getHeaviestUnder(4));
        assertEquals(phazard, m.getHeaviestUnder(6));
        
        m.addProduct(pfragile);
        assertEquals(p1, m.getHeaviestUnder(2));
        assertEquals(p2, m.getHeaviestUnder(4));
        assertEquals(phazard, m.getHeaviestUnder(6));
        assertEquals(pfragile, m.getHeaviestUnder(12));
    }
    
    @Test
    public void testIsEmpty() {
        System.out.println("IsEmpty");
        
        Manifest m = new Manifest();
        
        //not empty
        m.addProduct(p1);
        assertEquals(false, m.isEmpty());
        
        //empty
        m.removeProduct(p1);
        assertEquals(true, m.isEmpty());
        
    }
    
    @Test
    public void testContainsProduct() {
        System.out.println("ContainsProduct");
        
        Manifest m = new Manifest();
        assertEquals(false, m.containsProduct(p1));
        
        m.addProduct(p1);
        assertEquals(true, m.containsProduct(p1));
        assertEquals(false, m.containsProduct(p2));
    }
}
