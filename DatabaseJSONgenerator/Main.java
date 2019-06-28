/*
Input format:
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
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
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
