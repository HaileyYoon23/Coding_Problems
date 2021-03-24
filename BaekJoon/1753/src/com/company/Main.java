package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[][] matrix;
    public static int[] distance;
    public static int INF = Integer.MAX_VALUE;
    public static int N;
    public static boolean checked[];
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String[] lenInfo = br.readLine().split(" ");
        N = Integer.parseInt(lenInfo[0]);
        int M = Integer.parseInt(lenInfo[1]);
        int startPoint = Integer.parseInt(br.readLine());
        distance = new int[N];
        Arrays.fill(distance, INF);
        matrix = new int[N+1][N+1];
        checked = new boolean[N+1];
        for(int m = 0; m < M; m++) {
            String[] info = br.readLine().split(" ");
            int s = Integer.parseInt(info[0]);
            int e = Integer.parseInt(info[1]);
            int d = Integer.parseInt(info[2]);
            matrix[s][e] = d;
        }
        distance[startPoint-1] = 0;
        dijkstra();
        System.out.println(Arrays.toString(distance));
    }
    public static void dijkstra() {
        for(int i = 0; i < N-1; i++) {
            int min = INF;
            int index = -1;
            for(int j = 0; j < N; j++) {
                if(!checked[j] && min > distance[j]) {
                    index = j;
                    min = distance[j];
                }
            }
            for(int j = 0; j < N; j++) {
                if(!checked[j] && matrix[index][j] != 0) {
                    distance[j] = Integer.min(distance[j], distance[index]+matrix[index][j]);
                }
            }
            checked[index] = true;
        }
    }
}
