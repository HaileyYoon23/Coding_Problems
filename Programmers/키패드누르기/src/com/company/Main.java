package com.company;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println((new Solution()).solution(numbers, hand));
    }
}

class Solution {
    public static String answer = "";
    public String solution(int[] numbers, String hand) {
        Point leftHand = new Point(4,1);
        Point rightHand = new Point(4,3);
        int i ,j;
        for(int n: numbers) {
            switch (n) {
                case 1:
                case 4:
                case 7:
                    answer += "L";
                    leftHand.i = (n-1) / 3 + 1;
                    leftHand.j = 1;
                    break;

                case 3:
                case 6:
                case 9:
                    answer += "R";
                    rightHand.i = (n-1) / 3 + 1;
                    rightHand.j = 3;
                    break;
                case 0:
                    i = 4; j = 2;
                    setHand(i,j,leftHand,rightHand,hand);
                    break;
                default:
                    i = (n-1) / 3 + 1; j = (n-1) % 3 + 1;
                    setHand(i,j,leftHand, rightHand, hand);
                    break;
            }
        }
        return answer;
    }
    private void setHand(int i, int j, Point left, Point right, String hand) {
        int distanceFromLeft = Math.abs(left.i - i) + Math.abs(left.j - j);
        int distanceFromRight = Math.abs(right.i - i) + Math.abs(right.j - j);
        if(distanceFromRight > distanceFromLeft) {
            left.i = i;
            left.j = j;
            answer += "L";
        } else if(distanceFromRight < distanceFromLeft) {
            right.i = i;
            right.j = j;
            answer += "R";
        } else {
            if(hand.equals("right")) {
                right.i = i;
                right.j = j;
                answer += "R";
            } else {
                left.i = i;
                left.j = j;
                answer += "L";
            }
        }
    }
}

class Point {
    int i;
    int j;
    Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}