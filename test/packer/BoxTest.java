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
    Product pfragile = new Product("Antique Vase",10,false,true);
    Product pheavy = new Product("Heavy Statue",15,false,false);
    Product p2big = new Product("Very Heavy Statue",1000,false,false);
    
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
            "Tennis Ball x 10\n" +
            "Tennis Racket x 2\n" +
            "HEAVY\n", b.getLabel());
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
        
        //has hazardous items and non hazardous items, flag still shows
    }
    
    /**
     * Test of getLabel method, of class Box.
     * Checking for fragile tag added.
     */
    @Test
    public void testGetLabelFragile() {
        System.out.println("getLabelFragile");
        
        //has hazard
        Box b = new Box(cu1, d1);
        b.addProduct(pfragile);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Antique Vase x 1\n" +
            "FRAGILE\n", b.getLabel());
        
        //not fragile
        Box b2 = new Box(cu1, d1);
        b2.addProduct(p1);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Tennis Ball x 1\n", b2.getLabel());
        
        //has fragile items and non fragile items, flag still shows
        b.addProduct(p1);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Tennis Ball x 1\n" +
            "Antique Vase x 1\n" +
            "FRAGILE\n", b.getLabel());
    }
    
    /**
     * Test of getLabel method, of class Box.
     * Checking for heavy tag added.
     */
    @Test
    public void testGetLabelHeavy() {
        System.out.println("getLabelHeavy");
        
        //not heavy
        Box b = new Box(cu1, d1);
        b.addProduct(phazard);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "TNT x 1\n" +
            "HAZARD\n", b.getLabel());
        
        //is heavy
        Box b2 = new Box(cu1, d1);
        b2.addProduct(p1, 18);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Tennis Ball x 18\n" +
            "HEAVY\n", b2.getLabel());
        
        //not heavy
        Box b3 = new Box(cu1, d1);
        b3.addProduct(pfragile);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Antique Vase x 1\n" +
            "FRAGILE\n", b3.getLabel());
    }
    
    /**
     * Test of getLabel method, of class Box.
     * Checking if you can add products which would go beyond the limits of the
     * box.
     */
    @Test
    public void testCanFit(){
        System.out.println("canFit");
        
        //can fit, multiple items
        Box fullBox = new Box(cu1, d1);
        fullBox.addProduct(p2, 5);
        assertEquals(true, fullBox.canFit(p1, 5));
        
        //cant fir, multiple items
        assertEquals(false, fullBox.canFit(p2, 5));
        
        //cant fit one large item (weight 1000)
        Box emptyBox = new Box(cu1, d1);
        assertEquals(false, emptyBox.canFit(p2big, 1));
        
        //can fit group of small items int box
        assertEquals(true, emptyBox.canFit(p1, 5));
    }
    
}
