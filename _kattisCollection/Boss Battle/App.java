import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfPillars = Integer.parseInt(br.readLine());
        if (numOfPillars <=3 ) {
            System.out.println("1");
            return;
        }
        System.out.println(numOfPillars-2);
        
    }

}
