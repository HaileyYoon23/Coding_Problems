package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static PriorityQueue<Integer> arr = new PriorityQueue<>();
    public static int compareSum = 0;
    public static int result = 0;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        while(arr.size() != 1) {
            compareSum = arr.poll() + arr.poll();
//            arr.remove(0);
            arr.add(compareSum);
            result += compareSum;
        }
        System.out.println(result);

    }
}
