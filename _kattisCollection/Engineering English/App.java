import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            for (String string : input) {
                if (!set.contains(string.toLowerCase())) {
                    set.add(string.toLowerCase());
                    System.out.print(string + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
