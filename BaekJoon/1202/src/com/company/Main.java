package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int N, K;
    public static PriorityQueue<Jewelry> jewelry = new PriorityQueue<>(new Comparator<Jewelry>() {
        @Override
        public int compare(Jewelry o1, Jewelry o2) {
            if(o1.value > o2.value) return -1;
            else if(o1.value < o2.value) return 1;
            else {
                if(o1.mass > o2.mass) return 1;
                else if(o1.mass < o2.mass) return -1;
                else return 0;
            }
        }
    });
    public static List<Integer> bag = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int mass = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewelry.add(new Jewelry(mass, value));
        }
        for (int i = 0; i < K; i++) {
            int size = Integer.parseInt(br.readLine());
            bag.add(size);
        }
        Collections.sort(bag);          // BST UPPERBOUND
        while (!jewelry.isEmpty() && !bag.isEmpty()) {
            Jewelry jw = jewelry.poll();
            if (bag.get(bag.size() - 1) < jw.mass) continue;
            int index = lowerbound(jw.mass);
            bag.remove(index);
            sum += jw.value;
        }
        System.out.println(sum);
    }
    public static int lowerbound(int mass) {
        int start = 0;
        int end = bag.size() - 1;
        int mid;
        while(start < end) {
            mid = (start + end) / 2;
            if(bag.get(mid) < mass) {
                start = mid + 1;
            } else end = mid;
        }
        return end;
    }
}

class Jewelry {
    int mass;
    int value;
    Jewelry(int mass, int value) {
        this.mass = mass;
        this.value = value;
    }
}