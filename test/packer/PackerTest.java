/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominic Martindale
 */
public class PackerTest {
    
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
        System.out.println("Testing Packer class...");
    }
    
    /**
     * Test of packProducts method, of class packer.
     * Checking for products to be 'packed' into boxes appropriately.
     */
    @Test
    public void testPacker() {
        System.out.println("testPacker");
        
        Manifest m = new Manifest();
        m.addProduct(p1, 5);
        m.addProduct(p2, 2);
        List<Box> pack = Packer.packProducts(cu1, d1, m);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Tennis Ball x 5\n" +
            "Tennis Racket x 2\n", pack.get(0).toString());
        
        Manifest m2 = new Manifest();
        m2.addProduct(p1, 1);
        m2.addProduct(pheavy, 1);
        List<Box> pack2 = Packer.packProducts(cu1, d1, m2);
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Tennis Ball x 1\n" +
            "Heavy Statue x 1\n" +
            "HEAVY\n", pack2.get(0).toString());
        
        Manifest m3 = new Manifest();
        m3.addProduct(pheavy, 1);
        m3.addProduct(pfragile, 1); //note: cant add due to weight limit
        List<Box> pack3 = Packer.packProducts(cu1, d1, m3);
        System.out.println(pack3.get(0).toString());
        assertEquals("Awesome Name\n" +
            "2 Second St\n" +
            "Aplace\n" +
            "Citadel City\n" +
            "A111\n" +
            "Heavy Statue x 1\n" +
            "HEAVY\n", pack3.get(0).getLabel());
        
    }
        
}
