package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String str1 = "handshake";
        String str2 = "shake hands";
        System.out.println((new Solution()).solution(str1, str2));
    }
}

class Solution {
    private static Map<String, Integer> map1 = new HashMap<>();
    private static Map<String, Integer> map2 = new HashMap<>();
    public int solution(String str1, String str2) {
        int answer = 0;
        int cross = 0, union = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        for(int i = 0; i < str1.length() - 1; i++) {
            if(str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z'
                    && str1.charAt(i+1) >= 'A' && str1.charAt(i+1) <= 'Z') {
                String key = str1.substring(i,i+2);
                if(map1.containsKey(key)) {
                    map1.put(key, map1.get(key)+1);
                } else map1.put(key,1);
            }
        }
        for(int i = 0; i < str2.length() - 1; i++) {
            if(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z'
                    && str2.charAt(i+1) >= 'A' && str2.charAt(i+1) <= 'Z') {
                String key = str2.substring(i,i+2);
                if(map2.containsKey(key)) {
                    map2.put(key, map2.get(key)+1);
                } else map2.put(key,1);
            }
        }

        for(String key: map1.keySet()) {
            int map1Num = map1.get(key);
            if(map2.containsKey(key)) {
                int map2Num = map2.get(key);
                union += Integer.max(map1Num,map2Num);
                cross += Integer.min(map1Num,map2Num);
                map2.remove(key);
            } else {
                union += map1Num;
            }
        }
        for(String key: map2.keySet()) {
            int map2Num = map2.get(key);
            if(map1.containsKey(key)) {
                int map1Num = map1.get(key);
                union += Integer.max(map1Num,map2Num);
                cross += Integer.min(map1Num,map2Num);
                map1.remove(key);
            } else {
                union += map2Num;
            }
        }
        if(union == 0) return 65536;
        answer = (cross * 65536) / union;
        return answer;
    }
}