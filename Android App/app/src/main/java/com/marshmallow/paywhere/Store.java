package com.marshmallow.paywhere;

/**
 * Represents a dining outlet in a mall.
 */
public class Store {
    /**
     * Each store has a name, mobile payment options, address and image url.
     */
    public String name, payment, address, image;

    /**
     * Constructor that creates an instance of the Store class and assigns a name, payment
     * options, address and image url to the instance.
     * @param name Store name.
     * @param payment Mobile payment options available at the store.
     * @param address Store address.
     */
    public Store(String name, String payment, String address, String image) {
        this.name = name;
        this.payment = payment;
        this.address = address;
        this.image = image;
    }

    public Store(){}

    /**
     * Method to get store name.
     * @return String representing store name.
     */
    public String getName() {
        return name;
    }

    /** Method to set store name.
     * @param name String representing store name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get mobile payment options of the store.
     * @return String representing mobile payment options.
     */
    public String getPayment() {
        return payment;
    }

    /**
     * Method to set mobile payment options of the store.
     * @param payment String representing mobile payment options.
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

    /**
     * Method to get store address.
     * @return String representing store address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method to set store address.
     * @param address String representing store address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Method to get store image url.
     * @return String representing store image url.
     */
    public String getImage() {
        return image;
    }

    /**
     * Method to set store image url.
     * @param image String representing store image url.
     */
    public void setImage(String image) {
        this.image = image;
    }
}
