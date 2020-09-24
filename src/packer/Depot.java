package packer;

/**
 *
 * @author I.M.Bad
 */
public class Depot {
    private String name;
    private Address address;

    /**
     * Depot object
     * @param name
     * @param address
     */
    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    public String getName() {
        return address.toString();
    }
    
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    public String toString() {
        return this.getName();
    }
    
}
