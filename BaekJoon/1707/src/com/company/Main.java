package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static String[] matrix;
    public static int[][] newBoard;
    public static int[] result;
    public static int sum = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new String[N];
        result = new int[N+3];
        for(int i = 0; i < N; i++) {
            matrix[i] = br.readLine();
        }
        for(int k = 1; k <= N; k++) {
            for(int i = 0; i <= N-k; i++) {
                for(int j = 0; j <= N-k; j++) {
                    if(checkSquare(i,j,k)) {
                        result[k]++;
                        sum++;
                    }
                }
            }
        }

        int p = result[1];
        int c = 1;
        System.out.println(String.format("total: %d",sum));
        while(p!=0) {
            System.out.println(String.format("size[%d]: %d",c,p));
            p = result[++c];
        }
    }
    public static boolean checkSquare(int i, int j, int n) {
        for(int a = i; a < i+n; a++) {
            for(int b = j; b < j+n; b++) {
                if(matrix[a].charAt(b) == '0') {
                    return false;
                }
            }
        }
        return true;
    }
}
