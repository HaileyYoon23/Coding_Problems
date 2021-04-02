package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][] visited;
    public static ArrayList<Point> listToChangeAsAvg = new ArrayList<>();
    public static int N, sum, count, moveCount, L, R;
    public static int[][] matrix;
    public static int[] dirI = {1,-1,0,0};
    public static int[] dirJ = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        // Initialization
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken()); L = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());
	    sum = 0; count = 0; moveCount = 0;
	    matrix = new int[N+2][N+2];
	    boolean check = true;
	    for(int i = 1; i <= N; i++) {
	        st = new StringTokenizer(br.readLine());
	        for(int j = 1; j <= N; j++) {
	            matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(check) {
            check = false;
            visited = new boolean[N+2][N+2];
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    sum = 0; count = 0;
                    if(!visited[i][j]) {
                        listToChangeAsAvg = new ArrayList<>();
                        BFS(i,j);
                    }
                    if(count > 1) {
                        check = true;
                        listChange(sum/count);
                    }
                }
            }
            if(check) moveCount++;
        }
        System.out.println(moveCount);
    }

    public static void BFS(int startI, int startJ) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startI, startJ));
        sum += matrix[startI][startJ];
        count++;
        visited[startI][startJ] = true;
        listToChangeAsAvg.add(new Point(startI, startJ));

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int curValue = matrix[point.i][point.j];

            for(int i = 0; i < 4; i++) {
                int pointI = point.i + dirI[i];
                int pointJ = point.j + dirJ[i];
                int nextValue = matrix[pointI][pointJ];
                int diff = Math.abs(nextValue - curValue);

                if(!visited[pointI][pointJ] && pointI > 0 && pointI <= N && pointJ > 0 && pointJ <= N
                && diff >= L && diff <= R) {
                    queue.add(new Point(pointI, pointJ));
                    sum += matrix[pointI][pointJ];
                    count++;
                    visited[pointI][pointJ] = true;
                    listToChangeAsAvg.add(new Point(pointI, pointJ));
                }
            }
        }
    }

    public static void listChange(int avg) {
        for(Point p: listToChangeAsAvg) {
            matrix[p.i][p.j] = avg;
        }
    }
}

class Point {
    int i;
    int j;
    Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}