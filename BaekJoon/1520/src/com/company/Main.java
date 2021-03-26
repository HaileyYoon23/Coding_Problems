package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int height, width;
    public static int[][] matrix;
    public static long[][] dp;
    public static int[] dirH = {-1, 1, 0, 0};
    public static int[] dirW = {0, 0, -1, 1};
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        StringTokenizer st;
        height = Integer.parseInt(info[0]);
        width = Integer.parseInt(info[1]);
        matrix = new int[height+2][width+2];
        dp = new long[height+2][width+2];
        visited = new boolean[height+2][width+2];

        for(int i = 1; i <= height; i++) {
            Arrays.fill(dp[i],-1);
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= width; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = 1;
        System.out.println(findDP(height,width));

    }
    public static long findDP(int hIdx, int wIdx) {
        if(hIdx <= 0 || hIdx > height || wIdx <= 0 || wIdx > wIdx) return 0;
        int curHeight = matrix[hIdx][wIdx];
        dp[hIdx][wIdx] = 0;
        for(int i = 0; i < 4; i++) {
            int tempHIdx = hIdx + dirH[i];
            int tempWIdx = wIdx + dirW[i];
            if(curHeight < matrix[tempHIdx][tempWIdx]) {
                long tempDP;
                if(dp[tempHIdx][tempWIdx] == -1 && !visited[tempHIdx][tempWIdx]) {
                    visited[tempHIdx][tempWIdx] = true;
                    tempDP = findDP(tempHIdx,tempWIdx);
                    visited[tempHIdx][tempWIdx] = false;
                } else {
                    tempDP = dp[tempHIdx][tempWIdx];
                }
                dp[hIdx][wIdx] += tempDP;
            }
        }
        if(dp[hIdx][wIdx] == -1) return 0;
        return dp[hIdx][wIdx];
    }
}
