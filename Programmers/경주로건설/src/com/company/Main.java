package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        System.out.println((new Solution()).solution(board));
    }
}

class Solution {
    private static int[] dirI = {-1,1,0,0};
    private static int[] dirJ = {0,0,-1,1};
    private static int[][] visited;
    private static int N, straightNum = 0, curveNum = 0;
    private static int minSum = Integer.MAX_VALUE;
    private static int[][] matrix;
    public int solution(int[][] board) {;
        N = board.length;
        matrix = board;
        visited = new int[N][N];
        visited[0][0] = 0;
//        DFS(0,0,-1,0,0);
        matrix[0][0] = 1;
        BFS();
        return minSum;
    }
    private static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,-1,0));
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            if(point.i == N-1 && point.j == N-1) {
                minSum = Integer.min(minSum, point.cost);
            }
            for(int d = 0; d < 4; d++) {
                int newIndexI = point.i + dirI[d];
                int newIndexJ = point.j + dirJ[d];
                if(newIndexI >= 0 && newIndexI < N && newIndexJ >= 0 && newIndexJ < N) {
                    if (matrix[newIndexI][newIndexJ] == 0) {
                        if (point.dir == d || point.dir == -1) {
                            if (visited[newIndexI][newIndexJ] == 0 || visited[newIndexI][newIndexJ] >= point.cost + 100) {
                                queue.add(new Point(newIndexI, newIndexJ, d, point.cost + 100));
                                visited[newIndexI][newIndexJ] = point.cost + 100;
                            }
                        }
                         else {
                            if (visited[newIndexI][newIndexJ] == 0 || visited[newIndexI][newIndexJ] >= point.cost + 600) {
                                queue.add(new Point(newIndexI, newIndexJ, d, point.cost + 600));
                                visited[newIndexI][newIndexJ] = point.cost + 600;
                            }
                        }
                    }
                }
            }
        }
    }
}

class Point {
    int i;
    int j;
    int dir;
    int cost;
    Point(int i, int j, int dir, int cost) {
        this.i = i;
        this.j = j;
        this.dir = dir;
        this.cost = cost;
    }
}