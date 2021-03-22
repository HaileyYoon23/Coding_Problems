package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<String> words = new LinkedList<>();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            words.add(br.readLine());
        }
        Collections.sort(words,((o1, o2) -> {
            if(o1.length() < o2.length()) {
                return -1;
            } else if(o1.length() > o2.length()) {
                return 1;
            } else {
                for(int i = 0; i < o1.length(); i++) {
                    if(o1.charAt(i) > o2.charAt(i)) {
                        return 1;
                    } else if(o1.charAt(i) < o2.charAt(i)) {
                        return -1;
                    }
                }
            }
            return 0;
        }));
        String prevWord = "";
        for(int i = 0; i < N; i++) {
            if(prevWord.equals(words.get(i))) continue;
            System.out.println(words.get(i));
            prevWord = words.get(i);
        }

    }
}
