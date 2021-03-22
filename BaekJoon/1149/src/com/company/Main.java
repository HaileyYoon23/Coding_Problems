package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static int[][] matrix;
    public static long[][] dp;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N+1][];
        dp = new long[N][3];
        for(int n = 0; n < N; n++) {
            matrix[n] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        dp[0][0] = matrix[0][0];
        dp[0][1] = matrix[0][1];
        dp[0][2] = matrix[0][2];

        for(int i = 1; i < N; i++) {
            dp[i][0] = Long.min(dp[i-1][1], dp[i-1][2]) + matrix[i][0];
            dp[i][1] = Long.min(dp[i-1][0], dp[i-1][2]) + matrix[i][1];
            dp[i][2] = Long.min(dp[i-1][0], dp[i-1][1]) + matrix[i][2];
        }
        System.out.println(Long.min(Long.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
    }
}
