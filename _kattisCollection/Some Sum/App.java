
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        int factor = input % 4;
        
        switch (factor) {
            case 1:
                System.out.println("Either");
                break;
            case 2:
                System.out.println("Odd");
                break;
            case 3:
                System.out.println("Either");
                break;
            case 0:
                System.out.println("Even");
                break;
        }

    }

}
