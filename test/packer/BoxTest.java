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
public class BoxTest {
    
    //test data
    Product p1 = new Product("Tennis Ball",1,false,false);
    Product p2 = new Product("Tennis Racket",3,false,false);
    Product phazard = new Product("TNT",5,true,false);
    Product pfragile = new Product("Antique Statue",10,false,true);
    Product pheavy = new Product("Heavy Antique Statue",100,false,false);
    
    Coordinates c1 = new Coordinates(30,40);
    Coordinates c2 = new Coordinates(300,400);
    Address a1 = new Address("1 First St", "Aplace", "Citadel City", "A111", c1);
    Address a2 = new Address("2 Second St", "Aplace", "Citadel City", "A111", c2);
    Depot d1 = new Depot("HomeDepot", a1);
    Customer cu1 = new Customer("Awesome Name", a2);
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }
    
    /**
     * Test of addProduct (single quantity) method, of class Box.
     */
    @Test
    public void testAddProductSingle() {
        System.out.println("addProductSingle");
        
        Box b = new Box(cu1, d1);
        b.addProduct(p1);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Tennis Ball x 1\n", b.getLabel());
        b.addProduct(p1);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Tennis Ball x 2\n", b.getLabel());
    }
    
    /**
     * Test of addProduct (multiple quantity) method, of class Box.
     */
    @Test
    public void testAddProductMultiple() {
        System.out.println("addProductMultiple");
        
        Box b = new Box(cu1, d1);
        b.addProduct(p1, 5);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Tennis Ball x 5\n", b.getLabel());
        b.addProduct(p1, 5);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Tennis Ball x 10\n", b.getLabel());
        b.addProduct(p2, 2);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Tennis Racket x 2\n" +
            "Tennis Ball x 10\n", b.getLabel());
    }
    
    /**
     * Test of getLabel method, of class Box.
     * Checking for hazard tag added.
     */
    @Test
    public void testGetLabelHazard() {
        System.out.println("getLabelHazard");
        
        //has hazard
        Box b = new Box(cu1, d1);
        b.addProduct(phazard);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "TNT x 1\n" +
            "HAZARD\n", b.getLabel());
        
        //no hazard
        Box b2 = new Box(cu1, d1);
        b2.addProduct(p1);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Tennis Ball x 1\n", b2.getLabel());
    }
    
    /**
     * Test of getLabel method, of class Box.
     * Checking for heavy tag added.
     */
    @Test
    public void testGetLabelHeavy() {
        System.out.println("getLabelHeavy");
        
        Box b = new Box(cu1, d1);
    }
    
}
