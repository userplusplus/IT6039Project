package packer;

/**
 *
 * @author I.M.Bad
 */
public class Coordinates {
    
    private final double x;
    private final double y;
    
    /**
     * 
     * @param x
     * @param y
     */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * 
     * @return
     */
    public double getY() {
        return y;
    }
    
    /**
     * Find the distance between x co-ord and y co-ord
     * @param other
     * @return distance between co-ords
     */
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff),0.5);
        return dist;
    }
    
    /**
     * Find the distance between x co-ord and manhattan
     * @param other
     * @return distance between co-ords
     */
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }
    
    /**
     * Find the distance between x co-ord and the company
     * @param other
     * @return distance between coo-ords
     */
    public double companyDistanceTo(Coordinates other) {
        double xDiff1 = other.getX() - this.getX();
        double yDiff1 = other.getY() - this.getY();
        double dist1 = Math.pow((xDiff1 * xDiff1 + yDiff1 * yDiff1),0.5);
        double xDiff2 = other.getX() - this.getX();
        double yDiff2 = other.getY() - this.getY();
        double dist2 = Math.abs(xDiff2) + Math.abs(yDiff2);
        return (dist1 + dist2)/2 + 1;
    }

}
