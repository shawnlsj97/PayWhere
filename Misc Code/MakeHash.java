import java.util.ArrayList;
import java.util.Scanner;

/**
 * This programme generates the method call to insert store name keys and image URL entries.
 */
public class MakeHash {

    /**
     * Takes in a a list of store names.
     * Image URL is inserted manually.
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();
        while (sc.hasNextLine()) {
            String curr = sc.nextLine();
            names.add(curr);
            output.add("        imgHash.put(\"" + curr + "\", \"\");");
        }
        for (String i : output) {
            System.out.println(i);
        }
    }
}
