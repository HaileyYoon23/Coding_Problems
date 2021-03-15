package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            Object result = 0;
            switch (command[0]) {
                case ("push"):
                    deque.addLast(Integer.valueOf(command[1]));
                    break;
                case ("pop"):
                    if((result = deque.pollFirst()) != null) {
                        sb.append(result + "\n");
                    } else {
                        sb.append(-1 + "\n");
                    }
                    break;
                case ("size"):
                    sb.append(deque.size() + "\n");
                    break;
                case ("empty"):
                    if(deque.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case ("front"):
                    result = deque.peekFirst();
                    if(result == null) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(result + "\n");
                    }
                    break;
                case ("back"):
                    result = deque.peekLast();
                    if(result == null) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(result + "\n");
                    }

                    break;
            }
        }
        System.out.println(sb);
    }
}
