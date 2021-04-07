package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    int cacheSize = 5;
	    String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
	    System.out.println((new Solution()).solution(cacheSize,cities));
    }
}
class Solution {
    private static LinkedList<String> cache = new LinkedList<>();
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) return cities.length * 5;
        for(int i = 0; i < cities.length; i++) {
            String city = (cities[i]).toLowerCase();
            if(cache.size() >= cacheSize) {
                if(ifNotExistPopFirstAndAddCity(city)) answer += 5;
                else answer += 1;
            } else {
                if(popAndAddtoLast(city)) answer += 1;
                else answer += 5;
            }
        }
        return answer;
    }
    private static boolean popAndAddtoLast(String city) {
        if(cache.remove(city)) {
            cache.add(city);
            return true;
        } else {
            cache.add(city);
            return false;
        }
    }
    private static boolean ifNotExistPopFirstAndAddCity(String city) {
        if(cache.remove(city)) {
            cache.add(city);
            return false;
        }
        else {
            cache.pollFirst();
            cache.add(city);
            return true;
        }
    }
}
