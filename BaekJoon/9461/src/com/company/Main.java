package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static long[] dp = new long [101];
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4; i <= 100; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }
        int T = Integer.parseInt(br.readLine());
        while((T--) > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]+"\n");
        }
        System.out.println(sb);
    }
}
