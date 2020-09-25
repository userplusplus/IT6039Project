package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I.M.Bad
 */
public class Customer {
    
    private String name;
    private List<Address> addresses;

    /**
     * Customer arrayList
     * @param name
     * @param address
     */
    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    
    /**
     * add address to customer instance
     * @param address
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    
    /**
     * 
     * @return customer name as string
     */
    public String getName() {
        return name;
    }

    /**
     * Get the closest address to the depot
     * @param d
     * @return closest address
     */
    public Address getClosestAddressTo(Depot d) {
        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;
        for (Address a : addresses) {
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());
            if (distance < bestDistance) {
                //update the best distance
                bestDistance = distance;
                bestAddress = a;
            }
        }
        return bestAddress;
    }

    /**
     * 
     * @return  name of the customer
     */
    public String toString() {
        return this.getName();
    }
}
