import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Boolean> results = new ArrayList<>();

        //until: 0
        while (true) {    
            //3 2
            String[] coursesAndCategories = br.readLine().split(" ");
            if (coursesAndCategories[0].equals("0")) {
                break;
            }
            int coursesCount = Integer.parseInt(coursesAndCategories[0]);
            int categoriesCount = Integer.parseInt(coursesAndCategories[1]);
            if (categoriesCount == 0) { //ARE no categories (if "chosen" - this bad)
                System.out.println("yes");
                continue;
            }
            
            //0123 9876 2222
            List<String> coursesTakenList = Arrays.asList(br.readLine().split(" "));
            boolean overallOk = true;
            for (int i = 0; i < categoriesCount; i++) {
                //2 1 8888 2222
                //3 2 9876 2222 7654
                String[] courseDetails = br.readLine().split(" ");
                int coursesInCategory = Integer.parseInt(courseDetails[0]);
                int minCoursesToTakeInCategory = Integer.parseInt(courseDetails[1]);
                boolean ok = false;
                int counter = 0;
                for (int j = 2; j < courseDetails.length; j++) {
                    if (coursesTakenList.contains(courseDetails[j]) ) {
                        if (++counter >= minCoursesToTakeInCategory) {
                            ok = true;
                            break;
                        }
                    }
                }
                overallOk &= ok;
            }
            results.add(overallOk);
        }
        for (Boolean result : results) {
            if (result) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
