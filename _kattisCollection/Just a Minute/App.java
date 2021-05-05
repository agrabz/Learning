
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfTests = sc.nextInt();

        double displayedTime_Sum = 0;
        double actualWaitedTime_Sum = 0;
        
        Double result;

        for (int i = 0; i < numOfTests; i++) {
            double displayedTime_InMin = sc.nextDouble();
            double actualWaitedTime_InSec = sc.nextDouble();

            displayedTime_Sum += displayedTime_InMin * 60;
            actualWaitedTime_Sum += actualWaitedTime_InSec;
        }

        result = BigDecimal.valueOf(actualWaitedTime_Sum / displayedTime_Sum).setScale(9, RoundingMode.HALF_UP).doubleValue();

        if (result > 1) {
            System.out.println(result);
        } else {
            System.out.println("measurement error");
        }

    }

}
