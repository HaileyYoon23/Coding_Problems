package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] user_id = {"aa", "bb","cc","ec","ac"};
        String[] banned_id = {"**", "**", "*c"};

        System.out.println((new Solution()).solution(user_id, banned_id));
    }
}

class Solution {
    private static ArrayList<Integer>[] arr;
    private static boolean[] visited;
    private static int N;
    private static Set<Integer> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        arr = new ArrayList[banned_id.length];
        for(int i = 0; i < banned_id.length; i++) arr[i] = new ArrayList<>();
        N = banned_id.length;
        for(int i = 0; i < banned_id.length; i++) {
            compareExcept(user_id, banned_id[i],i);
        }
        DFS(0,0);
        return set.size();
    }

    private static void compareExcept(String[] user_id, String banned_id, int index) {
        boolean find;
        for(int i = 0; i < user_id.length; i++) {
            find = true;
            if(user_id[i].length() != banned_id.length()) continue;
            for(int j = 0; j < banned_id.length(); j++) {
                if(banned_id.charAt(j) != '*') {
                    if(user_id[i].charAt(j) != banned_id.charAt(j)) {
                        find = false;
                        break;
                    }
                }
            }
            if(find) {
                arr[index].add(i);
            }
        }
    }
    private static void DFS(int record, int index) {
        if(index >= N) {
            set.add(record);
            return;
        }
        for(int n: arr[index]) {
            if(!visited[n]) {
                visited[n] = true;
                int newRecord = record;
                DFS(newRecord |= (1<<n) ,index+1);
                visited[n] = false;
            }
        }
    }
}