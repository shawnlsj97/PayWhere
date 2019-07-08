import java.util.*;

public class Main {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String mallName = sc.nextLine();
        int numMalls = Integer.parseInt(sc.nextLine());
        System.out.println(mallName);
        System.out.println(numMalls);
        Restaurant.restArray = new Restaurant[numMalls];
        for (int i = 0; i < numMalls; i++) {
            String currLine = sc.nextLine();
            String[] currArray = currLine.split(", ");
            Restaurant currRest = new Restaurant(currArray[0], currArray[1], currArray[2]);
            Restaurant.restArray[i] = currRest;
        }
        for (Restaurant rest : Restaurant.restArray) {
            System.out.println(rest.toString());
        }
    }
}
