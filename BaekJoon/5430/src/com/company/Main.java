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
        int T = Integer.valueOf(br.readLine());
        String script = new String();
        String[] inputs;
        int num = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int order = 1;      // 1 : normal, -1 : reverse
        StringBuilder sb = new StringBuilder();
        int size = 0;
        boolean isValid = true;

        for(int t = 0; t < T; t++) {
            isValid = true;
            order = 1;
            size = 0;
            deque = new ArrayDeque<>();
            script = br.readLine();
            num = Integer.valueOf(br.readLine());
            inputs = br.readLine().replace("[","").replace("]","").split(",");
            if(num > 0) {
                for(int i = 0; i < inputs.length; i++) {
                    deque.addLast(Integer.valueOf(inputs[i]));
                }
            }
            for(int i = 0; i < script.length(); i++) {
                char curTest = script.charAt(i);
                switch (curTest){
                    case ('R'):
                        order *= -1;
                        break;
                    case ('D'):
                        if(deque.size() == 0) {
                            i = script.length();
                            isValid = false;
                            break;
                        } else {
                            if(order == 1) {    // order : normal
                                deque.removeFirst();
                            } else {            // order : reverse
                                deque.removeLast();
                            }
                        }
                        break;
                }
            }
            if(!isValid) {
                sb.append("error\n");
            } else {
                sb.append("[");
                size = deque.size();
                for(int i = 0; i < size; i++) {
                    if(order == 1) {
                        sb.append(deque.pollFirst());
                    } else {
                        sb.append(deque.pollLast());
                    }
                    if(size-i > 1) sb.append(",");
                }
                sb.append("]\n");
            }

        }
        System.out.println(sb);
    }
}
