package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] arr = new boolean[1_000_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for(int i = 2; i <= end; i++) {
            int a = i * 2;
            while(a <= end) {
                arr[a] = true;
                a += i;
            }
        }
        for(int i = start; i <= end; i++) {
            if(arr[i] == false && i != 1) System.out.println(i);
        }
    }
}
