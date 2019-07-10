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

    public boolean hasNets() {
        Boolean containsFlag = false;
        for (String merchant : Main.netsArray) {
            if (name.compareToIgnoreCase(merchant) == 0) {
                containsFlag = true;
            }
        }
        return containsFlag;
    }

    public void printRest() {
        System.out.println("        \"" + name + "\" : {");
        System.out.println("            \"name\" : " + "\"" + name + "\",");
        System.out.println("            \"address\" : " + "\"" + unitNumber+ "\",");
        if (hasDash() && hasNets()) {
            System.out.println("            \"payment\" : " + "\"Dash, NetsQR\"");
        } else if (hasNets()) {
            System.out.println("            \"payment\" : " + "\"NetsQR\"");
        } else if (hasDash()) {
            System.out.println("            \"payment\" : " + "\"Dash\"");
        } else {
            System.out.println("            \"payment\" : " + "\"" + "\"");
        }
        System.out.println("        " + "},");
    }

    public void printRestLast() {
        System.out.println("        \"" + name + "\" : {");
        System.out.println("            \"name\" : " + "\"" + name + "\",");
        System.out.println("            \"address\" : " + "\"" + unitNumber + "\",");
        if (hasDash() && hasNets()) {
            System.out.println("            \"payment\" : " + "\"Dash, NetsQR\"");
        } else if (hasNets()) {
            System.out.println("            \"payment\" : " + "\"NetsQR\"");
        } else if (hasDash()) {
            System.out.println("            \"payment\" : " + "\"Dash\"");
        } else {
            System.out.println("            \"payment\" : " + "\"" + "\"");
        }
        System.out.println("        " + "}");
    }
}
