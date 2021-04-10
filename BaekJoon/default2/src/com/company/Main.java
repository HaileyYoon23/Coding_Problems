package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        System.out.println(map.putIfAbsent(1,"First"));
        System.out.println(map.putIfAbsent(1,"Second"));
    }
}

class Result {

    /*
     * Complete the 'oddNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

    public static List<Integer> oddNumbers(int l, int r) {
        List<Integer> result = new LinkedList<>();
        for(int i = l; i <= r; i++) {
            if(i % 2 == 1) {
                result.add(i);
                i++;
            }
        }
        return result;
    }

}