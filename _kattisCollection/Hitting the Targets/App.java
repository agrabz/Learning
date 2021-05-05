import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> Rectangles = new ArrayList<>();
        ArrayList<Integer> Circles = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int targets = Integer.valueOf(br.readLine());

        for (int i = 0; i < targets; i++) {
            String[] shapeAttributes = br.readLine().split(" ");
            String shapeName = shapeAttributes[0];
            if (shapeName.equals("rectangle")) {
                for (int j = 1; j < shapeAttributes.length; j++) {
                    Rectangles.add(Integer.parseInt(shapeAttributes[j]));
                }
            } else {
                for (int j = 1; j < shapeAttributes.length; j++) {
                    Circles.add(Integer.parseInt(shapeAttributes[j]));
                }
            }
        }
//        System.out.println("Rectangles");
//        Rectangles.forEach(r -> System.out.println(r));
//        
//        System.out.println("Circles");
//        Circles.forEach(r -> System.out.println(r));

        int shotsTaken = Integer.parseInt(br.readLine());

        for (int i = 0; i < shotsTaken; i++) {
            String[] shotCoordinates = br.readLine().split(" ");
            int shotX = Integer.parseInt(shotCoordinates[0]);
            int shotY = Integer.parseInt(shotCoordinates[1]);
            int targetHit = 0;
//            System.out.println("ShotX: " + shotX + " |ShotY: " + shotY);

            for (int j = 0; j < Rectangles.size(); j += 4) {
                if (shotX >= Rectangles.get(j) && shotX <= Rectangles.get(j + 2)
                        && shotY >= Rectangles.get(j + 1) && shotY <= Rectangles.get(j + 3)) {
                    targetHit++;
                }
            }

            //r^2 = (x - u)^2 + (y - v)^2 --> x,y are shot coordinates,
            // u,v are circle central points
            for (int j = 0; j < Circles.size(); j += 3) {
                if (Circles.get(j + 2)
                        >= Math.sqrt(
                                Math.pow(shotX - Circles.get(j), 2)
                                + Math.pow(shotY - Circles.get(j + 1), 2))) {
                    targetHit++;
                }
            }
            System.out.println(targetHit);
        }

    }

}
