package com.sap.akos.kattisandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        
        //two Fibonaccis, but it's enough to count only b because a = previous b
        int b = 0;
        int a = 1;
        
        for (int i = 0; i < n; i++) {
            b = b + a;
            a = b - a;
        }
        System.out.println(a + " " + b);

        

    }

}
