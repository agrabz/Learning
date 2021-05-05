package com.sap.akos.kattisandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        long lightOne = Long.valueOf(input[0]);
        long lightTwo = Long.valueOf(input[1]);
        long maxTime = Long.valueOf(input[2]);
        
        for (int i = 1; i <= maxTime; i++) {
            if (i % lightOne == 0 &&
                    i % lightTwo == 0) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");        
    }
    
}
