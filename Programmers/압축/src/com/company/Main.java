package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String msg = "TOBEORNOTTOBEORTOBEORNOT";
	    int[] result = (new Solution()).solution(msg);
	    for(int r: result) System.out.println(r);
    }
}

class Solution {
    private static Map<String, Integer> dict = new HashMap<>();
    private static int mapLen = 0;
    public int[] solution(String msg) {
        ArrayList<Integer> result = new ArrayList<>();
        String temp = msg;
        init();

        while(temp.length() != 0) {
            int maxDictLen = findMaxDictLen(temp);
            if(maxDictLen == temp.length()) {
                result.add(dict.get(temp));
                temp = "";
            } else {
                result.add(dict.get(temp.substring(0,maxDictLen)));
                String addToDict = temp.substring(0,maxDictLen+1);
                dict.put(addToDict, ++mapLen);
                temp = temp.substring(maxDictLen, temp.length());
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++)  {
            answer[i] = result.get(i);
        }
        return answer;
    }
    private static void init() {
        for(int i = 0; i < 26; i++) {
            dict.put(Character.toString('A' + i), ++mapLen);
        }
    }
    private static int findMaxDictLen(String str) {
        if(dict.containsKey(str)) return str.length();

        int result = 1;
        while(dict.containsKey(str.substring(0,result))) {
            result++;
        }
        return result-1;
    }
}