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
    
    /** 
     * @return returns the name of the depot
     */
    public String getName() {
        return name.toString();
    }
    
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    /**
     * 
     * @return depot name as string 
     */
    public String toString() {
        return this.getName();
    }
    
}
