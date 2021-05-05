import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 15; i++) {
            int sweet = sc.nextInt();
            int sour = sc.nextInt();

            if (sweet + sour == 13) {
                System.out.println("Never speak again.");
                continue;
            } else if (sweet == 0 && sour == 0) {
                break;
            } else if (sweet > sour) {
                System.out.println("To the convention.");
                continue;
            } else if (sweet < sour) {
                System.out.println("Left beehind.");
                continue;
            }
            System.out.println("Undecided.");

        }

    }

}
