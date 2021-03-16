package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] matrix;
    public static boolean[][] isVisited;
    public static StringBuilder bfs;
    public static int widthI, widthJ;
    public static int[] divI = {-1,1,0,0};
    public static int[] divJ = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        List<Integer> result = new LinkedList<>();
        count = 0;
        String[] info = br.readLine().split(" ");
        widthI = Integer.valueOf(info[0]);
        widthJ = Integer.valueOf(info[1]);

        matrix = new int[widthI+2][widthJ+2];
        isVisited = new boolean[widthI+2][widthJ+2];

        for(int i = 0; i < widthI; i++) {
            String line = br.readLine();
            for(int j = 0; j < widthJ; j++) {
                matrix[i+1][j+1] = line.charAt(j) - '0';
            }
        }
        System.out.println(BFS(1,1));




    }


    public static int BFS(int sI, int sJ) {
        Queue<point> queue = new LinkedList<>();
        int count = 1;
        queue.add(new point(sI, sJ,1));
        isVisited[sI][sJ] = true;

        while(!queue.isEmpty()) {
            point nextIdx = queue.poll();
//            bfs.append(nextIdx + " ");


            for(int i = 0; i < 4; i++)  {
                int nextI = nextIdx.i + divI[i];
                int nextJ = nextIdx.j + divJ[i];
                count = nextIdx.count;
                if(isVisited[nextI][nextJ] == false && matrix[nextI][nextJ] == 1) {
                    if(nextI == widthI && nextJ == widthJ) {
                        return count+1;
                    }
                    queue.add(new point(nextI,nextJ,count+1));
                }
                isVisited[nextI][nextJ] = true;
            }
        }
        return count;
    }
}

class point {
    int i;
    int j;
    int count;
    point(int i, int j, int c) {
        this.i = i;
        this.j = j;
        this.count = c;
    }
}
