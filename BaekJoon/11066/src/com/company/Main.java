package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] arr;
    public static int[] sum;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            sum = new int[N+1];
            dp = new int[N+1][N+1];
            String[] inputs = br.readLine().split(" ");
            for(int a = 0; a < N; a++) {
                int num = Integer.parseInt(inputs[a]);
                sum[a+1] = sum[a] + num;
            }
            for(int i = 1; i < N; i++) {
                for(int x = 1; x <= N - i; x++) {

                }
            }
        }
    }
}
