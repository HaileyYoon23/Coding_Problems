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
    public static Queue<point> queue = new LinkedList<>();
    public static int total = 0;

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        List<Integer> result = new LinkedList<>();
        count = 0;
        String[] info = br.readLine().split(" ");
        widthJ = Integer.valueOf(info[0]);
        widthI = Integer.valueOf(info[1]);
        total = widthI * widthJ;

        matrix = new int[widthI+2][widthJ+2];
        isVisited = new boolean[widthI+2][widthJ+2];

        for(int i = 0; i < widthI; i++) {
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < widthJ; j++) {
                matrix[i+1][j+1] = Integer.valueOf(line[j]);
                switch(matrix[i+1][j+1]) {
                    case (1):
                        queue.add(new point(i+1, j+1,1));
                        isVisited[i+1][j+1] = true;
                        total--;
                        break;
                    case(-1):
                        isVisited[i+1][j+1] = true;
                        total--;
                        break;
                }
            }
        }
        if(total == 0) {
            System.out.println(0);
        } else {
            System.out.println(BFS());
        }





    }


    public static int BFS() {
        int count = -1;
        int nextCount = 0;
        while(!queue.isEmpty()) {
            point nextIdx = queue.poll();

            for(int i = 0; i < 4; i++)  {
                int nextI = nextIdx.i + divI[i];
                int nextJ = nextIdx.j + divJ[i];
                nextCount = nextIdx.count;
                if(isVisited[nextI][nextJ] == false && matrix[nextI][nextJ] == 0 &&
                        nextI >= 1 && nextI <= widthI && nextJ >= 1 && nextJ <= widthJ) {
                    matrix[nextI][nextJ] = 1;
                    queue.add(new point(nextI,nextJ,nextCount+1));
                    total--;
                    if(total == 0) {
                        return nextCount;
                    }
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
