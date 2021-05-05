import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int easy = sc.nextInt();
        int medium = sc.nextInt();
        int hard = sc.nextInt();
        int allInput = sc.nextInt();
        int allProvided = easy + medium + hard;
        
        if (easy != 0 && medium != 0 && hard != 0 && allInput <= allProvided && allInput >= 3) {
            System.out.println("YES");
        } else
            System.out.println("NO");

    }

}
