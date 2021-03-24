package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[][] matrix;
    public static int whiteNum = 0;
    public static int blueNum = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][];
        for(int i = 0 ; i < N; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        matrixRead(0,0, N);
        System.out.println(whiteNum);
        System.out.println(blueNum);
    }
    public static void matrixRead(int startI, int startJ, int length) {
        int result = matrixCheck(startI,startJ,length);
        if(result < 0) {
            int newLength = length/2;
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    matrixRead(startI + i * newLength, startJ + j * newLength, newLength);
                }
            }
        } else if(result == 0) {
            whiteNum++;
        } else {
            blueNum++;
        }
    }
    public static int matrixCheck(int startI, int startJ, int length) {
        int firstColor = matrix[startI][startJ];
        for(int i = startI; i < startI + length; i++) {
            for(int j = startJ; j < startJ + length; j++) {
                if(matrix[i][j] != firstColor) {
                    return -1;
                }
            }
        }
        return firstColor;
    }
}
