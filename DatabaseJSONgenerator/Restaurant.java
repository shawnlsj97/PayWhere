class Restaurant {
    private String name;
    private String unitNumber;

    Restaurant (String name, String unitNumber) {
        this.name = name;
        this.unitNumber = unitNumber;
    }

    public void printRest() {
        System.out.println("        \"" + name + "\" : {");
        System.out.println("            \"Name\" : " + "\"" + name + "\",");
        System.out.println("            \"Unit Number\" : " + "\"" + unitNumber+ "\",");
        System.out.println("            \"Payment\" : " + "\"" + "\"");
        System.out.println("        " + "},");
    }
    
    public void printRestLast() {
        System.out.println("        \"" + name + "\" : {");
        System.out.println("            \"Name\" : " + "\"" + name + "\",");
        System.out.println("            \"Unit Number\" : " + "\"" + unitNumber + "\",");
        System.out.println("            \"Payment\" : " + "\"" + "\"");
        System.out.println("        " + "}");
    }
}