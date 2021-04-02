package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] matrix;
    public static int[][] DP;
    public static int[] dirI = {-1,1,0,0};
    public static int[] dirJ = {0,0,-1,1};
    public static int maxDP = 0;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    matrix = new int[N][];
	    DP = new int[N][N];
	    for(int n = 0; n < N; n++) {
	        matrix[n] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(DP[i][j] == 0) DFS(i,j);
            }
        }
        System.out.println(maxDP);
    }
    public static int DFS(int indexI, int indexJ) {
        if(DP[indexI][indexJ] > 0) {
            return DP[indexI][indexJ];
        }
        boolean find = false;
        for(int i = 0; i < 4; i++) {
            int biggerI = indexI + dirI[i];
            int biggerJ = indexJ + dirJ[i];
            if(biggerI >= 0 && biggerI < N && biggerJ >= 0 && biggerJ < N) {
                if(matrix[indexI][indexJ] < matrix[biggerI][biggerJ]) {
                    find = true;
                    DP[indexI][indexJ] = Integer.max(DP[indexI][indexJ] ,DFS(biggerI,biggerJ) + 1);
                }
            }
        }
        if(!find) DP[indexI][indexJ] = 1;
        maxDP = Integer.max(maxDP, DP[indexI][indexJ]);
        return DP[indexI][indexJ];
    }
}
