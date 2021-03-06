package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int V, E, startPoint;
    public static List<Node>[] matrixArr;
    public static boolean[] checked;
    public static int[] distance;
    public static int INF = Integer.MAX_VALUE;
    public static Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.value > o2.value) return 1;
            else if(o1.value < o2.value) return -1;
            else return 0;
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String[] info = br.readLine().split(" ");
        V = Integer.parseInt(info[0]);
        E = Integer.parseInt(info[1]);
        startPoint = Integer.parseInt(br.readLine());
        matrixArr = new ArrayList[V+1];
        distance = new int[V+1];
        checked = new boolean[V+1];
        Arrays.fill(distance, INF);
        for(int i = 1; i <= V; i++) {
            matrixArr[i] = new ArrayList<>();
        }
        for(int e = 1; e <= E; e++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            matrixArr[start].add(new Node(end,len));
        }

        distance[startPoint] = 0;
        queue.add(new Node(startPoint,0));
        djikstra();
        for(int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else sb.append(distance[i]+"\n");
        }
        System.out.println(sb);
    }
    public static void djikstra() {
        while(!queue.isEmpty()) {
            Node minNode = queue.poll();
            if(checked[minNode.index]) continue;
            for(Node nextNode: matrixArr[minNode.index]) {
                if(checked[nextNode.index]) continue;
                int minDist = distance[minNode.index];
                int nextDist = distance[nextNode.index];
                int newDistAdd = nextNode.value;
                if(nextDist > minDist + newDistAdd) {
                    distance[nextNode.index] = minDist + newDistAdd;
                    queue.add(new Node(nextNode.index, distance[nextNode.index]));
                }
            }
            checked[minNode.index] = true;
        }
    }
    public static class Node{
        int index;
        int value;
        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
        @Override
        public boolean equals(Object obj) {
            final Node other = (Node) obj;
            if (this.index == other.index) {
                return true;
            }
            return false;
        }
    }
}

