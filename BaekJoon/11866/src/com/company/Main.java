package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 1;
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 1; i <= N; i++) {
            deque.addLast(i);
        }
        while(deque.size() != 1) {
            if(count == K) {
                temp = deque.pollFirst();
                count = 1;
                sb.append(temp+", ");
            } else {
                temp = deque.pollFirst();
                deque.addLast(temp);
                count++;
            }

        }

        sb.append(deque.poll()+">");
        System.out.println(sb);
    }
}
