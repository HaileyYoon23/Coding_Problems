package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Node> arr = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited = new boolean[10_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int index = 0;
        int N = Integer.parseInt(str);
        arr.add(new Node(true,false,-1,-1,N,-1,-1));
        str = br.readLine();

        while(str != null && !str.equals("")) {
            N = Integer.parseInt(str);
            int rootIdx = 0, rootValue = 0, upperIdx = 0, upperValue = 0;
            boolean loop = true;
            do {
                rootValue = arr.get(rootIdx).myValue;
                if(N > rootValue) {
                    if(arr.get(rootIdx).rightChildIndex == -1) {
                        arr.add(new Node(false, false,rootValue,rootIdx,N,-1,-1));
                        arr.get(rootIdx).rightChildIndex = index + 1;
                        index++;
                        loop = false;
                    } else {
                        rootIdx = arr.get(rootIdx).rightChildIndex;
                    }
                } else {
                    if(arr.get(rootIdx).leftChildIndex == -1) {
                        arr.add(new Node(false, true,rootValue,rootIdx,N,-1,-1));
                        arr.get(rootIdx).leftChildIndex = index + 1;
                        index++;
                        loop = false;
                    } else {
                        rootIdx = arr.get(rootIdx).leftChildIndex;
                    }
                }
            } while(loop);
            str = br.readLine();
        }
        printPostTree(0);
        System.out.println(sb);
    }
    public static void printPostTree(int rootIdx){
        Node node = arr.get(rootIdx);
        if(node.leftChildIndex != -1) {
            printPostTree(node.leftChildIndex);
        }
        if(node.rightChildIndex != -1) {
            printPostTree(node.rightChildIndex);
        }
        if(!visited[rootIdx]){
            visited[rootIdx] = true;
            sb.append(node.myValue + "\n");
        }
    }
}
class Node {
    boolean isRoot;
    boolean amILeftChild;
    int parentValue;
    int parentIndex;
    int myValue;
    int leftChildIndex;
    int rightChildIndex;
    Node(boolean isR, boolean amIL, int p, int pIdx, int m, int lCI, int rCI) {
        this.isRoot = isR;
        this.amILeftChild = amIL;
        this.parentValue = p;
        this.parentIndex = pIdx;
        this.myValue = m;
        this.leftChildIndex = lCI;
        this.rightChildIndex = rCI;
    }
}
