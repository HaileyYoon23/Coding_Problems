package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int width;
    public static int height;
    public static String[] matrix;
    public static boolean[][] isVisited;
    public static int minSideCount = Integer.MAX_VALUE;
    public static int lastJ;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        width = Integer.parseInt(info[0]);
        height = Integer.parseInt(info[1]);
        isVisited = new boolean[height][width];
        matrix = new String[height];
        for(int i = 0; i < height; i++) {
            matrix[i] = br.readLine();
            if(matrix[i].contains(".")) lastJ = i;
        }
        for(int j = 0; j < width; j++) {
            if(matrix[0].charAt(j)=='c'){
                DFS(1,j,0);
            }
        }
        if(minSideCount == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(minSideCount);
    }
    public static void DFS(int curI, int curJ, int sideCount) {
        if(curI < 0 || curI >= height || curJ < 0 || curJ >= width) {
            return;
        }
        if(isVisited[curI][curJ]) return;
        isVisited[curI][curJ] = true;
        if(matrix[curI].charAt(curJ) == 'x') {
            return;
        }
        if(curI == lastJ) {
            minSideCount = Integer.min(minSideCount, sideCount);
            isVisited[curI][curJ] = false;
            return;
        }
        if(matrix[curI+1].charAt(curJ)=='.') {
            DFS(curI+1,curJ,sideCount);
        }
        DFS(curI, curJ+1,sideCount+1);
        DFS(curI, curJ-1,sideCount+1);
        isVisited[curI][curJ] = false;
    }
    static class EyesPos {
        int curI;
        int curJ;
        int sideCount;
        EyesPos(int cI, int cJ, int sC){
            this.curI = cI;
            this.curJ = cJ;
            this.sideCount = sC;
        }
    }
}

