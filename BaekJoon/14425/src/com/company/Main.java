package com.company;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static class Dict {
        static Map<String, Integer> words = new HashMap<>();
        public static void update(String word) {
            words.replace(word,words.get(word) + 1);
        }

        public static void insert(String word) {
            words.put(word,0);
        }

        public static boolean isContainkey(String word) {
            return words.containsKey(word);
        }
    }


    public static void main(String[] args) throws Exception{
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int N = Integer.valueOf(nums[0]);
        int M = Integer.valueOf(nums[1]);
        int count = 0;

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            Dict.insert(word);
        }

        for(int i = 0; i < M; i++) {
            String word = br.readLine();
            if(Dict.isContainkey(word)) {
//                Dict.update(word);
                count++;
            }
        }
        System.out.println(count);

    }
}



