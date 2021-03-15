package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception{
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        List<String> valueStr = Arrays.asList(br.readLine().split(" "));
        List<Integer> valueInt = valueStr.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < N; i++) {
            while(!s.empty() && valueInt.get(s.peek()) < valueInt.get(i)) {
                valueInt.set(s.pop(), valueInt.get(i));
            }
            s.push(i);
        }
        while(!s.empty()) {
            valueInt.set(s.pop(), -1);
        }
        for(int i = 0; i < N; i++) {
            System.out.print(valueInt.get(i) +" ");
        }

    }
}

