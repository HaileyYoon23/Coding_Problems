package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicInfo = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println((new Solution()).solution(m,musicInfo));
    }
}

class Solution {
    private static PriorityQueue<Music> musics = new PriorityQueue<>(new Comparator<Music>() {
        @Override
        public int compare(Music o1, Music o2) {
            return o2.minute - o1.minute;
        }
    });
    private static int[] pi;

    private static void getPI(String pattern) {
        int j = 0;
        for(int i = 1; i < pattern.length(); i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        pi = new int[m.length()];

        for(int i = 0; i < musicinfos.length; i++) {
            String[] musicInfo = musicinfos[i].split(",");
            String[] str_StartTime = musicInfo[0].split(":"); String[] str_EndTime = musicInfo[1].split(":");
            int startTimeInterval = Integer.parseInt(str_StartTime[0]) * 60 + Integer.parseInt(str_StartTime[1]);
            int endTimeInterval = Integer.parseInt(str_EndTime[0])*60 + Integer.parseInt(str_EndTime[1]);
            musics.add(new Music(endTimeInterval-startTimeInterval, musicInfo[2], musicInfo[3]));

        }
        String changedM = changeSharp(m);

        getPI(changedM);

        int len = changedM.length();


        while(!musics.isEmpty()) {
            Music newMusic = musics.poll();
            String changedCode = changeSharp(newMusic.code);
            String totalString = "";
            while(totalString.length() < newMusic.minute) {
                totalString += changedCode;
            }
            totalString = totalString.substring(0, newMusic.minute);

            int j = 0;
            for(int i = 0; i < totalString.length(); i++) {
                while(j > 0 && totalString.charAt(i) != changedM.charAt(j)) {
                    j = pi[j-1];
                }
                if(totalString.charAt(i) == changedM.charAt(j)) {
                    if(j == len - 1) {
                        return newMusic.name;
                    } else j++;
                }
            }
        }
        return "(None)";
    }
    private static String changeSharp(String code) {
        String result = "";
        int codeLen = code.length();
        for(int i = 0; i < codeLen-1; i++) {
            if(code.charAt(i+1) == '#') {
                result = result + String.format("%c",code.charAt(i)+26);
                i++;
            }
            else {
                result = result + code.substring(i,i+1);
            }
        }
        if(code.charAt(codeLen-1) != '#') result += code.substring(codeLen-1, codeLen);
        return result;
    }

}

class Music {
    int minute;
    String name;
    String code;
    Music(int minute, String name, String code) {
        this.minute = minute;
        this.name = name;
        this.code = code;
    }
}