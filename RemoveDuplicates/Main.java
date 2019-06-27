/*
Dash merchants in .csv file with duplicates.
Programme to get only 1 of each store name.
*/

import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nameArray = new ArrayList<>();
        
        while (sc.hasNext()) {
            String currName = sc.nextLine();
            if (!nameArray.contains(currName)) {
                nameArray.add(currName);
            }
        }

        for (String name : nameArray) {
            System.out.println(name);
        }
    }
}
