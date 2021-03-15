package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testInfo = br.readLine().split(" ");
        int N = Integer.valueOf(testInfo[0]);
        int M = Integer.valueOf(testInfo[1]);
        int V = Integer.valueOf(testInfo[2]);
        int[][] matrix = new int[N+1][N+1];
        int[] dfsVisited = new int[N+1];
        int[] bfsVisited = new int[N+1];
        int nextPoint = 0;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        StringBuilder dfs = new StringBuilder();
        StringBuilder bfs = new StringBuilder();
        for(int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            matrix[Integer.valueOf(line[0])][Integer.valueOf(line[1])] = 1;
            matrix[Integer.valueOf(line[1])][Integer.valueOf(line[0])] = 1;
        }

        // DFS
        stack.add(V);
        dfsVisited[V] = 1;
        boolean isEnd = false;
        do {
            nextPoint = stack.pop();
            for(int i = 1; i <= N; i++) {
                if(matrix[nextPoint][i] != 0 && dfsVisited[i] != 1) {
                    isEnd = false;
                    stack.add(i);
                    break;
                }
                isEnd = true;
            }
            dfs.append(nextPoint+" ");
            dfsVisited[nextPoint] = 1;
        }while(!isEnd);
        // BFS
        queue.add(V);
        bfsVisited[V] = 1;
        isEnd = false;
        do {
            nextPoint = queue.poll();
            isEnd = true;
            for(int i = 1; i <= N; i++) {
                if(matrix[nextPoint][i] != 0 && bfsVisited[i] != 1) {
                    isEnd = false;
                    queue.add(i);
                }
            }
            bfs.append(nextPoint+" ");
            bfsVisited[nextPoint] = 1;
        } while(!isEnd);

        System.out.println(dfs);
        System.out.println(bfs);

    }
}
