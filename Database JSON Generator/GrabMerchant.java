/**
 * A class representing GrabPay merchants.
 * Not all outlets of a certain store accept GrabPay (eg. Tanuki Raw at Orchard Central accepts GrabPay, but
 * the one at Jewel does not), hence it is necessary to check the mall for GrabPay merchants.
 */
public class GrabMerchant {

    private String name;
    private String address;

    /**
     * Creates a GrabPay object with name and address of the merchant.
     * 
     * @param name Name of this GrabPay merchant store.
     * @param address Address of this GrabPay merchant store.
     */
    public GrabMerchant(String name, String address) {
        this.name = name.toLowerCase();
        this.address = address.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}