package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] result = (new Solution()).solution(s);
        for(int r: result) System.out.println(r);
    }
}

class Solution {
    private static PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.num - o2.num;
        }
    });
    public int[] solution(String s) {
        String tempS = s.substring(1, s.length()-2);
        String[] numsList =  tempS.split("},");
        for(String str: numsList) {
            String[] tempStrs = str.substring(1,str.length()).split(",");
            int count = tempStrs.length;
            int sum = 0;
            for(String num: tempStrs) {
                sum += Integer.parseInt(num);
            }
            queue.add(new Node(count, sum));
        }
        int[] answer = new int[queue.size()];
        int beforeSum = 0;
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            answer[n.num-1] = n.sum - beforeSum;
            beforeSum = n.sum;
        }
        return answer;
    }
}

class Node {
    int num;
    int sum;
    Node(int num, int sum) {
        this.num = num;
        this.sum = sum;
    }
}