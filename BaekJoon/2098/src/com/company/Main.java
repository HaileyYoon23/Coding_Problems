package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int[] tsp = new int[1 << 16];
    public static int N;
    public static int[][] matrix;
    public static int[][] DP;
    public static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N+1][N+1];
        DP = new int[(1 << N)][N+1];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = TSP(0,0);
        if(result == INF) System.out.println(-1);
        else System.out.println(result);
    }
    public static int TSP(int visitBitMask, int nowIndex) {
        visitBitMask |= (1 << nowIndex);        // 현재 도시 추가
        if(visitBitMask == ((1 <<N) - 1)) {       // 모든 도시 지난경우
            if(matrix[nowIndex][0] > 0) {
                return matrix[nowIndex][0];
            }
            return INF;
        }
        if(DP[visitBitMask][nowIndex] > 0) return DP[visitBitMask][nowIndex];
        DP[visitBitMask][nowIndex] = INF;
        for(int i = 0; i < N; i++) {
            if(i != nowIndex && (visitBitMask & (1 << i)) == 0 && matrix[nowIndex][i] > 0) {
                int temp = TSP(visitBitMask,i) + matrix[nowIndex][i];
                if(DP[visitBitMask][nowIndex] > temp) {
                    DP[visitBitMask][nowIndex] = temp;
                }
            }
        }
        return DP[visitBitMask][nowIndex];
    }
}
