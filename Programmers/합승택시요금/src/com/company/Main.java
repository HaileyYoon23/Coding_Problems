package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int n = 7;//6;
        int s = 3;//4;
        int a = 4;//6;
        int b = 1;//2;
        int[][] farse =  {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
                //{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        System.out.print((new Solution()).solution(n,s,a,b,farse));
    }
}


class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 100_000_000;
        int[][] shortestLen = new int[n+1][n+1];
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                shortestLen[i][j] = 1_000_001;
                if(i == j) shortestLen[i][j] = 0;
            }
        }
        for(int i = 0; i < fares.length; i++) {
            shortestLen[fares[i][0]][fares[i][1]] = fares[i][2];
            shortestLen[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        for(int k = 1; k < n+1; k++) {
            for(int i = 1; i < n+1; i++) {
                for(int j = 1; j < n+1; j++) {
                    if(shortestLen[i][k] + shortestLen[k][j] < shortestLen[i][j]) {
                        shortestLen[i][j] = shortestLen[i][k] + shortestLen[k][j];
                    }
                }
            }
        }

        for(int c = 1; c < n+1; c++) {
            int check = shortestLen[c][s] + shortestLen[c][a] + shortestLen[c][b];
            answer = Math.min(check,answer);
        }

        return answer;
    }
}