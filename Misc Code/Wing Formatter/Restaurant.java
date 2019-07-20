class Restaurant {
    private String name;
    private String wing;
    private String unitNumber;
    public static Restaurant[] restArray;

    Restaurant(String name, String wing, String unitNumber) {
        this.name = name;
        this.wing = wing;
        this.unitNumber = unitNumber;
    }

    public String toString() {
        if (wing.equals("NIL")) {
            return name + ", " + unitNumber;
        } else {
            return name + ", " + unitNumber + " (" + wing + ")";
        }
    }

}
