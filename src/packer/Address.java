package packer;

/**
 *
 * @author I.M.Bad
 */
public class Address {
    private String street;
    private String suburb;
    private String city;
    private String postcode;
    private Coordinates coordinates;
    
    /**
     * Address constructor
     * @param street
     * @param suburb
     * @param city
     * @param postcode
     * @param coordinates
     */
    public Address(String street, String suburb, String city, String postcode, Coordinates coordinates) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }

    /**
     * @return get address as string but formatted with whitespace.
     */
    public String toString() {
        return 
                street + "\n" +
                suburb + "\n" +
                city + "\n" +
                postcode;
    }
    /**
     * @return the coordinates of the address
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    
}
