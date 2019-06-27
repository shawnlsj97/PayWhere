package com.marshmallow.paywhere;

public class Store {

    public String name, payment, address;

    public Store(String name, String payment, String address) {
        this.name = name;
        this.payment = payment;
        this.address = address;
    }

    public Store(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
