package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    private static boolean[] visited;
    private static int[] previsit;
    private static ArrayList<Integer>[] arr;
    private static int[] hang;
    public boolean solution(int n, int[][] path, int[][] order) {
        visited = new boolean[n];
        previsit = new int[n];
        arr = new ArrayList[n];
        hang = new int[n];
        for(int i = 0; i < n; i++) arr[i] = new ArrayList<Integer>();
        for(int[] a: path) {
            arr[a[0]].add(a[1]);
            arr[a[1]].add(a[0]);
        }
        for(int[] a: order) previsit[a[1]] = a[0];

        if(previsit[0] != 0) return false;

        visited[0] = true;

        for(int v: arr[0]) DFS(v);

        for(boolean b: visited) {
            if(!b) return false;
        }
        return true;
    }
    private static void DFS(int v) {
        if(visited[v]) return;

        if(!visited[previsit[v]]) {
            hang[previsit[v]] = v;
            return;
        }

        visited[v] = true;
        DFS(hang[v]);

        for(int tempV: arr[v]) DFS(tempV);
    }
}