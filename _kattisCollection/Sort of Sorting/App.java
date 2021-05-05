import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //letter - 'a' + 1
        while (true) {
            BinarySearchTree bst;
            int namesCount = Integer.parseInt(br.readLine());
            
            if (namesCount == 0) {
                break;
            }
            bst = new BinarySearchTree();

            for (int i = 0; i < namesCount; i++) {
                bst.insertData(br.readLine());
            }
            bst.traverse();
            System.out.println();
        }
    }

}
