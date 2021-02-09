package com.jimmy;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static int[] twosum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        int sum;
        while(index1 < index2){
            sum = numbers[index1] + numbers[index2];
            if (sum == target)
                break;
            if (sum < target)
                index1 ++;
            else if (sum > target)
            index2 --;

        }
        return new int []{index1,index2};
    }

    public static int[] squrerootsum(int target) {
        int index1 = 0;
        int index2 = (int)Math.sqrt(target);
        int sum;
        while(index1 < index2){
            sum = index1*index1 + index2*index2;
            if (sum == target)
                break;
            if (sum < target)
                index1 ++;
            else if (sum > target)
                index2 --;

        }
        return new int []{index1,index2};
    }

    //Reverse Vowel of a string

    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(char[] words){

        if (words == null)
            return null;

        int i =0;
        int j = words.length -1;
        char[] newWords = new char[words.length];

        while (i < j){
            if (!(vowels.contains(words[i]))){
                newWords[i] = words[i];
                i++;
            }
            else{
                if(!(vowels.contains(words[j]))){
                    newWords[j] = words[j];
                    j--;
                }
            }

            newWords[i] = words[j];
            newWords[j] = words[i];
            i++;
            j--;


        }
        return new String(newWords);

    }

    public static void main(String[] args) {
	// write your code here
        int [] numbers = new int[] {2,7,11,15,17};
        int [] indexpair = twosum(numbers, 17);
        int target = 5;
        int [] rootsqure = squrerootsum(target);
        String words = "leetcode";
        String newWords = reverseVowels(words.toCharArray());
        System.out.println(indexpair[0]+indexpair[1]);
        System.out.println(rootsqure[0]+rootsqure[1]);
    }
}
