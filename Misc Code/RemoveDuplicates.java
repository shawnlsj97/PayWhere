import java.util.Scanner;
import java.util.ArrayList;

/**
 * This programme removes duplicate names.
 */
public class RemoveDuplicates {

    /**
     * Takes in a list of names that might contain duplicates, to be removed.
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nameArray = new ArrayList<>();

        while (sc.hasNext()) {
            String currName = sc.nextLine();
            Boolean duplicateFlag = false;
            for (String name : nameArray) {
                if (currName.compareToIgnoreCase(name) == 0) {
                    duplicateFlag = true;
                }
            }
            if (!duplicateFlag) {
                nameArray.add(currName);
            }
        }

        for (String name : nameArray) {
            System.out.println(name);
        }
    }
}
