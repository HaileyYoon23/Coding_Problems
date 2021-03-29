package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int V, E;
    public static ArrayList<Node> arr = new ArrayList<>();
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int result = 0;
        parent = new int[V+1];
        for(int i = 0; i <= V; i++) parent[i] = i;
        for(int e = 1; e <= E; e++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            arr.add(new Node(start,end,len));
        }
        Collections.sort(arr);
        for(int i = 0; i < E; i++) {
            Node node = arr.get(i);
            if(find(node.start) != find(node.end)) {
                result += node.length;
                union(node.start,node.end);
            }
        }
        System.out.println(result);
    }
    public static int find(int index) {
        if(index == parent[index]) return index;
        return parent[index] = find(parent[index]);
    }
    public static void union(int index1, int index2) {
        int root1 = find(index1);
        int root2 = find(index2);
        if(root1 == root2) return;
        else {
            parent[root2] = root1;
        }
    }
}

class Node implements Comparable<Node>{
    int start;
    int end;
    int length;
    Node(int s, int e, int len) {
        this.start = s;
        this.end = e;
        this.length = len;
    }

    @Override
    public int compareTo(Node o) {
        if(this.length > o.length) return 1;
        else if(this.length < o.length) return -1;
        return 0;
    }
}
