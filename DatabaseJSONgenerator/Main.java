/*
Input format:
# num of Dash merchants
dash merchants...
# num of malls
mall name
# num of restaurants
restaurant names...
mall name
# num of restaurants
restaurant names...
...
*/

import java.util.*;

public class Main {

    public static String[] dashArray;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int numDash = Integer.parseInt(sc.nextLine());
        dashArray = new String[numDash];
        for (int i = 0; i < numDash; i++) {
            String currMerchant = sc.nextLine();
            dashArray[i] = currMerchant;
        }
        System.out.println("{");
        int numMalls = Integer.parseInt(sc.nextLine());
        Mall.mallArray = new Mall[numMalls];

        for (int i = 0; i < numMalls; i++) {
            String mallName = sc.nextLine();
            System.out.println("    \"" + mallName + "\" : {");
            int numRest = Integer.parseInt(sc.nextLine());
            Mall.mallArray[i] = new Mall(mallName, numRest);

            for (int j = 0; j < numRest; j++) {
                String currLine = sc.nextLine();
                String[] currArray = currLine.split(", ");
                Mall.mallArray[i].restArray[j] = new Restaurant(currArray[0], currArray[1]);
                if (j == numRest - 1) {
                    Mall.mallArray[i].restArray[j].printRestLast();
                } else {
                    Mall.mallArray[i].restArray[j].printRest();
                }
            }
            if (i == numMalls - 1) {
                Mall.printMallCloseLast();
            } else {
                Mall.printMallClose();
            }
        }
        System.out.println("}");
    }
}
