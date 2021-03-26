package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static long[][] dp;
    public static int N = 0;
    public static Info[] arr;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new Info[N + 1];
        dp = new long[N+1][N+1];
        for(int i = 0; i <N; i++) {
            String[] inputs = br.readLine().split(" ");
            int f = Integer.parseInt(inputs[0]);
            int s = Integer.parseInt(inputs[1]);
            arr[i+1] = new Info(f,s);
        }
        for(int len = 1; len <= N-1; len++) {
            for(int i = 1; i <= N - len; i++) {
                if(len == 1) {
                    dp[i][i+len] = arr[i].f * arr[i].s * arr[i+len].s;
                } else {
                    findDP(i,i+len);
                }
            }
        }
        System.out.println(dp[1][N]);

    }
    public static void findDP(int start, int end) {     // end - start >=
        int len = end - start;
        long min = Long.min(dp[start][end-1] + arr[start].f * arr[end].f * arr[end].s,
                dp[start+1][end] + arr[start].f * arr[start].s * arr[end].s);
        for(int i = 1; i <= len-1; i++) {
            min = Long.min(min,dp[start][start+i] + dp[start+i+1][end] +
                    arr[start].f * arr[start+i].s * arr[end].s);
        }
        dp[start][end] = min;
    }
}
class Info {
    int f;
    int s;
    Info(int f, int s) {
        this.f = f;
        this.s = s;
    }
}
