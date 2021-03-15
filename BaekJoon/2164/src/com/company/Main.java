package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int result = 0;
        int N = Integer.valueOf(br.readLine());
        int count = 1;

        if(N == 1) {
            System.out.println(1);
            return;
        }
        for(int i = 1; i <= N; i++) {
            deque.addLast(i);
        }
        while(deque.size() != 1) {
            if(count == 1) {
                deque.removeFirst();
                count *= -1;
            } else {
                deque.addLast(deque.pollFirst());
                count *= -1;
            }
        }
        System.out.println(deque.poll());
    }
}
