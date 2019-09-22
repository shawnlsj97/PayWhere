import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.*;

public class Reader {

    public static ArrayList<String> dashArray = new ArrayList<>();;
    public static ArrayList<GrabMerchant> grabArray = new ArrayList<>();;
    public static ArrayList<String> netsArray = new ArrayList<>();
    public static final String dashFilePath = "MobileWallets/dash.txt";
    public static final String grabFilePath = "MobileWallets/grabpay_merchants.txt";
    public static final String netsFilePath = "MobileWallets/nets.txt";
    public static final String mallFilePath = "Malls";


    /**
     * Reads all the restaurants listed under the mall.
     */
    public static void readMalls() {
        for (String mallFilePath : getMallFilePaths()) {
            File f = new File(mallFilePath);
            if (f.getName().toLowerCase().contains("ds_store")) {
                continue;
            }
            String mallName = getMallName(f);
            Mall currMall = new Mall(mallName);
            Mall.addMall(currMall); // add the mall to the list of all malls
            try {
                Scanner sc = new Scanner(f);
                while (sc.hasNextLine()) {
                    String currLine = sc.nextLine();
                    String[] currArray = currLine.split(", ");
                    Restaurant currRestaurant = new Restaurant(currArray[0], currArray[1], currMall);
                    currMall.addRestaurant(currRestaurant);
                }
                sc.close();
            } catch(FileNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Removes the extension from the file name to get the mall name.
     *
     * @param  f File of the mall listing.
     * @return   Name of the mall.
     */
    private static String getMallName(File f) {
        String fileName = f.getName();
        int indexOfPeriod = fileName.lastIndexOf(".");
        String mallName = fileName.substring(0, indexOfPeriod);
        return mallName;
    }


    /**
     * Retrieves the individual file paths for all the mall .txt files in the Malls folder.
     *
     * @return List of the file paths.
     */
    private static ArrayList<String> getMallFilePaths() {
        ArrayList<String> mallFilePaths = new ArrayList<>();
        try {
            Stream<Path> paths = Files.walk(Paths.get(mallFilePath));
            paths
                .filter(Files::isRegularFile)
                .forEach(p -> mallFilePaths.add(p.toString()));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return mallFilePaths;
    }

    /**
     * Reads all the mobile payment merchants.
     */
    public static void readMerchants() {
        try {
            readDashMerchants(dashFilePath);
            readGrabMerchants(grabFilePath);
            readNetsMerchants(netsFilePath);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads and stores the Singtel Dash merchants.
     *
     * @param filePath File path of Singtel Dash merchants.
     * @throws FileNotFoundException If file cannot be found.
     */
    private static void readDashMerchants(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            dashArray.add(sc.nextLine());
        }
        sc.close();
    }

    /**
     * Reads and stores the GrabPay merchants.
     * @param filePath File path of GrabPay merchants.
     * @throws FileNotFoundException If file cannot be found.
     */
    private static void readGrabMerchants(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String currLine = sc.nextLine();
            String[] currArray = currLine.split(", ");
            GrabMerchant currMerchant = new GrabMerchant(currArray[0], currArray[1]);
            grabArray.add(currMerchant);
        }
        sc.close();
    }

    /**
     * Reads and stores the Nets QR merchants.
     * @param filePath File path of Nets QR merchants.
     * @throws FileNotFoundException If file cannot be found.
     */
    private static void readNetsMerchants(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            netsArray.add(sc.nextLine());
        }
        sc.close();
    }
}
