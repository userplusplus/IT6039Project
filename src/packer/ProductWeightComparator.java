package packer;

import java.util.Comparator;

/**
 *
 * @author I.M.Bad
 * 
 * This is used when we need to sort by product weight descending
 */
public class ProductWeightComparator implements Comparator<Product> {
    
    /**
     * compare the weights of 2 products for use in packer class
     */
    public int compare(Product a, Product b) {
        if (a.getWeight() < b.getWeight()) {return 1;}
        else if (a.getWeight() > b.getWeight()) {return -1;}
        else return a.getName().compareTo(b.getName());
    }
                
}
