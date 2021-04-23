package com.company;

import java.util.*;
import java.io.*;

public class Main {
    private static Tree tree;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    StringBuffer sb = new StringBuffer();
	    while((T--) > 0) {
	        int N = Integer.parseInt(br.readLine());
	        boolean solved = false;
            tree = new Tree();
	        while((N--) > 0) {
                int[] numList = Arrays.stream(br.readLine().split("(?!^)"))
                        .mapToInt(Integer::parseInt).toArray();
                if(!insertNodes(numList) && !solved) {
                    solved = true;
                    sb.append("NO\n");
                }
            }
	        if(!solved) sb.append("YES\n");
        }
	    System.out.println(sb);
    }
    private static boolean insertNodes(int[] numList) {
        Tree currentTree = tree;
        for(int v: numList) {
            if(currentTree.isTerminate) return false;
            currentTree.count++;
            if(currentTree.nodeList[v] == null) {
                currentTree.nodeList[v] = new Tree();
            }
            currentTree = currentTree.nodeList[v];
        }
        if(currentTree.isTerminate) return false;
        if(currentTree.count == 0) {
            currentTree.isTerminate = true;
        } else {
            return false;
        }
        return true;
    }
}

//class Node {
//    int num;
//    boolean isTerminate;
//}

class Tree {
    Tree[] nodeList = new Tree[10];
    int count;
    boolean isTerminate;
//    Node curNode;
    Tree() {
        for(int i = 0; i < 10; i++) {
            this.nodeList[i] = null;
        }
        count = 0;
        isTerminate = false;
    }
}