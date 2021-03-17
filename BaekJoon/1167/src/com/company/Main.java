package com.company;

import javax.swing.text.html.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static ArrayList<info>[] list;
    public static boolean[] visited;
    public static int maxLen;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        maxLen = 0;
//        for(int i = 0; i <= N; i++) {
//            list.add(new ArrayList<info>());
//        }

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            for(int n = 1; n < input.length - 1; n+=2) {
                int idx = Integer.parseInt(input[n]);
                int len = Integer.parseInt(input[n+1]);
                list[node].add(new info(idx,len));
                list[idx].add(new info(node,len));
            }
        }

        for(int i = 1; i<= N; i++) {
            DFS(i,0);
        }
        System.out.println(maxLen);
    }

    public static void DFS(int s, int sum) {

        for(info i: list[s]) {
            if(visited[s] == false) {
                visited[s] = true;
                DFS(i.node, sum + i.len);
                visited[s] = false;
            }
        }
        maxLen = Integer.max(maxLen,sum);
    }
}
class info {
    int node;
    int len;
    info(int n, int l) {
        this.node = n;
        this.len = l;
    }
}