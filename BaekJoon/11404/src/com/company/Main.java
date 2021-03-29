package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[][] dist;
    public static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        dist = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            dist[start][end] = Integer.min(dist[start][end],length);
        }
        for(int i = 1; i <= N; i++) {
            dist[i][i] = 0;
        }
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(dist[i][k] == INF || dist[k][j] == INF) continue;
                    dist[i][j] = Integer.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(dist[i][j] == INF) sb.append(0 + " ");
                else sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
