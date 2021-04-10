package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] files = {"f22222.","a33333","e22221,","e22221'"};
        String[] result = (new Solution()).solution(files);
        for(String s: result) System.out.println(s);
    }
}

class Solution {
    private static PriorityQueue<File> queue = new PriorityQueue<>(new Comparator<File>() {
        @Override
        public int compare(File o1, File o2) {
            int v = (o1.head.toUpperCase()).compareTo(o2.head.toUpperCase());
            if (v != 0) return v;
            else {
                int n1 = Integer.parseInt(o1.number);
                int n2 = Integer.parseInt(o2.number);
                int diff = n1 - n2;
                if(diff != 0) return diff;
                else return o1.count - o2.count;
            }
        }
    });
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        for(int i = 0; i < files.length; i++) {
            String str = files[i];
            int numStartIndex = findFirstNumIndex(str);
            int numLastIndex = findFirstNotNumIndex(str,numStartIndex+1);
            String head = str.substring(0,numStartIndex);
            String number, tail;
            if(numLastIndex == -1) {
                number = str.substring(numStartIndex, str.length());
                tail = "";
            } else {
                number = str.substring(numStartIndex, numLastIndex);
                tail = str.substring(numLastIndex, str.length());
            }
            queue.add(new File(head, number, tail,i));
        }

        for(int i = 0; i < answer.length; i++) {
            File f = queue.poll();
            answer[i] = String.format("%s%s%s",f.head,f.number,f.tail);
        }

        return answer;
    }
    private static int findFirstNumIndex(String str) {
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                return i;
            }
        }
        return -1;
    }
    private static int findFirstNotNumIndex(String str, int startIndex) {
        for(int i = startIndex; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!(c >= '0' && c <= '9')) {
                return i;
            }
        }
        return -1;
    }
}

class File {
    String head;
    String number;
    String tail;
    int count;
    File(String head, String number, String tail, int count) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.count = count;
    }
}