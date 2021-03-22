package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static int[][] sudoku = new int[9][];
    public static boolean[][] visited = new boolean[9][10];
    public static List<Point> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            sudoku[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(sudoku[i][j] != 0) {
                    visited[(i/3)*3 + (j/3)][sudoku[i][j]] = true;
                } else {
                    list.add(new Point(i,j));
                }
            }
        }
        DFS(0);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
    public static void DFS(int count) {
        if(count == list.size()) {
            return;
        }
        Point p = list.get(count);
        for(int i = 1; i <= 9; i++) {
            Boolean check = true;
            if(visited[(p.i/3)*3 + (p.j/3)][i] == false) {
                for(int a = 0; a < 9; a++) {
                    if(i == sudoku[p.i][a]) {
                        check = false;
                        break;
                    }
                    if(i == sudoku[a][p.j]) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    visited[(p.i/3)*3 + (p.j/3)][i] = true;
                    sudoku[p.i][p.j] = i;
                    DFS(count+1);
                    visited[(p.i/3)*3 + (p.j/3)][i] = false;
                }
            }
        }
    }
}

class Point {
    int i;
    int j;
    Point(int I, int J) {
        this.i = I;
        this.j = J;
    }
}
