import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstInput = sc.nextInt();
        int secondInput = sc.nextInt();

        int longer = firstInput > secondInput
                ? String.valueOf(firstInput).length()
                : String.valueOf(secondInput).length();

        int firstResult = 0;
        int secondResult = 0;

        int firstFactor = 1;
        int secondFactor = 1;

        boolean firstIsYoda = true;
        boolean secondIsYoda = true;

        for (int i = 0; i < longer; i++) {
            if (firstInput % 10 > secondInput % 10) {
                firstResult += (firstInput % 10) * firstFactor;
                firstInput /= 10;

                secondInput /= 10;
                firstFactor *= 10;

                firstIsYoda = false;
            } else if (firstInput % 10 < secondInput % 10) {
                secondResult += (secondInput % 10) * secondFactor;
                firstInput /= 10;

                secondInput /= 10;
                secondFactor *= 10;

                secondIsYoda = false;
            } else {
                firstResult += (firstInput % 10) * firstFactor;
                firstInput /= 10;

                secondResult += (secondInput % 10) * secondFactor;
                secondInput /= 10;

                firstFactor *= 10;
                secondFactor *= 10;

                firstIsYoda = false;
                secondIsYoda = false;

            }
        }
        if (firstIsYoda) {
            System.out.println("YODA");
        } else {
            System.out.println(firstResult);
        }
        if (secondIsYoda) {
            System.out.println("YODA");
        } else {
            System.out.println(secondResult);
        }
    }

}
