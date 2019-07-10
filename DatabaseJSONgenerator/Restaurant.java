class Restaurant {
    private String name;
    private String unitNumber;

    Restaurant (String name, String unitNumber) {
        this.name = name;
        this.unitNumber = unitNumber;
    }

    public boolean hasDash() {
        Boolean containsFlag = false;
        for (String merchant : Main.dashArray) {
            if (name.compareToIgnoreCase(merchant) == 0) {
                containsFlag = true;
            }
        }
        return containsFlag;
    }

    public boolean hasGrab() {
        Boolean containsFlag = false;
        for (String merchant : Main.grabArray) {
            if (name.compareToIgnoreCase(merchant) == 0) {
                containsFlag = true;
            }
        }
        return containsFlag;
    }

    public boolean hasNets() {
        Boolean containsFlag = false;
        for (String merchant : Main.netsArray) {
            if (name.compareToIgnoreCase(merchant) == 0) {
                containsFlag = true;
            }
        }
        return containsFlag;
    }

    public String getPayment() {
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
    
    public void printRest() {
        System.out.println("        \"" + name + "\" : {");
        System.out.println("            \"name\" : " + "\"" + name + "\",");
        System.out.println("            \"address\" : " + "\"" + unitNumber+ "\",");
        System.out.println(getPayment());
        System.out.println("        " + "},");
    }

    public void printRestLast() {
        System.out.println("        \"" + name + "\" : {");
        System.out.println("            \"name\" : " + "\"" + name + "\",");
        System.out.println("            \"address\" : " + "\"" + unitNumber + "\",");
        System.out.println(getPayment());
        System.out.println("        " + "}");
    }
}
