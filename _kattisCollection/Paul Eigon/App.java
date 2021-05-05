import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int rounds = Integer.valueOf(input[0]);
        int one = Integer.valueOf(input[1]);
        int two = Integer.valueOf(input[2]);
        
        String result = ((two+one)/rounds) % 2 == 0 ? "paul" : "opponent";
        System.out.println(result);
        

    }

}
