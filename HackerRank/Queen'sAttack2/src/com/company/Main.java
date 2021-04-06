package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int n = 5;
        int k = 3;
        int r_q = 4;
        int c_q = 3;
        int[][] obstacles = {{5,5},{4,2},{2,3}};
        System.out.println(Solution.queensAttack(n, k, r_q, c_q, obstacles));
    }
}


class Solution {

    // Complete the queensAttack function below.
    private static int[][] chessBoard;
    private static int result = 0;
    private static int[] dirR = {1,1,0,-1,-1,-1,0,1};
    private static int[] dirC = {0,1,1,1,0,-1,-1,-1};
    private static int N;
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        chessBoard = new int[n+1][n+1];
        for(int i = 0; i < k; i++) {
            chessBoard[obstacles[i][0]][obstacles[i][1]] = -1;
        }
        N = n;
        for(int i = 0; i < 8; i++) {
            goDirection(r_q, c_q,i);
        }
        return result - 8;
    }

    static void goDirection(int row, int column, int dir) {
        while(true) {
            if(row > 0 && row <= N && column > 0 && column <= N) {
                if(chessBoard[row][column] == 0) {
                    result++;
                    row += dirR[dir];
                    column += dirC[dir];
                } else break;
            } else break;
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
