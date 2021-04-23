package com.company;

import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[][] matrix;
    private static boolean[][] landVisited;
    private static boolean[][] masterVisited;
    private static Queue<Position> land = new LinkedList<>();
    private static Queue<Position> edge = new LinkedList<>();
    private static int[] dirI = {1,0,-1,0};
    private static int[] dirJ = {0,-1,0,1};
    private static int minLength = 10_001;
    private static Position nextSearch;

    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    matrix = new int[N+2][N+2];
	    masterVisited = new boolean[N+2][N+2];
	    boolean findFirstLand = false;
	    for(int i = 1; i <= N; i++) {
	        int[] oneRow = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
	        int column = 1;
	        for(int v: oneRow) {
                if(!findFirstLand && v == 1) {
                    findFirstLand = true;
                    nextSearch = new Position(i, column, 0);
                }
	            matrix[i][column++] = v;
            }
        }
	    boolean goAhead = true;
	    while(goAhead) {
	        screenLandAndPickEdge(nextSearch.i, nextSearch.j);
	        goAhead = findShortLengthToLand();
        }
        while(checkSpare()) {
            screenLandAndPickEdge(nextSearch.i, nextSearch.j);
            findShortLengthToLand();
        }
	    System.out.print(minLength);
    }
    private static boolean checkSpare() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(!masterVisited[i][j] && matrix[i][j] == 1) {
                    nextSearch = new Position(i,j , 0);
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean findShortLengthToLand() {
        while(!edge.isEmpty()) {
            Position pos = edge.poll();
            for(int i = 0; i < 4; i++) {
                int newI = pos.i + dirI[i];
                int newJ = pos.j + dirJ[i];
                if(newI >= 1 && newI <= N && newJ >= 1 && newJ <= N) {
                    if(!masterVisited[newI][newJ]) {
                        if(matrix[newI][newJ] == 0) {
                            edge.add(new Position(newI, newJ, pos.count + 1));
                            masterVisited[newI][newJ] = true;
                        } else {
                            minLength = Integer.min(minLength, pos.count);
                            nextSearch = new Position(newI, newJ, 0);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    private static void screenLandAndPickEdge(int startI, int startJ) {
        landVisited = new boolean[N+2][N+2];
        land = new LinkedList<>();
        edge = new LinkedList<>();
        land.add(new Position(startI, startJ, 0));
        landVisited[startI][startJ] = true;
        masterVisited[startI][startJ] = true;

        while(!land.isEmpty()) {
            Position pos = land.poll();
            for(int i = 0; i < 4; i++) {
                int newI = pos.i + dirI[i];
                int newJ = pos.j + dirJ[i];
                if(newI >= 1 && newI <= N && newJ >= 1 && newJ <= N) {
                    if(!landVisited[newI][newJ]) {
                        if(matrix[newI][newJ] == 1) {
                            land.add(new Position(newI, newJ, 0));
                        } else {
                            edge.add(new Position(newI, newJ, 1));
                        }
                        landVisited[newI][newJ] = true;
                        masterVisited[newI][newJ] = true;
                    }
                }
            }
        }

    }
}

class Position {
    int i;
    int j;
    int count;
    Position(int i, int j, int count) {
        this.i = i;
        this.j = j;
        this.count = count;
    }
}
