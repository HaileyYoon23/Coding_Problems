package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static ArrayList<ArrayList<Integer>> matrix;
    public static Node[] nodeList;
    public static int[] numOfLine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while((T--) > 0) {
            matrix = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            nodeList = new Node[N+1];
            numOfLine = new int[N+1];
            int root = 0;
            for(int i = 0; i <= N; i++) matrix.add(new ArrayList<Integer>());
            for(int i = 1; i <= N-1; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                matrix.get(parent).add(child);
                numOfLine[child]++;
            }
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            for(root = 1; root <= N; root++) {
                if(numOfLine[root] == 0) break;
            }

            nodeList[root] = new Node(-1,1);
            DFS(root, 1);

            int node1Depth = nodeList[node1].depth;
            int node2Depth = nodeList[node2].depth;
            if(node1Depth < node2Depth) {
                node2 = findParentOfDepth(node2, node1Depth);
            } else if(node1Depth > node2Depth) {
                node1 = findParentOfDepth(node1, node2Depth);
            }
            sb.append(compareBothParent(node1, node2) + "\n");
        }
        System.out.println(sb);
    }

    public static int compareBothParent(int lhs, int rhs) {
        boolean result = false;
        while(lhs != rhs) {
            lhs = nodeList[lhs].parentIdx;
            rhs = nodeList[rhs].parentIdx;
        }
        return lhs;
    }
    public static void DFS(int parent, int depth) {
        for(int child: matrix.get(parent)) {
            nodeList[child] = new Node(parent, depth+1);
            DFS(child, depth + 1);
        }
    }
    public static int findParentOfDepth(int child, int depthToFind) {
        int curDepth = nodeList[child].depth;
        int parent = child;
        while(curDepth > depthToFind) {
            child = parent;
            parent = nodeList[child].parentIdx;
            curDepth = nodeList[child].depth;
        }
        return child;
    }
    public static int getParent(int child) {
        return nodeList[child].parentIdx;
    }
}

class Node {
    int parentIdx;
    int depth;
    Node(int parentIndex, int depth) {
        this.parentIdx = parentIndex;
        this.depth = depth;
    }
}
