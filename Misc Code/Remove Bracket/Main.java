import java.util.*;

public class Main {

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