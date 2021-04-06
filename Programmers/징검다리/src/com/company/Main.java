package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] stones = {1,2,2,1,1,1,1,1,1};
	    int k = 3;
	    System.out.println((new Solution()).solution(stones,k));
    }
}

class Solution {
    private static int start = 0;
    private static int end = 200_000_000;

    public int solution(int[] stones, int k) {
        int answer = 0;

        while(start < end) {
            int mid = (start + end) / 2;
            if(canCross(stones, mid, k)) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return end-1;
    }
    public static boolean canCross(int[] stones, int threshold, int k) {
        int len = 0;
        int maxLen = 0;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] < threshold) {
                len++;
            } else {
                maxLen = Integer.max(maxLen, len);
                len = 0;
            }
        }
        maxLen = Integer.max(maxLen, len);
        if(maxLen >= k) return false;
        return true;
    }
}