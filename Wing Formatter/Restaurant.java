class Restaurant {
    private String name;
    private String wing; // east = true, west = false
    private String unitNumber;
    public static Restaurant[] restArray;

    Restaurant(String name, String wing, String unitNumber) {
        this.name = name;
        this.wing = wing;
        this.unitNumber = unitNumber;
    }

    @Override
    public String toString() {
        return name + ", " + unitNumber + " (" + wing + ")";
    }

}
