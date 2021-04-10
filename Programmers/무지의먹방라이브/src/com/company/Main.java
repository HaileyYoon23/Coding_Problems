package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    int[] food_times = {4,1,1,5};
	    int k = 4;
	    System.out.println((new Solution()).solution(food_times, k));
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        int N = food_times.length;
        long sum = 0;

        ArrayList<Node> foodTimes = new ArrayList<>();
        for(int i = 0; i < food_times.length; i++) {
            foodTimes.add(new Node(i,food_times[i]));
        }
        long tempK = k;

        while(true) {
            if(foodTimes.size() == 0) return -1;
            long temp = tempK / foodTimes.size();
            int index = 0;
            while(index < foodTimes.size()) {
                Node node = foodTimes.get(index);
                int value = node.value;
                if(temp >= value) {
                    sum += value;
                    foodTimes.remove(index);
                } else {
                    sum += temp;
                    foodTimes.set(index,new Node(node.index,value - (int)temp));
                    index++;
                }
            }

            tempK = k - sum;

            if(tempK + 1 <= foodTimes.size()) return (foodTimes.get((int)tempK).index) % N + 1;

        }

    }
}

class Node {
    int index;
    int value;
    Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}