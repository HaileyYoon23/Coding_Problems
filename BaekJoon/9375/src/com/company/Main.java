package com.company;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static Map<String, List> clothes = new HashMap<>();
    public static List<String> clothType = new LinkedList<>();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int sum = 1;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            sum = 1;
            int N = Integer.parseInt(br.readLine());
            clothes = new HashMap<>();
            clothType = new LinkedList<>();
            for(int n = 0; n < N; n++) {
                String[] input = br.readLine().split(" ");
                if(!clothes.containsKey(input[1])) {
                    clothes.put(input[1], new LinkedList<String>());
                    clothType.add(input[1]);
                }
                clothes.get(input[1]).add(input[0]);
            }
            for(int i = 0; i < clothType.size(); i++) {
                sum *= (clothes.get(clothType.get(i)).size() + 1);
            }
            sb.append((sum-1) + "\n");
        }
        System.out.println(sb);
    }
}

