/*
This programme generates a JSON file for the dining outlets in malls.
We have:
- mall
    - restaurant
        - name
        - unit number
        - mobile payments accepted (currently Dash, Grab, Nets)
        - URL for icon on Firebase

General input format:
# of Dash merchants
Dash merchants
# of Grab merchants
Grab merchants
# of Nets merchants
Nets merchants
# of malls
[mall input]

Mall input format:
mall name
# of dining outlets in mall
outlet name, unit number
*/

import java.util.*;

public class Main {

    public static String[] dashArray;
    public static String[] grabArray;
    public static String[] netsArray;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int numDash = Integer.parseInt(sc.nextLine());
        dashArray = new String[numDash];
        for (int i = 0; i < numDash; i++) {
            String currMerchant = sc.nextLine();
            dashArray[i] = currMerchant;
        }

        int numGrab = Integer.parseInt(sc.nextLine());
        grabArray = new String[numGrab];
        for (int i = 0; i < numGrab; i++) {
            String currMerchant = sc.nextLine();
            grabArray[i] = currMerchant;
        }

        int numNets = Integer.parseInt(sc.nextLine());
        netsArray = new String[numNets];
        for (int i = 0; i < numNets; i++) {
            String currMerchant = sc.nextLine();
            netsArray[i] = currMerchant;
        }


        System.out.println("{");
        int numMalls = Integer.parseInt(sc.nextLine());
        Mall.mallArray = new Mall[numMalls];

        Icon.makeHash();

        for (int i = 0; i < numMalls; i++) {
            String mallName = sc.nextLine();
            System.out.println("    \"" + mallName + "\" : {");
            int numRest = Integer.parseInt(sc.nextLine());
            Mall currMall = new Mall(mallName, numRest);
            Mall.mallArray[i] = currMall;

            for (int j = 0; j < numRest; j++) {
                String currLine = sc.nextLine();
                String[] currArray = currLine.split(", ");
                Mall.mallArray[i].restArray[j] = new Restaurant(currArray[0], currArray[1], currMall);
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
