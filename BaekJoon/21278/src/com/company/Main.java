package com.company;

import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static final int INF = Integer.MAX_VALUE / 2;
    private static int[][] minLength;
    private static int minSum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
	    N = info[0]; M = info[1];
	    int resultI = 1; int resultJ = 2;
	    minLength = new int[N+2][N+2];
	    for(int[] row: minLength) {
	        Arrays.fill(row, INF);
        }
	    for(int i = 1; i <= N; i++) {
	        minLength[i][i] = 0;
        }
	    for(int i = 0; i < M; i++) {
	        int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
	        minLength[inputs[0]][inputs[1]] = 1;
	        minLength[inputs[1]][inputs[0]] = 1;
        }
	    for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    int temp = minLength[i][k] + minLength[k][j];
                    if(minLength[i][j] > temp) {
                        minLength[i][j] = temp;
                        minLength[j][i] = temp;
                    }
                }
            }
        }
	    for(int i = 1; i < N; i++) {
	        for(int j = i+1; j <= N; j++) {
	            int temp = 0;
	            for(int n = 1; n <= N; n++) {
	                temp += Integer.min(minLength[i][n], minLength[j][n]);
                }
	            if(minSum > temp) {
	                resultI = i;
	                resultJ = j;
	                minSum = temp;
                }
            }
        }
	    System.out.println(String.format("%d %d %d",resultI, resultJ, minSum * 2));
    }
}
