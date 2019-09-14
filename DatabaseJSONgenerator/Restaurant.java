import java.util.*;

/**
 * A class representing the restaurants in the malls supported by PayWhere.
 * Note that restaurants with multiple outlets do not share the same Restaurant object as it is unique to the
 * mall it belongs to.
 */
public class Restaurant {
    private String name;
    private String unitNumber;
    private Mall mall;

    /**
     * Creates a restaurant object with the restaurant name, unit number and mall it belongs to assigned.
     * @param name Name of restaurant.
     * @param unitNumber Unit number of restaurant in the mall.
     * @param mall Mall where restaurant is located.
     */
    public Restaurant(String name, String unitNumber, Mall mall) {
        this.name = name;
        this.unitNumber = unitNumber;
        this.mall = mall;
    }

    /**
     * Checks if this restaurant supports Singtel Dash.
     * 
     * @return Whether this restaurant supports Singtel Dash or not.
     */
    private boolean hasDash() {
        Boolean containsFlag = false;
        for (String merchant : Main.dashArray) {
            if (name.compareToIgnoreCase(merchant) == 0) {
                containsFlag = true;
            }
        }
        return containsFlag;
    }

    /**
     * Checks if this restaurant supports GrabPay.
     * Checking is more rigorous than other restaurants as other than matching restaurant name, we match mall 
     * name as well.
     * 
     * @return Whether this restaurant supports GrabPay or not.
     */
    private boolean hasGrab() {
        Boolean containsFlag = false;
        for (GrabMerchant merchant : Main.grabArray) {
            String merchantName = merchant.getName();
            String merchantAddress = merchant.getAddress().toLowerCase();
            if ((name.compareToIgnoreCase(merchantName) == 0) && (merchantAddress.contains(mall.getName()))) {
                containsFlag = true;
            }
        }
        return containsFlag;
    }

    /**
     * Checks if this restaurant supports Nets QR.
     * 
     * @return Whether this restaurant supports Nets QR or not.
     */
    private boolean hasNets() {
        Boolean containsFlag = false;
        for (String merchant : Main.netsArray) {
            if (name.compareToIgnoreCase(merchant) == 0) {
                containsFlag = true;
            }
        }
        return containsFlag;
    }

    /**
     * Includes the merchants this restaurant supports in the JSON file.
     * 
     * @return All the merchatns supported by this restaurant.
     */
    private String getPayment() {
        if (hasDash() && hasGrab() && hasNets()) {
            return "            \"payment\" : " + "\"Dash, GrabPay, NetsQR\"";
        } else if (hasDash() && hasGrab()) {
            return "            \"payment\" : " + "\"Dash, GrabPay\"";
        } else if (hasDash() && hasNets()) {
            return "            \"payment\" : " + "\"Dash, NetsQR\"";
        } else if (hasGrab() && hasNets()) {
            return "            \"payment\" : " + "\"GrabPay, NetsQR\"";
        } else if (hasGrab()) {
            return "            \"payment\" : " + "\"GrabPay\"";
        } else if (hasNets()) {
            return "            \"payment\" : " + "\"NetsQR\"";
        } else if (hasDash()) {
            return "            \"payment\" : " + "\"Dash\"";
        } else {
            return "            \"payment\" : " + "\"" + "\"";
        }
    }

    /**
     * Prints the contents of this restaurant in the JSON file, followed by a comma at the end.
     */
    public void printRest() {
        System.out.println("        \"" + name + "\" : {");
        System.out.println("            \"name\" : " + "\"" + name + "\",");
        System.out.println("            \"address\" : " + "\"" + unitNumber+ "\",");
        System.out.println(getPayment() + ",");
        if (Icon.imgHash.containsKey(name)) {
            System.out.println("            \"image\" : " + "\"" + Icon.imgHash.get(name) + "\"");
        } else {
            System.out.println("            \"image\" : " + "\"\"");
        }
        System.out.println("        " + "},");
    }

    /**
     * Prints the contents of this restaurant in the JSON file.
     */
    public void printRestLast() {
        System.out.println("        \"" + name + "\" : {");
        System.out.println("            \"name\" : " + "\"" + name + "\",");
        System.out.println("            \"address\" : " + "\"" + unitNumber + "\",");
        System.out.println(getPayment() + ",");
        if (Icon.imgHash.containsKey(name)) {
            System.out.println("            \"image\" : " + "\"" + Icon.imgHash.get(name) + "\"");
        } else {
            System.out.println("            \"image\" : " + "\"\"");
        }
        System.out.println("        " + "}");
    }
}
