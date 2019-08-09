/*

Given lines of outlet names, this programme will generate the code that adds the outlet name to the key of HashMap imgHash.

Value (icon URL) will be added manually.

*/

import java.util.*;

public class MakeHash {

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