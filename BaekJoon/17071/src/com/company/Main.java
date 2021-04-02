package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int INF = 500_000;
    public static int N,K;
    public static int count;
    public static int[] visited = new int[INF+2];       // 홀수 1, 짝수 2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        if(N == K) System.out.println(0);
        else System.out.println(BFS(N));

    }
    public static int BFS(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n,0,K));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int tempCount = node.count;
            int[] numList = {node.x + 1, node.x * 2 ,node.x - 1};
            int iLimit = 3;
            if(node.x < node.k) {
                iLimit = 2;
            }
            for(int i = 0; i < iLimit; i++) {
                if(node.k > INF) return -1;
                if(numList[i] >= 0 && numList[i] <= INF) {
                    queue.add(new Node(numList[i],tempCount+1, node.k + (tempCount + 1)));
                    visited[numList[i]] = ((tempCount + 1) % 2 == 0) ? 2 : 1;
                    if(visited[node.k + tempCount + 1] > 0) {
                        boolean nodeX = (visited[node.k + tempCount + 1] % 2 == 0);
                        boolean nodeY = ((tempCount+1) % 2 == 0);
                        if(nodeX == nodeY) {
                            return tempCount + 1;
                        }
                    }
                    if(numList[i] == node.k + tempCount + 1) {   // find brother
                        return tempCount + 1;
                    }
                }
            }
        }
        return -1;
    }
}
class Node{
    int x;
    int count;
    int k;
    Node(int x, int  count, int k) {
        this.x = x;
        this.count = count;
        this.k = k;
    }
}