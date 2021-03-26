package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int[] dirI = {0,0,0,0,-1,1};
    public static int[] dirJ = {0,0,-1,1,0,0};
    public static int[] dirK = {1,-1,0,0,0,0};
    public static int[][][] matrix;
    public static int totalCellNum;
    public static int wallCellNum = 0;
    public static int tomatoCellNum = 0;
    public static boolean[][][] isVisited;
    public static int N,M,H;
    public static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        H = Integer.parseInt(info[2]);
        totalCellNum = N * M * H;
        matrix = new int[H+2][M+2][N+2];
        isVisited = new boolean[H+2][M+2][N+2];
        for(int k = 1; k <= H; k++) {
            for(int i = 1; i <= M; i++) {
                String[] input = br.readLine().split(" ");
                for(int j = 1; j <= N; j++) {
                    int in = Integer.parseInt(input[j-1]);
                    if(in == 1) {
                        tomatoCellNum++;
                        queue.add(new Point(i,j,k,0));
                        isVisited[k][i][j] = true;
                    } else if (in == -1) wallCellNum++;
                    matrix[k][i][j] = in;
                }
            }
        }
        totalCellNum -= wallCellNum;
        if(tomatoCellNum == totalCellNum) sb.append(0);
        else {
            sb.append(BFS());
        }

        System.out.println(sb);
    }
    public static int BFS() {
        int count = -1;
        while(!queue.isEmpty()) {
            Point node = queue.poll();
            for(int d = 0; d < 6; d++) {
                int tempI = node.i + dirI[d];
                int tempJ = node.j + dirJ[d];
                int tempK = node.k + dirK[d];
                if(matrix[tempK][tempI][tempJ] == 0 && !isVisited[tempK][tempI][tempJ]
                && tempI >= 1 && tempI <= M && tempJ >= 1 && tempJ <= N && tempK >= 1 && tempK <= H) {
                    queue.add(new Point(tempI, tempJ, tempK, node.count + 1));
                    matrix[tempK][tempI][tempJ] = 1;
                    isVisited[tempK][tempI][tempJ] = true;
                    tomatoCellNum++;
                    if(totalCellNum == tomatoCellNum) {
                        return node.count + 1;
                    }
                }

            }
        }
        return count;
    }
}

class Point {
    int i;
    int j;
    int k;
    int count;
    Point(int I, int J, int K, int C) {
        this.i = I;
        this.j = J;
        this.k = K;
        this.count = C;
    }
}
