import java.util.*;

/**
 * A class representing the malls supported by PayWhere.
 */
public class Mall {

    private String name;
    private ArrayList<Restaurant> restaurants;
    private static ArrayList<Mall> malls = new ArrayList<>();
    private static final String TAB = "    ";
    private static final String QUOTE = "\"";

    /**
     * Creates a Mall object with the mall name and restaurants it contains.
     *
     * @param name Name of this mall.
     * @param numRest Number of restaurants in this mall.
     */
    public Mall(String name) {
        this.name = name;
        this.restaurants = new ArrayList<>();
    }

    /**
     * Adds a mall to the list of malls.
     *
     * @param mall Mall to be added.
     */
    public static void addMall(Mall mall) {
        malls.add(mall);
    }

    /**
     * Adds a restaurant to this mall.
     *
     * @param restaurant Restaurant to be added to this mall.
     */
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    /**
     * Retrieves the name of this mall.
     *
     * @return Name of this mall.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the list of malls.
     *
     * @return List of all malls.
     */
    public static ArrayList<Mall> getMalls() {
        return malls;
    }

    /**
     * Opens this mall in the JSON file.
     *
     * @return Starting line for the mall in the format
     *     "mall name" : {
     */
    public String getOpening() {
        return TAB + QUOTE + name + QUOTE + " : {";
    }

    /**
     * Closes this mall entry in the JSON file.
     * @param  index Index of the current mall in the list of malls.
     * @return       Closing line of }, or } if it is the last mall in the list.
     */
    public String getClose(int index) {
        if (index == malls.size() - 1) {
            return TAB + "}";
        } else {
            return TAB + "},";
        }
    }

    /**
     * Compiles all the restaurant entries for this mall in the JSON file.
     *
     * @return All the restaurant entries in the JSON file.
     */
    public String getRestaurantEntries() {
        int restaurantCount = restaurants.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < restaurantCount; i++) {
            Restaurant currRestaurant = restaurants.get(i);
            String currRestaurantEntry = currRestaurant.getRestaurantEntry(i, restaurantCount);
            sb.append(currRestaurantEntry);
        }
        return sb.toString();
    }

    /**
     * Retrieves the dummy mall listing for all the mall names in the JSON file.
     *
     * @return Dummy mall listing.
     */
    public static String getMallsJson() {
        StringBuilder sb = new StringBuilder();
        sb.append(TAB + QUOTE + "malls" + QUOTE + " : {\n");
        for (int i = 0; i < malls.size(); i++) {
            Mall mall = malls.get(i);
            sb.append(TAB + TAB + QUOTE + mall.name + QUOTE + " : {\n");
            sb.append(TAB + TAB + TAB + QUOTE + "name" + QUOTE + " : " + QUOTE + mall.name + QUOTE + "\n");
            if (i == malls.size() - 1) {
                sb.append(TAB + TAB + "}\n");
            } else {
                sb.append(TAB + TAB + "},\n");
            }
        }
        sb.append(TAB + "},");
        return sb.toString();
    }

}
