import java.util.Scanner;
import java.util.ArrayList;

/**
 * This programme removes the parentheses and the words it contains at the end of a store name.
 * Eg. LiHo (Tampines Mall) would just be LiHo.
 */
public class RemoveBracket {

    /**
     * Takes in a list of store names with parentheses at the end to be removed.
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> merchantArray = new ArrayList<>();

        while (sc.hasNext()) {
            String currLine = sc.nextLine();
            String[] currArray = currLine.split(" \\(");
            merchantArray.add(currArray[0]);
        }

        for (String merchant : merchantArray) {
            System.out.println(merchant);
        }
    }
}
