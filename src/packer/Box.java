package packer;

/**
 *
 * @author I.M.Bad
 */
public class Box {
    
    private Manifest contents;
    private Customer customer;
    private Depot depot; 
    private int boxMaxWeight = 20;
    private int heavyLabelWeight = 15;

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
     * addProduct method instance for adding multiple products
     * @param product
     * @param quantity
     */
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)) {
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
        if (this.isHazardous()) {
            label.append("HAZARD\n");
        }
        if (this.isHeavy()) {
            label.append("HEAVY\n");
        }
        return label.toString();
    }

    public String toString() {
        return getLabel();
    }
    
    /**
     * 
     * @return weight
     */
    public double getWeight() {
        return contents.getTotalWeight();
    }
    
    /**
     * Check to see if an item (p) can fit into the box
     * @param p product
     * @return boolean 
     */
    public boolean canFit(Product p) {
        return p.getWeight() < this.remainingCapacity();
    }
    
    /**
     * Check to see if the items (p) can fit into the box
     * @param p product
     * @param quantity
     * @return boolean
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) <= this.remainingCapacity();
    }
    
    /**
     * Find out how full the box is
     * @return capacity left
     */
    public double remainingCapacity() {
        System.out.println(this.getWeight());
        return boxMaxWeight - this.getWeight();
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
        return contents.hasHazardousItems();
    }
    
    /**
     * Check if the box should be classified as past the maximum weight limit
     * @return boolean
     */
    public boolean isHeavy() {
        return contents.getTotalWeight() >= heavyLabelWeight;
    }
}
