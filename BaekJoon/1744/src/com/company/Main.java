package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static PriorityQueue<Integer> pluses = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public static PriorityQueue<Integer> minuses = new PriorityQueue<>();
    public static int sum = 0;
    public static boolean isZero = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 0) pluses.add(num);
            else if(num < 0) minuses.add(num);
            else isZero = true;
        }
        while(pluses.size() > 1) {
            int max1 = pluses.poll();
            int max2 = pluses.poll();
            if(max1 + max2 < max1 * max2) {
                sum += max1 * max2;
            } else {
                sum += (max1 + max2);
            }
        }
        if(!pluses.isEmpty()) sum += pluses.poll();

        while(minuses.size() > 1) {
            int max1 = minuses.poll();
            int max2 = minuses.poll();
            sum += max1 * max2;
        }
        if(!minuses.isEmpty()) {
            if(!isZero) sum += minuses.poll();
        }

        System.out.println(sum);
    }
}
