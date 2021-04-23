package com.company;

import java.util.*;
import java.io.*;

public class Main {
    private static int goalNum;
    private static boolean[] isDisabled = new boolean[10];
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        goalNum = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        if(n > 0) {
            int[] disabled = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for(int num: disabled) {
                isDisabled[num] = true;
            }
        }

        int upperPossible = goalNum; int lowerPossible = goalNum;
        int limit = Math.abs(goalNum - 100);
        int count = 0;
        int possible = 0;
        boolean find = false;
        while(count < limit) {
            if(lowerPossible >= 0) {
                if(isInvalid(lowerPossible)) lowerPossible--;
                else {
                    possible = lowerPossible;
                    find = true;
                    break;
                }
            }
            if(isInvalid(upperPossible)) upperPossible++;
            else {
                possible = upperPossible;
                find = true;
                break;
            }
            count++;
        }
        if(find) {
            int possibleNumCount = numbersNumber(possible);
            int possiblePressNum = possibleNumCount + (Math.abs(possible - goalNum));
            if(possiblePressNum > limit) System.out.println(limit);
            else System.out.println(possiblePressNum);
        } else System.out.println(limit);

    }
    private static boolean isInvalid(int number) {
        if(number == 0) return isDisabled[0];
        while(number > 0) {
            int edgeNumber = number % 10;
            if(isDisabled[edgeNumber]) return true;
            number /= 10;
        }
        return false;
    }
    private static int numbersNumber(int number) {
        if(number == 0) return 1;
        int count = 0;
        while(number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }
}
