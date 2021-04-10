package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    int n = 5;
	    int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
	    int[] result = (new Solution()).solution(n,stages);
	    for(int r: result) System.out.println(r);
    }
}

class Solution {
    private static Map<Integer, Info> map = new HashMap<>();
    public int[] solution(int N, int[] stages) {
        PriorityQueue<Node> arr = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.fail < o2.fail) return 1;
                else if(o1.fail > o2.fail) return -1;
                else {
                    if(o1.stage > o2.stage) return 1;
                    return -1;
                }
            }
        });
        int len = stages.length;
        Arrays.sort(stages);
        int maxStage = stages[stages.length-1];
        int num = stages[0];
        int count = 1;
        int firstIndex = 0;

        for(int i = 1; i < stages.length; i++) {
            int curStage = stages[i];
            if(num == curStage) {
                count++;
            } else {
                map.put(num, new Info(firstIndex, count));
                num = curStage;
                firstIndex = i;
                count = 1;
            }
            if(i == stages.length-1) {
                map.put(num, new Info(firstIndex, count));
            }
        }

        for(int i = 1; i <= N; i++) {
            if(!map.containsKey(i)) {
                arr.add(new Node(i,0));
            } else {
                Info info = map.get(i);
                double fail = (double) info.count / (len - info.index);
                arr.add(new Node(i,fail));
            }
        }


        int[] answer = new int[arr.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = arr.poll().stage;
        }

        return answer;
    }
}

class Info {
    int index;
    int count;
    Info(int index, int count) {
        this.index = index;
        this.count = count;
    }
}
class Node {
    int stage;
    double fail;
    Node(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }
}