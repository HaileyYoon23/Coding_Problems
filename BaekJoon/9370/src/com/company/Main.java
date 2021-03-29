package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int n,m,t,s,g,h;
    public static ArrayList<Integer> candidatePos = new ArrayList<>();
    public static List<Node>[] matrixList;
    public static long[] distance;
    public static boolean[] visited;
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
        int T = Integer.parseInt(br.readLine());
        while((T--) > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            distance = new long[n+1];
            Arrays.fill(distance,INF);
            candidatePos = new ArrayList<>();
            matrixList = new ArrayList[n+1];
            visited = new boolean[n+1];
            for(int i = 1; i <= n; i++) {
                matrixList[i] = new ArrayList<>();
            }
            for(int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken()) * 2;
                if((start == g && end == h) || (start == h && end == g)) {
                    len -= 1;
                }
                matrixList[start].add(new Node(end,len));
                matrixList[end].add(new Node(start,len));
            }
            for(int i = 0; i < t; i++) {
                candidatePos.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(candidatePos);
            distance[s] = 0;
            queue.add(new Node(s,0));
            dijkstra();
            for(int i = 0; i < t; i++) {
                int tempIdx = candidatePos.get(i);
                if(distance[tempIdx] % 2 > 0 & distance[tempIdx] != INF) {
                    sb.append(tempIdx+" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void dijkstra() {
        while(!queue.isEmpty()) {
            Node minNode = queue.poll();
            if(visited[minNode.index]) continue;
            for(Node nextNode: matrixList[minNode.index]) {
                if(visited[nextNode.index]) continue;
                long minDist = distance[minNode.index];
                long nextDist = distance[nextNode.index];
                long newDistAdd = nextNode.value;
                if(nextDist > minDist + newDistAdd) {
                    // 그들이 간 경로 체크
                    distance[nextNode.index] = minDist + newDistAdd;
                    queue.add(new Node(nextNode.index, distance[nextNode.index]));
                }
            }
            visited[minNode.index] = true;
        }
    }
}
class Node {
    int index;
    long value;
    Node(int index, long value) {
        this.index = index;
        this.value = value;
    }
    @Override
    public boolean equals(Object obj) {
        final Node other = (Node) obj;
        if(this.index == other.index) {
            return true;
        }
        return false;
    }
}
