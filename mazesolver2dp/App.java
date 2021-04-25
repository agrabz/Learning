package com.sap.akos.udemydp.mazesolver2dp;

public class App {

    public static void main(String[] args) {

        int[][] mazeTable = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1}
        };
        
        Algorithm a = new Algorithm(mazeTable);
        a.solve();

    }

}
