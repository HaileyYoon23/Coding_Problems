package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
	    int[] result = (new Solution()).solution(gems);
	    System.out.println(String.format("%d %d",result[0], result[1]));
    }
}


class Solution {
    private static Map<String,Integer> gemSet = new HashMap<>();
    private static int[] isGemExist;
    private static int gemCount = 0;
    private static int start = 0, end = 0, length = 0, gemCountCheck = 0;
    private static int resultStart, resultEnd, minLength = 100_001;
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int len = gems.length;
        for(int i = 0; i < len; i++) {
            if(!gemSet.containsKey(gems[i])) {
                gemSet.put(gems[i], gemCount);
                gemCount++;
            }
        }
        isGemExist = new int[gemCount];

        for(int i = 0; (i < len && start < len) || gemCountCheck == gemCount;) {
            if(gemCountCheck == gemCount) {
                end = i;
                length = end - start;
                if(length < minLength) {
                    minLength = length;
                    resultStart = start;
                    resultEnd = end;
                }
                isGemExist[gemSet.get(gems[start])]--;
                if(isGemExist[gemSet.get(gems[start])] == 0) {
                    gemCountCheck--;
                }
                start++;
            } else {
                if(isGemExist[gemSet.get(gems[i])] == 0) {
                    gemCountCheck++;
                }
                isGemExist[gemSet.get(gems[i])]++;
                i++;
            }
        }

        answer[0] = resultStart+1;
        answer[1] = resultEnd;

        return answer;
    }
}