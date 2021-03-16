package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] matrix;
    public static boolean[][] isVisited;
    public static StringBuilder bfs;
    public static int N,M;
    public static int[] divI = {-1,1,0,0};
    public static int[] divJ = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        List<Integer> result = new LinkedList<>();
        int T = Integer.valueOf(br.readLine());
        for(int t = 0; t < T; t++) {
            count = 0;
            String[] info = br.readLine().split(" ");
            M = Integer.valueOf(info[0]);
            N = Integer.valueOf(info[1]);
            int num = Integer.valueOf(info[2]);

            matrix = new int[N+2][M+2];
            isVisited = new boolean[N+2][M+2];

            for(int i = 0; i < num; i++) {
                String[] line = br.readLine().split(" ");
                int a = Integer.valueOf(line[0]);
                int b = Integer.valueOf(line[1]);
                matrix[b+1][a+1] = 1;
            }

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    if(isVisited[i][j] == false && matrix[i][j] == 1) {
                        BFS(i,j);
                        count++;
                    }
                }
            }
            result.add(count);
        }

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
