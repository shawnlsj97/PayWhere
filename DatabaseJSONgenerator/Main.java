/*
This programme generates a JSON file for the dining outlets in malls.
We have:
- mall
    - restaurant
        - name
        - unit number
        - mobile payments accepted (currently Dash, Grab, Nets)
        - URL for icon on Firebase

Input format:
mall name
# of dining outlets in mall
outlet name, unit number
*/

import java.util.*;
import java.io.*;

public class Main {

    public static ArrayList<String> dashArray = new ArrayList<>();;
    public static ArrayList<String> grabArray = new ArrayList<>();;
    public static ArrayList<String> netsArray = new ArrayList<>();

    public static void readDashMerchants(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            dashArray.add(sc.nextLine());
        }
        sc.close();
    }

    public static void readGrabMerchants(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            grabArray.add(sc.nextLine());
        }
        sc.close();
    }

    public static void readNetsMerchants(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            netsArray.add(sc.nextLine());
        }
        sc.close();
    }

    public static void main (String[] args) {
        try {
            readDashMerchants("MobileWallets/dash.txt");
            readGrabMerchants("MobileWallets/grabpay.txt");
            readNetsMerchants("MobileWallets/nets.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Scanner sc = new Scanner(System.in);
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
        sc.close();
        System.out.println("}");
        
    }
}
