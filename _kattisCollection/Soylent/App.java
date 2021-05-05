import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        double[] results = new double[n];
        
        for (int i = 0; i < n; i++) {
            results[i] = Math.ceil(Double.valueOf(br.readLine())/400.0);
        }
        for (double result : results) {
            System.out.println((int) result);
        }

    }

}
