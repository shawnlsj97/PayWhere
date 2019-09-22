import java.util.*;
import java.io.*;

/**
 * Generates a JSON file of the malls supported by PayWhere.
 */
public class Main {

    /**
     * Main logic of the Database JSON Generator.
     *
     * @param args Unused.
     */
    public static void main (String[] args) {
        Icon.makeHash();
        Reader.readMerchants();
        Reader.readMalls();
        System.out.println("{");
        for (int i = 0; i < Mall.getMalls().size(); i++) {
            Mall mall = Mall.getMalls().get(i);
            System.out.println(mall.getOpening());
            System.out.println(mall.getRestaurantEntries());
            System.out.println(mall.getClose(i));
        }
        System.out.println("}");
    }
}
