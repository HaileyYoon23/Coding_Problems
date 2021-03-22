package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static int a;
    public static int b;
    public static int c;
    public static long[][][] dp = new long[21][21][21];
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= 20; i ++) {
            for(int j = 0; j <= 20; j++) {
                for(int k = 0; k <= 20; k++) {
                    if(i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 1;
                        continue;
                    }
                    if(i < j && j < k) {
                        dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
                    } else {
                        dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
                    }
                }
            }
        }
        while(!input.equals("-1 -1 -1")) {
            String[] inputList = input.split(" ");
            a = Integer.parseInt(inputList[0]);
            b = Integer.parseInt(inputList[1]);
            c = Integer.parseInt(inputList[2]);

            sb.append(String.format("w(%d, %d, %d) = %d\n",a,b,c,findDPResult(a,b,c)));

            input = br.readLine();

        }
        System.out.println(sb);
    }
    public static long findDPResult(int A, int B, int C) {
        if(A <= 0 || B <= 0 || C <= 0) {
            A = 0;
            B = 0;
            C = 0;
        }
        if(A > 20 || B > 20 || C > 20) {
            A = 20;
            B = 20;
            C = 20;
        }
        return dp[A][B][C];
    }
}
