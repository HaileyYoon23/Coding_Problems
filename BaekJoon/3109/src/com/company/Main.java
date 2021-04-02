package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int R, C;
    public static int[][] matrix;
    public static boolean findWay;
    public static int result = 0;
    public static int[] dirRow = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        matrix = new int[R][C];
        for(int r = 0; r < R; r++) {
            int c = 0;
            String[] input = br.readLine().split("(?!^)");
            for(String s: input) {
                if(s.equals(".")) matrix[r][c++] = 0;
                if(s.equals("x")) matrix[r][c++] = -1;
            }
        }

        for(int r = 0; r < R; r++) {
            DFS(r,0);
        }

        System.out.println(result);
    }
    public static boolean DFS(int row, int column) {
        for(int i = 0; i < 3; i++) {
            int nextI = row + dirRow[i];
            int nextJ = column + 1;
            if(nextI < 0 || nextI >= R || nextJ < 0 || nextJ >= C) continue;

            if(matrix[nextI][nextJ] == 0) {
                if(nextJ == C - 1) {
                    matrix[nextI][nextJ] = 1;
                    result++;
                    return true;
                }
                matrix[nextI][nextJ] = 1;
                if(DFS(nextI,nextJ)) {
                    return true;
                }
            }
        }
        return false;
    }
}
