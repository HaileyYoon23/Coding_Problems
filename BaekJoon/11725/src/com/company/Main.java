package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int[] result;
    public static ArrayList<ArrayList<Integer>> matrix;
    public static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new ArrayList<ArrayList<Integer>>();
        result = new int[N+1];

        for(int i = 0; i <= N+1; i++) {
            matrix.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < N-1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            matrix.get(a).add(b);
            matrix.get(b).add(a);
        }
        BFS(1);
        for(int i = 2; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    public static void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int nextNode: matrix.get(node)) {
                if(result[nextNode] == 0) {
                    result[nextNode] = node;
                    queue.add(nextNode);
                }
            }
        }
    }
}
