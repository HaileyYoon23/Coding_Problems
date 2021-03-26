package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static int[] checked;            // 0 : yet,  1 : list1,  2 : list2
    public static ArrayList<Integer>[] matrix;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String[] info = br.readLine().split(" ");
            int V = Integer.parseInt(info[0]);
            int E = Integer.parseInt(info[1]);
            matrix = new ArrayList[V+1];
            boolean result = true;
            checked = new int[V+1];
            for(int i = 1; i <= V; i++) {
                matrix[i] = new ArrayList<Integer>();
            }
            for(int e = 0; e < E; e++) {
                String[] line = br.readLine().split(" ");
                int point1 = Integer.parseInt(line[0]);
                int point2 = Integer.parseInt(line[1]);
                matrix[point1].add(point2);
                matrix[point2].add(point1);
            }
            for(int i = 1; i <= V; i++) {
                if(checked[i] == 0) {
                    DFS(i,1);
                }
            }
            for(int i = 1; i <= V; i++) {
                for(int j: matrix[i]) {
                    if(checked[i] == checked[j]) {
                        result = false;
                        break;
                    }
                }
            }

            if(result) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
    public static void DFS(int idx, int check) {
        checked[idx] = check;
        for(int a: matrix[idx]) {
            if(checked[a] == 0) DFS(a, 3-check);
        }
    }
}
