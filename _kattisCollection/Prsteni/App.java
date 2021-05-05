import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        String[] input = br.readLine().split(" ");
        int firstInput = Integer.valueOf(input[0]);

        for (int i = 1; i < input.length; i++) { //from one because 1st is off
            int currentInput = Integer.valueOf(input[i]);
            if (firstInput % currentInput == 0) {
                System.out.println(firstInput / currentInput + "/" + 1);
            } else {
                for (int j = currentInput; j > 0; j--) {
                    if (firstInput % j == 0 && currentInput % j == 0) {
                        System.out.println(firstInput / j + "/" + currentInput / j);
                        break;
                    }
                }
            }

        }

    }

}
