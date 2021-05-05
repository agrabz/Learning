import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int result = 0;
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.valueOf(br.readLine());
        }
        if (n % 2 != 0) {
            System.out.println("still running");
        } else {
            for (int i = 0; i < input.length; i++) {
               if (i % 2 == 0) continue;
               result += (input[i] - input[i-1]);
            }
            System.out.println(result);
        }

    }

}
