
/*
Assume data is given in the format: 
mall name
restaurant name, unit number
restaurant name, unit number
restaurant name, unit number
.
.
.
restaurant name, unit number
restaurant name, unit number
*/

import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String mallName = sc.nextLine();
        System.out.println("{");
        System.out.println("    " + "\"" + mallName + "\" : {");
        ArrayList<Restaurant> restArray = new ArrayList<>();

        while (sc.hasNext()) {
            String currLine = sc.nextLine();
            String[] currArray = currLine.split(", ");
            Restaurant currRest = new Restaurant(currArray[0], currArray[1]);
            restArray.add(currRest);
        }

        for (int i = 0; i < restArray.size(); i++) {
            if (i == (restArray.size() - 1)) {
                restArray.get(i).printRestLast();
            } else {
                restArray.get(i).printRest();
            }
        }

        System.out.println("    }");
        System.out.println("}");
    }
}
