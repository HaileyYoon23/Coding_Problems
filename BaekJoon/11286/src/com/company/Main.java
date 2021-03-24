package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static PriorityQueue<Long> priqueue = new PriorityQueue<>(100_000,
            new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    double absO1 = Math.abs(o1);
                    double absO2 = Math.abs(o2);
                    if(absO1 > absO2) return 1;
                    else if(absO1 < absO2) return -1;
                    else {
                        if(o1 < o2) return -1;
                        else if(o1 > o2) return 1;
                        else return 0;
                    }
                }
            });
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            long input = Long.parseLong(br.readLine());
            if(input == 0) {
                if(priqueue.isEmpty()) {
                    sb.append(0+"\n");
                } else {
                    long out = priqueue.remove();
                    sb.append(out+"\n");
                }
            } else {
                priqueue.add(input);
            }
        }
        System.out.println(sb);
    }
}