package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"}
                            ,{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println((new Solution()).solution(relation));
    }
}

class Solution {
    private static Set<String> set = new HashSet<>();
    private static Map<Integer, Integer> keyMap = new HashMap<>();
    public int solution(String[][] relation) {
        ArrayList<Integer> keyList = new ArrayList<>();
        int height = relation.length;
        int width = relation[0].length;
        for(int i = 1; i <= width; i++) {
            ArrayList<Integer> bitMaskList = new ArrayList<>();
            bitMaskComb(bitMaskList, 0, width, 0, i, 0);
            for(int j = 1; j <= bitMaskList.size(); j++) {
                int bitMask = bitMaskList.get(j-1);
                if(i > 1) {
                    if(isNotMinimized(keyList, bitMask)) continue;
                }
                makeKeyList(relation, bitMask);
                if(isCandidateKey(height)) {
                    keyList.add(bitMask);
                }
            }
        }
        return keyList.size();
    }
    private static boolean isNotMinimized(ArrayList<Integer> arr, int bitMask2) {
        for(int i = 0; i < arr.size(); i++) {
            if((arr.get(i) & bitMask2) == arr.get(i)) return true;
        }
        return false;
    }
    private static void bitMaskComb(ArrayList<Integer> arr,int start, int end, int count, int n, int bitMask) {
        if(count == n) arr.add(bitMask);
        else {
            for(int i = start; i < end; i++) {
                int tempBitMask = bitMask;
                tempBitMask |= (1 << i);
                bitMaskComb(arr, i+1, end, count+1, n, tempBitMask);
            }
        }
    }
    private static void makeKeyList(String[][] relation, int bitMask) {
        resetSet();
        for(int i = 0; i < relation.length; i++) {
            int temp = bitMask;
            String str = "";
            int count = 0;
            while(temp > 0) {
                if((temp & 1) > 0) {
                    str = relation[i][count] + str;
                }
                temp /= 2;
                count++;
            }
            set.add(str);
        }
    }
    private static boolean isCandidateKey(int len) {
        if(set.size() == len) return true;
        return false;
    }
    private static void resetSet() {
        set = new HashSet<>();
    }
}