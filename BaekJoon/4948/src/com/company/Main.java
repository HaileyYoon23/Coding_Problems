package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] arr = new boolean[247135];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= 123456; i++) {
            int a = i * 2;
            while(a <= 247134) {
                arr[a] = true;
                a += i;
            }
        }
        String input = br.readLine();
        while(!input.equals("0")) {
            int N = Integer.parseInt(input);
            int result = 0;
            for(int i = N+1; i <= N*2; i++) {
                if(arr[i] == false && i != 1) result++;
            }
            sb.append(result+"\n");
            input = br.readLine();
        }
        System.out.println(sb);

    }
}
