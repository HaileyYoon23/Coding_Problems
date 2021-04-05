package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static long result = 0;
    public static long[] dp = new long[31];
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= 30; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        while(!input.equals("0")) {
            int N = Integer.parseInt(input);
            sb.append(dp[N] + "\n");
            input = br.readLine();
        }
        System.out.println(sb);
    }

}
