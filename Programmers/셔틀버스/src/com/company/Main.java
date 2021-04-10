package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int n = 2;
        int t = 1;
        int m = 2;
        String[] timetable = {"09:00", "09:00", "09:00", "09:00"};
        System.out.println((new Solution()).solution(n,t,m,timetable));
    }
}

class Solution {
    private static PriorityQueue<Integer>[] crewTakeBus;
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int result = 0;
        ArrayList<Integer> crewCommuteList = new ArrayList<>();
        crewTakeBus = new PriorityQueue[n];
        int busTime = 9 * 60;
        int busNum = 0;
        for(int i = 0; i < n; i++) crewTakeBus[i] = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i = 0; i < timetable.length; i++) {
            String[] timeInfo = timetable[i].split(":");
            int commuteTime = Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);
            crewCommuteList.add(commuteTime);
        }

        Collections.sort(crewCommuteList);

        for(int i = 0; i < crewCommuteList.size(); i++) {
            if(crewCommuteList.get(i) <= busTime && crewTakeBus[busNum].size() < m) {
                crewTakeBus[busNum].add(crewCommuteList.get(i));
            } else {
                if(busNum < n - 1) {
                    busNum++;
                    busTime += t;
                    i--;
                }
            }
        }

        for(int i = crewTakeBus.length-1; i >= 0; i--) {
            if(crewTakeBus[i].size() < m) {
                result = 9 * 60 + i * t;
                break;
            } else {
                int prev = crewTakeBus[i].poll();
//                while(!crewTakeBus[i].isEmpty()) {
//                    int cur = crewTakeBus[i].poll();
//                    if(prev != cur) {
//                        prev = cur;
//                        break;
//                    }
//                }
                result = prev - 1;
                break;
            }
        }

        answer = String.format("%02d:%02d",result/60,result%60);
        return answer;
    }
}