package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static ArrayList<Integer>[] arr;
    public static int[] result;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        result = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int child = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            arr[child].add(parent);
        }
        for(int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            numberOfChild(i);
        }
        int max = 0;
        for(int i = 1; i <= N; i++) {
            if(max < result[i]) {
                max = result[i];
            }
        }
        for(int i = 1; i <= N; i++) {
            if(result[i] == max) sb.append(i + " ");
        }
        System.out.println(sb);
    }
    public static void numberOfChild(int start) {
        visited[start] = true;
        for(int n: arr[start]) {
            if(!visited[n]) {
                result[n]++;
                numberOfChild(n);
            }
        }
    }
}