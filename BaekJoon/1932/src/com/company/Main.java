package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;

public class Main {
    public static int[][] dp;
    public static int[][] matrix;
    public static int maxValue = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1][N+1];
        matrix = new int[N][];
        for(int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        dp[1][1] = matrix[0][0];
        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                if(j == 1) {
                    dp[i][j] = dp[i-1][1] + matrix[i-1][0];
                } else if(j == i) {
                    dp[i][j] = dp[i-1][j-1] + matrix[i-1][j-1];
                } else {
                    dp[i][j] = Integer.max(dp[i-1][j-1] + matrix[i-1][j-1], dp[i-1][j] + matrix[i-1][j-1]);
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            maxValue = Integer.max(maxValue, dp[N][i]);
        }
        System.out.println(maxValue);
    }
}
