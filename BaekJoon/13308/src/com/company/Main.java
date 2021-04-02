package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[] prices;
    public static boolean[][] checked;
    public static ArrayList<ArrayList<Node>> matrix = new ArrayList<>();
    public static PriorityQueue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.distance - o2.distance;
        }
    });
    public static void main(String[] args) throws IOException {
        // Initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        prices = new int[N+1];
        checked = new boolean[N+1][2501];
        matrix.add(new ArrayList<Node>());
        for(int i = 1; i <= N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
            matrix.add(new ArrayList<Node>());
        }
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            matrix.get(start).add(new Node(end,len));
            matrix.get(end).add(new Node(start,len));
        }

        // Activation
        int result = dijkstra();

        // Result
        System.out.println(result);
    }
    public static int dijkstra() {
        queue.add(new Point(1,prices[1], 0));
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            int index = now.index;
            int cost = now.cost;
            int distance = now.distance;
            if(checked[index][cost]) continue;
            if(index == N) return distance;
            checked[index][cost] = true;
            for(Node next: matrix.get(index)) {
                queue.add(new Point(next.index, Integer.min(cost, prices[next.index])
                        ,distance + next.length * cost));
            }
        }
        return -1;
    }
}

class Node {
    int index;
    int length;
    Node(int index, int length) {
        this.index = index;
        this.length = length;
    }
}
class Point {
    int index;
    int cost;
    int distance;
    Point(int index, int cost, int distance) {
        this.index = index;
        this.cost = cost;
        this.distance = distance;
    }
}