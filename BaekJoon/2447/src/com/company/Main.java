package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                starPrint(i,j,N);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    public static void starPrint(int i, int j, int n) {
        if((i/n)%3 == 1 && (j/n)%3==1) {
            sb.append(" ");
        } else {
            if(n/3 == 0) {
                sb.append("*");
            } else {
                starPrint(i,j,n/3);
            }
        }
    }
}
