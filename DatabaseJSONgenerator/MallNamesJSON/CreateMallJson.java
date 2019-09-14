import java.util.Scanner;
import java.util.ArrayList;

public class CreateMallJson {

    public static void print(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        print("    \"malls\" : {"); // does not print the opening curly braces of the JSON document
        ArrayList<String> mallNames = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            mallNames.add(sc.nextLine());
        }
        for (int i = 0; i < mallNames.size(); i++) {
            String currMall = mallNames.get(i);
            print("        \"" + currMall + "\" : {");
            print("            \"name\" : \"" + currMall + "\"");
            if (i == mallNames.size() - 1) {
                print("        }");
            } else {
                print("        },");
            }
        }
        print("    },");
    }
}