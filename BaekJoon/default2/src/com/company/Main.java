package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static int[][] matrix;
    public static int height;
    public static int width;
    public static boolean[][] visited;
    public static int result = 0;
    public static int[] dirI = {-1,0,1,0};
    public static int[] dirJ = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            String[] info = br.readLine().split(" ");
            height = Integer.parseInt(info[0]);
            width = Integer.parseInt(info[1]);
            matrix = new int[height+2][width+2];
            for(int i = 1; i <= height; i++) {
                String[] input = br.readLine().split(" ");
                for(int j = 1; j <= width; j++) {
                    matrix[i][j] = Integer.parseInt(input[j-1]);
                }
            }
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                    if(matrix[i][j] == 1 && visited[i][j] == false) {
                        BFS(i,j);
                    }
                }
             }
        }

        System.out.println(sb);
    }
    public static void BFS(int curI, int curJ) {
        Queue<Shape> queue = new LinkedList<>();
        queue.add(new Shape(curI,curJ,1,0,1,0));
        while(!queue.isEmpty()) {
            Shape shape = queue.poll();
            if(shape.curDir != 0) {
                if(shape.firstCount >= 2 && shape.secondCount == 0) {
                    int ci = shape.curI + dirI[(shape.curDir+1)%4];
                    int cj = shape.curJ + dirJ[(shape.curDir+1)%4];
                    if(matrix[ci][cj] == 1) {
                        queue.add(new Shape(ci,cj,shape.dirCount+1,(shape.curDir+1)%4,shape.firstCount,2));
                    }
                    ci = shape.curI + dirI[(shape.curDir+3)%4];
                    cj = shape.curJ + dirJ[(shape.curDir+3)%4];
                    if(matrix[ci][cj] == 1) {
                        queue.add(new Shape(ci,cj,shape.dirCount+1,(shape.curDir+1)%4,shape.firstCount,2));
                    }
                } else {
                    if(shape.firstCount >= shape.secondCount) {
                        if(shape.firstCount == shape.secondCount * 2) {
                            result++;
                        } else if(shape.firstCount > shape.secondCount * 2) {
                            queue.add(new Shape(shape.curI+dirI[shape.curDir], shape.curJ+dirJ[shape.curDir],shape.dirCount+2,shape.curDir,shape.firstCount,shape.secondCount+1));
                        } else {
                        }
                    } else {
                        if(shape.firstCount*2 == shape.secondCount) {
                            result++;
                        } else if(shape.firstCount*2 > shape.secondCount) {
                            queue.add(new Shape(shape.curI+dirI[shape.curDir], shape.curJ+dirJ[shape.curDir],shape.dirCount+2,shape.curDir,shape.firstCount,shape.secondCount+1));
                        } else {
                        }
                    }
                }
            } else {

            }
            for(int d = 0; d < 4; d++) {
                int ci = shape.curI + dirI[d];
                int cj = shape.curJ + dirJ[d];
                if(matrix[ci][cj] == 1) {
                    queue.add(new Shape(ci,cj,shape.dirCount+1,d,shape.dirCount+1,0));

                }
            }
        }

    }
}

class Shape {
    int curI;
    int curJ;
    int dirCount;
    int curDir;
    int firstCount;
    int secondCount;
    Shape(int curI, int curJ, int dirCount, int curDir, int firstCount, int secondCount) {
        this.curI = curI;
        this.curJ = curJ;
        this.dirCount = dirCount;
        this.curDir = curDir;
        this.firstCount = firstCount;
        this.secondCount = secondCount;
    }

}

