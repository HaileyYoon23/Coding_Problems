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
        int N = Integer.valueOf(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        Object temp;
        for(int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case("push_front"):
                    deque.addFirst(Integer.valueOf(command[1]));
                    break;
                case("push_back"):
                    deque.addLast(Integer.valueOf(command[1]));
                    break;
                case("pop_front"):
                    temp = deque.pollFirst();
                    if(temp == null) {
                        sb.append(-1+"\n");
                    } else {
                        sb.append(temp+"\n");
                    }
                    break;
                case("pop_back"):
                    temp = deque.pollLast();
                    if(temp == null) {
                        sb.append(-1+"\n");
                    } else {
                        sb.append(temp+"\n");
                    }
                    break;
                case("size"):
                    sb.append(deque.size()+"\n");
                    break;
                case("empty"):
                    if(deque.isEmpty()) {
                        sb.append(1+"\n");
                    } else {
                        sb.append(0+"\n");
                    }
                    break;
                case("front"):
                    if(deque.isEmpty()) {
                        sb.append(-1+"\n");
                    } else {
                        sb.append(deque.peekFirst()+"\n");
                    }
                    break;
                case("back"):
                    if(deque.isEmpty()) {
                        sb.append(-1+"\n");
                    } else {
                        sb.append(deque.peekLast()+"\n");
                    }
                    break;
            }

        }
        System.out.println(sb);
    }
}
