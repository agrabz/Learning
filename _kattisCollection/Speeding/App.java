package com.sap.akos.kattisandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int[] times = new int[n];
        int[] distances = new int[n];
        int[] speeds = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int time = Integer.valueOf(input[0]);
            int distance = Integer.valueOf(input[1]);
            times[i] = time;
            distances[i] = distance;
            if (i != 0) {
                int speed = ((distances[i] - distances[i - 1]) / (times[i] - times[i - 1]));
                if (max < speed) {
                    max = speed;
                }
            }
        }
        System.out.println(max);

    }

}
