package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] numOfLine;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numOfLine = new int[N+1];
        for(int i = 0; i <= N; i++) {
            arr.add(new ArrayList<Integer>());
        }
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int smaller = Integer.parseInt(st.nextToken());
            int taller = Integer.parseInt(st.nextToken());
            arr.get(smaller).add(taller);
            numOfLine[taller]++;
        }
        topologicalSort();
        System.out.println(sb);
    }

    public static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(numOfLine[i] == 0) {
                numOfLine[i] = -1;
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node+" ");
            for(int taller: arr.get(node)) {
                numOfLine[taller]--;
            }
            for(int i = 1; i <= N; i++) {
                if(numOfLine[i] == 0) {
                    numOfLine[i] = -1;
                    queue.add(i);
                }
            }
        }
    }
}
