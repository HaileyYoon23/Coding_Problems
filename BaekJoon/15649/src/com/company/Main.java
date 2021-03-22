package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int N;
    public static int M;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        visited = new boolean[N+1];

        DFS(0,0);
    }
    public static void DFS(int index, int lastI) {
        if(index == M) {
            printArray();
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(visited[i] == true) continue;
            arr.add(i);
            visited[i] = true;
            DFS(index+1, i+1);
            arr.remove(index);
            visited[i] = false;
        }
    }
    public static void printArray() {
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.print("\n");
    }
}
