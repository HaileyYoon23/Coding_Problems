package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static PriorityQueue<Integer> priqueue = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(priqueue.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(priqueue.remove() + "\n");
                }
            } else {
                priqueue.add(input);
            }
        }
        System.out.println(sb);
    }

}
