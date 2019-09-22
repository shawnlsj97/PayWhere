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
    private final String TAB = "    ";
    private final String QUOTE = "\"";
    private final String PAYMENT_OPENING = TAB + TAB + TAB + QUOTE + "payment" + QUOTE + " : " + QUOTE;

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
        for (String merchant : Reader.dashArray) {
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
        for (GrabMerchant merchant : Reader.grabArray) {
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
        for (String merchant : Reader.netsArray) {
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
            return PAYMENT_OPENING + "Dash, GrabPay, NetsQR" + QUOTE;
        } else if (hasDash() && hasGrab()) {
            return PAYMENT_OPENING + "Dash, GrabPay" + QUOTE;
        } else if (hasDash() && hasNets()) {
            return PAYMENT_OPENING + "Dash, NetsQR" + QUOTE;
        } else if (hasGrab() && hasNets()) {
            return PAYMENT_OPENING + "GrabPay, NetsQR" + QUOTE;
        } else if (hasGrab()) {
            return PAYMENT_OPENING + "GrabPay" + QUOTE;
        } else if (hasNets()) {
            return PAYMENT_OPENING + "NetsQR" + QUOTE;
        } else if (hasDash()) {
            return PAYMENT_OPENING + "Dash" + QUOTE;
        } else {
            return PAYMENT_OPENING + QUOTE;
        }
    }

    /**
     * Prints the contents of this restaurant in the JSON file.
     */
    public String getRestaurantEntry(int index, int numRest) {
        StringBuilder sb = new StringBuilder();
        sb.append(TAB + TAB + QUOTE + name + QUOTE + " : {\n");
        sb.append(TAB + TAB + TAB + QUOTE + "name" + QUOTE + " : " + QUOTE + name + QUOTE + ",\n");
        sb.append(TAB + TAB + TAB + QUOTE + "address" + QUOTE + " : " + QUOTE + unitNumber+ QUOTE + ",\n");
        sb.append(getPayment() + ",\n");
        if (Icon.imgHash.containsKey(name)) {
            sb.append(TAB + TAB + TAB + QUOTE + "image" + QUOTE + " : " + QUOTE + Icon.imgHash.get(name) + QUOTE + "\n");
        } else {
            sb.append(TAB + TAB + TAB + QUOTE + "image" + QUOTE + " : " + QUOTE + QUOTE + "\n");
        }
        if (index == numRest - 1) {
            sb.append(TAB + TAB + "}\n");
        } else {
            sb.append(TAB + TAB + "},\n");
        }
        return sb.toString();
    }

}
