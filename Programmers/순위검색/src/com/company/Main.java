package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = (new Solution()).solution(info,query);
        for(int a: answer) System.out.print(a + " ");
        String[] n = query[0].replace(" and "," ").split(" ");
    }
}

class Solution {
    Map<String,ArrayList> map = new HashMap<>();
    public void preSetting() {
        String[] code = {"java","cpp","python","-"};
        String[] job = {"backend","frontend","-"};
        String[] position = {"junior","senior","-"};
        String[] food = {"pizza","chicken","-"};
        String key;
        for(String c : code) {
            for(String j : job) {
                for(String p : position) {
                    for(String f : food) {
                        key = c + j + p + f;
                        map.put(key,(new ArrayList<>()));
                    }
                }
            }
        }
    }
    public void resumeSetting(String[] resume) {
        String[] code = {resume[0], "-"};
        String[] job = {resume[1], "-"};
        String[] position = {resume[2], "-"};
        String[] food = {resume[3], "-"};
        String key;
        for(String c : code) {
            for(String j : job) {
                for(String p : position) {
                    for(String f : food) {
                        key = c + j + p + f;
                        map.get(key).add(Integer.parseInt(resume[4]));
                    }
                }
            }
        }
    }
    public int numberOfCondition(ArrayList<Integer> arr, int goal) {
        int s = 0;
        int e = arr.size();
        int max = arr.size();
        while(s < e) {
            int mid = (s + e) / 2;

            if(arr.get(mid) >= goal) {
                e = mid;
            }
            else {
                s = mid + 1;
            }
        }
        return max - e;
    }
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        preSetting();
        for(int i = 0; i < info.length; i++)
            resumeSetting(info[i].split(" "));
        for(int i = 0; i < query.length; i++) {
            String[] condition = query[i].replace(" and "," ").split(" ");
            String key = condition[0] + condition[1] + condition[2] + condition[3];
            Collections.sort(map.get(key));
            answer[i] = numberOfCondition(map.get(key),Integer.parseInt(condition[4]));
        }
        return answer;
    }
}