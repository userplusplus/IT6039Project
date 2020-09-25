package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author I.M.Bad
 */
public class Manifest {
    
    // This tracks the quantity if each product in the manifest
    private Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;

    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }
    
    //Gives you the option to just specify the product
    public void addProduct(Product p) {
        addProduct(p,1);
    }
    
    /**
     * Specify the product and how many to add
     * @param p product to add
     * @param quantity how many to add of the product
     */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            quantities.put(p,quantities.get(p)+ quantity);
        }
        else {
            quantities.put(p,quantity);
            if(!byWeight.add(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }
    
    /**
     * Remove the specified product
     * @param p product to be removed
     */
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) == 1) {
            quantities.remove(p);
            byWeight.remove(p);
        }else if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p,quantities.get(p)-1);
        } else {
            System.out.println("An excpetion occured while trying to remove a product");
        }
    }
    
    /**
     * get the total weight of all members within the manifest
     * @return weight
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight += quantities.get(p) * p.getWeight();
        }
        return weight;
    }
    
    /**
     * return the heaviest product within the manifest under a given weight
     * @param weight
     * @return heaviest product by weight
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * checks weight to see if the manifest is empty
     * @return
     */
    public boolean isEmpty() {
        return byWeight.isEmpty();
    }
    
    /**
     * checks manifest for instance of given product p
     * @param p
     * @return boolean 
     */
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }
    
    /**
     * returns formatted version of manifest that includes quantity
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        return result.substring(0, result.length()-1);
    }
    
    /**
     * Check for if fragile
     * @return boolean
     */
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check for hazards
     * @return boolean
     */
    public boolean hasHazardousItems() {
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }
}
    

