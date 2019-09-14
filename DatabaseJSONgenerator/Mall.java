/**
 * A class representing the malls supported by PayWhere.
 */
public class Mall {

    private String name;
    public Restaurant[] restArray;
    public static Mall[] mallArray;

    /**
     * Creates a Mall object with the mall name and restaurants it contains.
     * 
     * @param name Name of this mall.
     * @param numRest Number of restaurants in this mall.
     */
    public Mall(String name, int numRest) {
        this.name = name;
        this.restArray = new Restaurant[numRest];
    }

    public String getName() {
        return name;
    }

    /**
     * Closes this mall entry in the JSON file with a curly brace and a comma if there are more malls after.
     */
    public static void printMallClose() {
        System.out.println("    },");
    }

    /**
     * Closes this mall entry in the JSON file with just a curly brace if it is the last mall. 
     */
    public static void printMallCloseLast() {
        System.out.println("    }");
    }
}
