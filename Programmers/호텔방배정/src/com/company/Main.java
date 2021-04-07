package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int k = 10;
        long[] room_number = {1,3,2};
        long[] result = (new Solution()).solution(k,room_number);
        
        for(long l: result) System.out.println(l);
    }
}

class Solution {
    private static Map<Long,Long> parent = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for(int i = 0; i < room_number.length; i++) {
            long r = room_number[i];
            if(parent.containsKey(r)) {
                long nextNum = find(r) + 1;
                long temp = -1;
                parent.put(nextNum, temp);
                union(nextNum, r);
                answer[i] = nextNum;
                if(parent.containsKey(nextNum+1)) {
                    union(nextNum, nextNum+1);
                }
            } else {
                long temp = -1;
                parent.put(r,temp);
                answer[i] = r;
                if(parent.containsKey(r-1)) {
                    union(r,r-1);
                }
                if(parent.containsKey(r+1)) {
                    union(r, r+1);
                }
            }
        }



        return answer;
    }

    private static long find(long a) {
        if(parent.get(a) < 0) return a;
        else {
            long y = find(parent.get(a));
            parent.put(a, y);
            return y;
        }
    }

    private static void union(long a, long b) {
        long parentA = find(a);
        long parentB = find(b);
        if(a > b) {
            parent.put(parentA, parent.get(parentA) + parent.get(parentB));
            parent.put(parentB, parentA);
        } else {
            parent.put(parentB, parent.get(parentB) + parent.get(parentA));
            parent.put(parentA, parentB);
        }
    }
}
