package packer;

/**
 *
 * @author I.M.Bad
 */
public class Box {
    
    private Manifest contents;
    private Customer customer;
    private Depot depot; 

    /**
     * 
     * @param customer
     * @param depot
     */
    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    
    /**
     * Add a product at a quantity of 1.
     * @param product
     */
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
    
    
    /**
     * addProduct override for adding multiple products
     * @param product
     * @param quantity
     */
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)); {
            contents.addProduct(product, quantity);
        }
    }
   
    /**
     * Get the label for the box.
     * @return box label as a string
     */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        return label.toString();
    }

    //Has no javadoc popup when using /** */
    //returns the label??? why
    public String toString() {
        return getLabel();
    }
    
    /**
     * 
     * @return weight
     */
    public double getWeight() {
        return contents.getWeight();
    }
    
    /**
     * Check to see if an item (p) can fit into the box
     * @param p
     * @return boolean 
     */
    public boolean canFit(Product p) {
        return p.getWeight() < 40;
    }
    
    /**
     * Check to see if the items (p) can fit into the box
     * @param p
     * @param quantity
     * @return boolean
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) < 40;
    }
    
    /**
     * Find out how full the box is
     * @return capacity left
     */
    public double remainingCapacity() {
        return 40 - this.getWeight();
    }
    
    /**
     * Check if the box should be classified as fragile
     * @return boolean
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    /**
     * Check if the box should be classified as hazardous
     * @return boolean
     */
    public boolean isHazardous() {
        return false;
    }
}
