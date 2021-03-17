package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static ArrayList<info>[] list;
    public static boolean[] visited;
    public static int maxLen;
    public static int maxNode;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+2];
        visited = new boolean[N+2];
        maxLen = 0;
        maxNode = 0;
        for(int i = 0; i<= N+1; i++) {
            list[i] = new ArrayList<info>();
        }

        for(int i = 1; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);
            int length = Integer.parseInt(input[2]);
            list[parent].add(new info(child, length));
            list[child].add(new info(parent, length));
        }

        DFS(1,0);
        visited = new boolean[N+2];
        maxLen = 0;
        DFS(maxNode, 0);
        System.out.println(maxLen);
    }
    public static void DFS(int s, int sum) {
        visited[s] = true;
        for(info i: list[s]) {
            if(visited[i.node] == false) {
                DFS(i.node, sum + i.length);
            }
        }
        if(maxLen < sum) {
            maxNode = s;
            maxLen = sum;
        }

    }
}




class info {
    int node;
    int length;

    info(int n, int l) {
        this.node = n;
        this.length = l;
    }
}
