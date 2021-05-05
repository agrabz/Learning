import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNums = br.readLine().split(" ");
        String inputOrder = br.readLine();

        List<Integer> numList = new ArrayList<>();
        numList.add(Integer.parseInt(inputNums[0]));
        numList.add(Integer.parseInt(inputNums[1]));
        numList.add(Integer.parseInt(inputNums[2]));
        Collections.sort(numList);

        for (int i = 0; i < inputOrder.length(); i++) {
            switch (inputOrder.charAt(i)) {
                case 'A':
                    System.out.print(numList.get(0)+ " ");
                    break;
                case 'B':
                    System.out.print(numList.get(1) + " ");
                    break;
                case 'C':
                    System.out.print(numList.get(2) + " ");
                    break;
                default:
                    break;
            }
        }
        
        
        
    }

}
