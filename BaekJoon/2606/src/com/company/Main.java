package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static int[][] matrix;
    public static boolean[] isVisited;
    public static StringBuilder bfs;
    public static int N;
    public static int result;

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());

        bfs = new StringBuilder();
        matrix = new int[N+1][N+1];
        isVisited = new boolean[N+1];
        result = 0;

        for(int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.valueOf(line[0]);
            int b = Integer.valueOf(line[1]);
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }
        BFS(1);
        System.out.println(result-1);

    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int nextIdx = queue.poll();
            bfs.append(nextIdx + " ");
            result += 1;

            for(int i = 1; i < isVisited.length; i++)  {
                if(i != nextIdx && isVisited[i] == false && matrix[nextIdx][i] == 1) {
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }
}
