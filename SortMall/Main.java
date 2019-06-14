import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Mall> mallList = new ArrayList<>();
        while (sc.hasNextLine()) {
            String name = sc.nextLine();
            Mall currMall = new Mall(name);
            mallList.add(currMall);
        }
        Collections.sort(mallList, new MallComparator());
        for (Mall mall : mallList ) {
            System.out.println(mall.name);
        }
    }
}