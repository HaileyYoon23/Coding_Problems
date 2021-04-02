package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static PriorityQueue<Integer> queue = new PriorityQueue<>();
    public static int maxWeight = 0;

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            queue.add(n);
        }
        while(!queue.isEmpty()) {
            maxWeight = Integer.max(maxWeight, (queue.size()) * queue.poll());
        }
        System.out.println(maxWeight);
    }
}
