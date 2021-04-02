package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static Node[] segTree;
    public static int N , M;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        double H = Math.ceil(logConfig(2,N)); int len = (int)Math.pow(2,H+1);
        segTree = new Node[len];
        arr = new int[N+1];
        for(int n = 1; n <= N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }
        init(1,1,N);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Node result = getNode(1,1,N,start,end);
            sb.append(String.format("%d %d\n",result.min,result.max));
        }
        System.out.println(sb);
    }
    public static Node getNode(int index, int start, int end, int left, int right) {
        if(start > right || end < left) return new Node(0,1_000_000_000);
        else if(left <= start && end <= right)
            return segTree[index];
        else {
            int mid = (start + end) / 2;
            Node node1 = getNode(index*2, start, mid, left, right);
            Node node2 = getNode(index*2+1, mid+1, end, left, right);
            return new Node(Integer.max(node1.max,node2.max),Integer.min(node1.min, node2.min));
        }

    }
    public static Node init(int index, int start, int end) {
        if(start == end) {
            return segTree[index] = new Node(arr[start],arr[start]);
        }
        int mid = (start + end) / 2;
        segTree[index*2] = init(index*2, start, mid);
        segTree[index*2 + 1] = init(index*2 + 1, mid+1, end);
        return segTree[index] = new Node(Integer.max(segTree[index*2].max,segTree[index*2+1].max),
                Integer.min(segTree[index*2].min,segTree[index*2+1].min));
    }
    public static double logConfig(int base, int value) {
        return Math.log(value) / Math.log(base);
    }
}
class Node {
    int max;
    int min;
    Node(int max, int min) {
        this.max = max;
        this.min = min;
    }
}