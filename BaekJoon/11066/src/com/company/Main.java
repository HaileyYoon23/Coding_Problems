package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] arr;
    public static int[] psum;
    public static int[][] dp;
    public static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            psum = new int[N+1];
            dp = new int[N+1][N+1];
            String[] inputs = br.readLine().split(" ");
            for(int a = 0; a < N; a++) {
                int num = Integer.parseInt(inputs[a]);
                arr[a+1] = num;
                psum[a+1] = psum[a] + num;
            }
            for(int len = 0; len <= N; len++) {
                for(int i = 1; i <= N-len; i++) {
                    if(len == 0) dp[i][i+len] = 0;
                    else if(len == 1) dp[i][i+1] = arr[i] + arr[i+1];
                    else findDP(i,i+len);
                }
            }
            sb.append(dp[1][N]+"\n");
        }
        System.out.println(sb);
    }
    public static void findDP(int start, int end) {
        int temp = Integer.MAX_VALUE;
        for(int k = start; k < end; k++) {
            temp = Integer.min(temp, dp[start][k] + dp[k+1][end]);
        }
        dp[start][end] = temp + psum[end] - psum[start-1];
    }
}
