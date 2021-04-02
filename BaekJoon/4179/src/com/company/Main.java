package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static String[][] matrix;
    public static int N, M;
    public static Queue<Point> fire = new LinkedList<>();
    public static int time = 0;
    public static Queue<Jihoon> jihoonLoc = new LinkedList<>();
    public static int[] dirI = {-1,1,0,0};
    public static int[] dirJ = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());  M = Integer.parseInt(st.nextToken());
	    matrix = new String[N+2][M+2];
        int result = 1;
        boolean find = false;
	    for(int n = 1; n <= N; n++) {
	        String[] inputs = br.readLine().split("(?!^)");
	        for(int m = 1; m <= M; m++) {
	            String in = inputs[m-1];
	            if(in.equals("F")) fire.add(new Point(n,m));
	            else if(in.equals("J")) {
	                if(n == 1 || n == N || m == 1 || m == M) {
	                    find = true;
                    }
	                jihoonLoc.add(new Jihoon(n,m,0));
                }
	            matrix[n][m] = in;
            }
        }
	    if(!find) result = BFS();
	    if(result == -1) System.out.println("IMPOSSIBLE");
	    else System.out.println(result);



    }
    public static int BFS() {
        while(!fire.isEmpty() || !jihoonLoc.isEmpty()) {
            // 불 번짐 시작
            int fireNum = fire.size();
            for(int f = 0; f < fireNum; f++) {
                Point firePoint = fire.poll();
                for(int i = 0; i < 4; i++) {
                    int newI = firePoint.i + dirI[i];
                    int newJ = firePoint.j + dirJ[i];
                    if(newI <= 0 || newI > N || newJ <= 0 || newJ > M) continue;
                    if(!matrix[newI][newJ].equals("#") && !matrix[newI][newJ].equals("F")) {
                        matrix[newI][newJ] = "F";
                        fire.add(new Point(newI, newJ));
                    }
                }
            }
            int jihoonNum = jihoonLoc.size();
            for(int j = 0; j < jihoonNum; j++) {
                Jihoon jihoonPoint = jihoonLoc.poll();
                for(int i = 0; i < 4; i++) {
                    int newI = jihoonPoint.i + dirI[i];
                    int newJ = jihoonPoint.j + dirJ[i];
                    if(newI <= 0 || newI > N || newJ <= 0 || newJ > M) continue;
                    if(matrix[newI][newJ].equals(".")) {
                        if(newI == N || newJ == M || newI == 1 || newJ == 1) {
                            return jihoonPoint.count + 2;
                        } else {
                            jihoonLoc.add(new Jihoon(newI, newJ, jihoonPoint.count+1));
                            matrix[newI][newJ] = "J";
                        }
                    }
                }
            }
        }
        return -1;
    }
}
class Point {
    int i;
    int j;
    Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Jihoon {
    int i;
    int j;
    int count;
    Jihoon(int i, int j, int count) {
        this.i = i;
        this.j = j;
        this.count = count;
    }
}