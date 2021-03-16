package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] matrix;
    public static boolean[][] isVisited;
    public static StringBuilder bfs;
    public static int N;
    public static int[] divI = {-1,1,0,0};
    public static int[] divJ = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        List<Integer> result = new LinkedList<>();
        N = Integer.valueOf(br.readLine());
        bfs = new StringBuilder();

        matrix = new int[N+2][N+2];
        isVisited = new boolean[N+2][N+2];

        for(int i = 1; i <= N; i++) {
            String line = br.readLine();
            for(int j = 1; j <= N; j++) {
                matrix[i][j] = line.charAt(j-1) - '0';
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(isVisited[i][j] == false && matrix[i][j] == 1) {
                    result.add(BFS(i,j));
                    count++;
                }
            }
        }
        Collections.sort(result);
        System.out.println(count);
        for(int r: result) {
            System.out.println(r);
        }


    }


    public static int BFS(int sI, int sJ) {
        Queue<point> queue = new LinkedList<>();
        int result = 0;

        queue.add(new point(sI, sJ));
        isVisited[sI][sJ] = true;

        while(!queue.isEmpty()) {
            point nextIdx = queue.poll();
            result += 1;
//            bfs.append(nextIdx + " ");

            for(int i = 0; i < 4; i++)  {
                int nextI = nextIdx.i + divI[i];
                int nextJ = nextIdx.j + divJ[i];
                if(isVisited[nextI][nextJ] == false && matrix[nextI][nextJ] == 1) {
                    queue.add(new point(nextI,nextJ));
                }
                isVisited[nextI][nextJ] = true;
            }
        }
        return result;
    }
}

class point {
    int i;
    int j;
    point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
