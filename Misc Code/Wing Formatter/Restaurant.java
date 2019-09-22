/**
 * Restaurant in a mall.
 */
public class Restaurant {

    private String name;
    private String wing;
    private String unitNumber;
    public static Restaurant[] restArray;

    /**
     * Creates a Restaurant object with its details assigned.
     * @param name       Name of the restaurant.
     * @param wing       Wing that the restaurant is in.
     * @param unitNumber Unit number of the restaurant.
     */
    public Restaurant(String name, String wing, String unitNumber) {
        this.name = name;
        this.wing = wing;
        this.unitNumber = unitNumber;
    }

    /**
     * Outputs the restaurant listing in the desired format.
     * Restaurants without wings will not be affected.
     *
     * @return Restaurant listing in the desired format.
     */
    public String toString() {
        if (wing.equals("NIL")) {
            return name + ", " + unitNumber;
        } else {
            return name + ", " + unitNumber + " (" + wing + ")";
        }
    }

}
