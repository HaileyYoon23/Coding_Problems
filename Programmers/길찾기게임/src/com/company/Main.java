package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    int[][] nodeInfo = {{5,3}, {11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        System.out.println((new Solution()).solution(nodeInfo));
    }
}

class Solution {
    private static PriorityQueue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            int diffY = o2.j - o1.j;
            if(diffY != 0) return diffY;
            else return o1.i - o2.i;
        }
    });
    private static ArrayList<Integer> preTree = new ArrayList<>();
    private static ArrayList<Integer> postTree = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int count = 0;
        for(int[] arr: nodeinfo) queue.add(new Point(++count, arr[0], arr[1]));
        Point root = queue.poll();
        Tree rootTree = new Tree(root);
        while(!queue.isEmpty()) {
            Tree currentTree = rootTree;
            Point curPoint = queue.poll();
            boolean find = false;
            while(!find) {
                if(curPoint.i < currentTree.p.i) {      // 왼쪽 좌표
                    if(currentTree.left == null) {
                        currentTree.left = new Tree(curPoint);
                        find = true;
                    } else {
                        currentTree = currentTree.left;
                    }
                } else {                                // 오른쪽 좌표
                    if(currentTree.right == null) {
                        currentTree.right = new Tree(curPoint);
                        find = true;
                    } else {
                        currentTree = currentTree.right;
                    }
                }
            }
        }
        preTreePrint(rootTree);
        postTreePrint(rootTree);

        int[][] answer = new int[2][preTree.size()];
        for(int i = 0; i < answer[0].length; i++) {
            answer[0][i] = preTree.get(i);
            answer[1][i] = postTree.get(i);
        }

        return answer;
    }
    private static void preTreePrint(Tree tree) {
        preTree.add(tree.p.index);
        if(tree.left != null) preTreePrint(tree.left);
        if(tree.right != null) preTreePrint(tree.right);
    }

    private static void postTreePrint(Tree tree) {
        if(tree.left != null) postTreePrint(tree.left);
        if(tree.right != null) postTreePrint(tree.right);
        postTree.add(tree.p.index);
    }
}
class Tree {
    Point p;
    Tree left;
    Tree right;
    Tree() { }
    Tree(Point p) {
        this.p = p;
        this.left = null;
        this.right = null;
    }
}

class Point {
    int index;
    int i;
    int j;
    Point(int index, int i, int j) {
        this.index = index;
        this.i = i;
        this.j = j;
    }
}