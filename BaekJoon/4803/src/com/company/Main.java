package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visited;
    public static ArrayList<Integer>[] matrix;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int caseNum = 1;
        while(v1 != 0 || v2 != 0 ) {
            matrix = new ArrayList[v1+1];
            visited = new boolean[v1+1];
            for(int i = 0; i <= v1; i++) {
                matrix[i] = new ArrayList<>();
            }
            for(int i = 1; i <= v2; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                matrix[a].add(b);
                matrix[b].add(a);
            }
            int count = 0;
            for(int i = 1; i <= v1; i++) {
                if(!visited[i] && travelTree(i)) count++;
            }
            if(count == 0) {
                sb.append(String.format("Case %d: No trees.\n",caseNum));
            } else if(count == 1) {
                sb.append(String.format("Case %d: There is one tree.\n",caseNum));
            } else {
                sb.append(String.format("Case %d: A forest of %d trees.\n",caseNum,count));
            }
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            caseNum++;
        }
        System.out.println(sb);
    }
    public static boolean travelTree(int start) {
        boolean result = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int temp: matrix[node]) {
                if(!visited[temp]) {
                    visited[temp] = true;
                    queue.add(temp);
                    matrix[temp].remove(matrix[temp].indexOf(node));
                } else {
                    return false;
                }
            }
        }
        return result;
    }
}
