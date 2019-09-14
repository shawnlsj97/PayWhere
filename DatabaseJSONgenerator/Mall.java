class Mall {
    private String name;
    public Restaurant[] restArray;
    public static Mall[] mallArray;

    Mall(String name, int numRest) {
        this.name = name;
        this.restArray = new Restaurant[numRest];
    }

    public String getName() {
        return name;
    }
    
    public static void printMallClose() {
        System.out.println("    },");
    }

    public static void printMallCloseLast() {
        System.out.println("    }");
    }
}
