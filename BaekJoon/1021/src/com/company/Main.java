package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int N = Integer.valueOf(input1[0]);
        int M = Integer.valueOf(input1[1]);
        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        int size = 0;
        int sum = 0;
        int value = 0;

        // Initialization
        for(int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        for(int i = 0; i < M;) {
            value = Integer.valueOf(input2[i]);
            size = deque.size();
            if(deque.peekFirst() == value) {
                sum += Integer.min(count, size - count);
                deque.pollFirst();
                count = 0;
                i++;
            } else {
                deque.addLast(deque.pollFirst());
                count++;
            }
        }
        System.out.println(sum);
    }
}
