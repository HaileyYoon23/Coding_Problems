package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] arr = new boolean[10_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= 5_001; i++) {
            int a = i * 2;
            while(a <= 10_000) {
                arr[a] = true;
                a += i;
            }
        }
        int first = 0;
        int second = 0;
        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            for(int v = 2; v <= value/2; v++) {
                if(!arr[v] && !arr[value-v]) {
                    first = Integer.min(v, value - v);
                    second = Integer.max(v, value - v);
                }
            }
            sb.append(String.format("%d %d\n",first, second));
        }

        System.out.println(sb);

    }
}
