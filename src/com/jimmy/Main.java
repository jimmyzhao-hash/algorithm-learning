package com.jimmy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;


public class Main {

    private static Stack<Integer> in = new Stack<>();
    private static Stack<Integer> out = new Stack<>();
    //private static MinStack minStack;



    public static void push(int num){
        in.push(num);
    }

    public static int pop() throws Exception {
        if(out.isEmpty())
            while(!in.isEmpty())
                out.push(in.pop());
        if(out.isEmpty())
            throw new Exception("queue is empty");

        return (out.pop());
    }

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

    //valid pladindrome

    public static boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }



    public static boolean dupNumber(int [] numbers){
        if(numbers == null) return false;
        int i = 0;
        int j = 0;
        while (j < numbers.length -1){
            if (numbers[j] != i)
                j++;
            else {
                if (numbers[j] == numbers[i])
                    return true;
                else{
                    numbers[j] = numbers[i];
                    numbers[i] = i;
                    i++;
                    j = i;
                }
            }
        }
        return false;
    }

    public static boolean find(int [][] matrix, int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int cr=0;
        int cl = matrix[0].length-1;
        while(cr < matrix[0].length && cl >0){
            if(matrix[cr][cl] == target)
                return true;
            else if (matrix[cr][cl] < target)
                cr ++;
            else
                cl --;

        }
        return false;
    }



    public static void main(String[] args) {
	// write your code here
        int [] numbers = new int[] {2,7,11,15,17};
        int [] numberdup = new int[] {2,3,1,0,2,5};
        int [] indexpair = twosum(numbers, 17);
        int [][] matrix = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        int [] rootsqure = squrerootsum(target);
        String words = "leetcode";
        String newWords = reverseVowels(words.toCharArray());
        validPalindrome("abcba");
        boolean dup = dupNumber(numbers);
        dup = dupNumber(numberdup);
        boolean f = find(matrix,23);
        push(1);
        push(2);
        push(3);
        push(4);
        try {
            int outvaiable = pop();
            System.out.println(outvaiable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MinStack.push(4);
        MinStack.push(5);
        MinStack.push(0);
        MinStack.push(3);
        MinStack.push(1);
        int m = MinStack.min();
        System.out.println(indexpair[0]+indexpair[1]);
        System.out.println(rootsqure[0]+rootsqure[1]);
    }
}
