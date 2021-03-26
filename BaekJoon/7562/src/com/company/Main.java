package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int N;
    public static int startI, startJ, endI, endJ;
    public static int[] dirI = {2,1,-1,-2,-2,-1,1,2};
    public static int[] dirJ = {1,2,2,1,-1,-2,-2,-1};
    public static boolean[][] visited;
    public static Queue<Point> queue;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            queue = new LinkedList<>();
            visited = new boolean[N+2][N+2];
            String[] input1 = br.readLine().split(" ");
            String[] input2 = br.readLine().split(" ");
            startI = Integer.parseInt(input1[0]) + 1;
            startJ = Integer.parseInt(input1[1]) + 1;
            endI = Integer.parseInt(input2[0]) + 1;
            endJ = Integer.parseInt(input2[1]) + 1;
            BFS(startI, startJ,0);

        }
        System.out.println(sb);
    }
    public static void BFS(int i, int j, int c) {
        queue.add(new Point(i,j,c));
        if(i == endI && j == endJ) {
            sb.append(0+"\n");
            return;
        }
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            Point node = queue.poll();
            for(int d = 0; d < 8; d++) {
                int tempI = node.i + dirI[d];
                int tempJ = node.j + dirJ[d];
                int count = node.count;
                if(tempI >= 1 && tempI <= N && tempJ >= 1 && tempJ <= N
                && !visited[tempI][tempJ]) {
                    queue.add(new Point(tempI, tempJ,count+1));
                    visited[tempI][tempJ] = true;
                }
                if(tempI == endI && tempJ == endJ) {
                    sb.append(count+1+"\n");
                    return;
                }
            }
        }
    }
}

class Point {
    int i;
    int j;
    int count;
    Point(int i, int j, int c) {
        this.i = i;
        this.j = j;
        this.count = c;
    }
}
