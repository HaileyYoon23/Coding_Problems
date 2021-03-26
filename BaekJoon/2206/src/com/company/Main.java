package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int height, width;
    public static int[][] matrix;
    public static Queue<Point> queue = new LinkedList<>();
    public static boolean[][][] visited;
    public static int[] dirI = {1,-1,0,0};
    public static int[] dirJ = {0,0,1,-1};
    public static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        height = Integer.parseInt(info[0]);
        width = Integer.parseInt(info[1]);
        matrix = new int[height + 2][width + 2];
        visited = new boolean[height + 2][width + 2][2];

        for(int h = 1; h <= height; h++) {
            String[] input = br.readLine().split("(?!^)");
            for(int w = 1; w <= width; w++) {
                matrix[h][w] = Integer.parseInt(input[w-1]);
            }
        }
        queue.add(new Point(1,1,false,1));
        visited[1][1][0] = true;
        visited[1][1][1] = true;

        System.out.println(BFS());
    }

    public static boolean canCrash(int i, int j, int dir) {
        int tempI = i + dirI[dir];
        int tempJ = j + dirJ[dir];
        if(tempI >= 1 && tempI <= height && tempJ >= 1 && tempJ <= width) {
            if(matrix[tempI][tempJ] == 0) return true;
            else return false;
        } else {
            return false;
        }
    }

    public static int BFS() {
        while(!queue.isEmpty()) {
            Point node = queue.poll();
            if(node.i == height && node.j == width) {
                minCount = Integer.min(minCount,node.count);
            }
            for(int k = 0; k < 4; k++) {
                int tempI = node.i + dirI[k];
                int tempJ = node.j + dirJ[k];
                int wallThrough = (node.crashed) ? 1 : 0;
                if(tempI >= 1 && tempI <= height && tempJ >= 1 && tempJ <= width && !visited[tempI][tempJ][wallThrough]) {
                    if(matrix[tempI][tempJ] == 0) {
                        queue.add(new Point(tempI,tempJ,node.crashed, node.count + 1));
                        visited[tempI][tempJ][wallThrough] = true;
                    }
                    else {
                        if(!node.crashed && canCrash(tempI,tempJ,k)
                                && !visited[tempI+dirI[k]][tempJ+dirJ[k]][1]) {
                            visited[tempI+dirI[k]][tempJ+dirJ[k]][1] = true;
                            queue.add(new Point(tempI+dirI[k],tempJ+dirJ[k],true, node.count+2));
                        }
                    }
                }
            }
        }
        if(minCount == Integer.MAX_VALUE) return -1;
        else return minCount;
    }
}
class Point {
    int i;
    int j;
    boolean crashed;
    int count;
    Point(int I, int J, boolean Crashed, int Count) {
        this.i = I;
        this.j = J;
        this.crashed = Crashed;
        this.count = Count;
    }
}