package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int N, K, L;
    public static int[][] matrix;
    public static int[] dirI = {-1, 0, 1, 0};
    public static int[] dirJ = {0, 1, 0, -1};
    public static Deque<Point> deque = new LinkedList<>();
    public static int time = 0;
    public static boolean snakeOver = false;
    public static int currentDir = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;
        N = Integer.parseInt(br.readLine()); K = Integer.parseInt(br.readLine());
        matrix = new int[N+1][N+1];
        for(int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int inputI = Integer.parseInt(st.nextToken()); int inputJ = Integer.parseInt(st.nextToken());
            matrix[inputI][inputJ] = 2;     // 1: Snake, 2: Apple
        }
        L = Integer.parseInt(br.readLine());
        deque.addFirst(new Point(1,1));
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            switch (command) {
                case("L"):
                    snake(time, true);
                    break;
                case("D"):
                    snake(time, false);
                    break;
            }
            if(snakeOver) break;
        }
        if(snakeOver) System.out.println(time);
        else {
            snake(100, true);
            System.out.println(time);
        }
    }
    public static int snakeDir(int curDir, boolean isLeft) {
        int result = curDir;
        if(isLeft) {
            result = (result + 3) % 4;
        } else {
            result = (result + 1) % 4;
        }
        return result;
    }

    public static void snake(int t, boolean isLeft) {
        while(time != t + 1) {
            time++;
            if(time == t + 1) {
                currentDir = snakeDir(currentDir, isLeft);
            }
            Point p = deque.peekFirst();
            int firstI = p.i + dirI[currentDir];
            int firstJ = p.j + dirJ[currentDir];
            if(firstI <= 0 || firstI > N
                    || firstJ <= 0 || firstJ > N) {
                snakeOver = true;
                break;
            }
            if(matrix[firstI][firstJ] == 1) {
                snakeOver = true;
                break;
            }
            if(matrix[firstI][firstJ] != 1) {
                deque.addFirst(new Point(firstI, firstJ));
                if(matrix[firstI][firstJ] == 0) {       // 꼬리 사라짐
                    matrix[firstI][firstJ] = 1;
                    Point tail = deque.pollLast();
                    matrix[tail.i][tail.j] = 0;
                } else {                // 사과
                    matrix[firstI][firstJ] = 1;         // 꼬리 안사라짐 (사과 먹음)
                }
            }


        }
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