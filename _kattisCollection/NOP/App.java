import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String machineCode = br.readLine();
        int counter = 0;
        for (int i = 0; i < machineCode.length(); i++) {
            if (Character.isUpperCase(machineCode.charAt(i))) {
                counter += (4 - (i+counter)%4)%4;
            }
        }
        System.out.println(counter);

    }
}
