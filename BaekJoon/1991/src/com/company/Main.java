package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static node[] tree;
    public static int N;
    public static boolean[] printed;
    public static StringBuilder sb1 = new StringBuilder();
    public static StringBuilder sb2 = new StringBuilder();
    public static StringBuilder sb3 = new StringBuilder();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new node[N+1];
        printed = new boolean[N+1];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int nodeNum = input[0].charAt(0) - 'A';
            int leftNode = (input[1].equals(".")) ? -1 : input[1].charAt(0) - 'A';
            int rightNode = (input[2].equals(".")) ? -1 : input[2].charAt(0) - 'A';
            tree[nodeNum] = new node(leftNode, rightNode);
        }
        sb1.append(Character.toString(0+'A'));
        DFS1(0);
        printed = new boolean[N+1];
        DFS2(0);
        printed = new boolean[N+1];
        DFS3(0);
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb3);
    }
    public static void DFS1(int s) {
        int left = tree[s].left;
        int right = tree[s].right;

        printed[s] = true;
        if(left != -1) {
            sb1.append(Character.toString(left+'A'));
            DFS1(tree[s].left);
        }
        if(right != -1) {
            sb1.append(Character.toString(right+'A'));
            DFS1(tree[s].right);
        }
    }

    public static void DFS2(int s) {
        int left = tree[s].left;
        int right = tree[s].right;

        if(left == -1 && right == -1) return;
        if(left != -1 && printed[left] == false) {
            DFS2(tree[s].left);
            if(printed[left] == false) {
                sb2.append(Character.toString(left+'A'));
                printed[left] = true;
            }
        }
        if(printed[s] == false) {
            sb2.append(Character.toString(s+'A'));
            printed[s] = true;
        }
        if(right != -1 && printed[right] == false) {
            DFS2(tree[s].right);
            if(printed[right] == false) {
                sb2.append(Character.toString(right+'A'));
                printed[right] = true;
            }

        }
    }
    public static void DFS3(int s) {
        int left = tree[s].left;
        int right = tree[s].right;

        if(left == -1 && right == -1) return;
        if(left != -1 && printed[left] == false) {
            DFS3(tree[s].left);
            if(printed[left] == false) {
                sb3.append(Character.toString(left+'A'));
                printed[left] = true;
            }
        }

        if(right != -1 && printed[right] == false) {
            DFS3(tree[s].right);
            if(printed[right] == false) {
                sb3.append(Character.toString(right+'A'));
                printed[right] = true;
            }

        }
        if(printed[s] == false) {
            sb3.append(Character.toString(s+'A'));
            printed[s] = true;
        }
    }
}


class node {
    int left;
    int right;
    node() {
        this.left = -1;
        this.right = -1;
    }
    node(int l, int r) {
        this.left = l;
        this.right = r;
    }

}
