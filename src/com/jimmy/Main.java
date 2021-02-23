package com.jimmy;

import java.util.*;


public class Main<pubilc> {

    private static Stack<Integer> in = new Stack<>();
    private static Stack<Integer> out = new Stack<>();
    //private static MinStack minStack;


    public static int countpair(int [] nums){

        Map<Integer,Integer> unique = new HashMap<>();
        for (int num : nums) {
            if(unique.containsKey(nums)){
                unique.put(num,unique.get(nums)+1);
            }
            else {
                unique.put(num,1);
            }
        }
        int count = 0;
        for (int num : unique.values()){
            if (num % 2 == 0)
                count += num / 2;
            else
                count += (num - 1) / 2;

        }
        return count;
    }
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

    public static ArrayList<Integer> printListReverse(LinkNode linkNode){
        ArrayList<Integer> ret = new ArrayList<>();
        if (linkNode != null){
            ret.addAll(printListReverse(linkNode.next));
            ret.add(linkNode.value);
        }
        return ret;
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

    public static ArrayList<Integer> getWindowMax(int[] nums, int size){
        if (nums == null || size <= 0) return null;
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i <= nums.length - size; i++){
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2-o1));
            for (int j = 0; j<size; j++){
                maxHeap.add(nums[i+j]);
            }
            ret.add(maxHeap.peek());
        }
        return ret;
    }

    public static String ReplaceSpace(StringBuffer str){
        if(str == null) return null;
        int p2, p1 = 0;
        for(int i =0; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                str.append("  ");
                p1 = i;
                p2 = str.length()-1;
                while(p2 > p1)
                {
                    str.setCharAt(p2, str.charAt(p2-2));
                    p2 --;
                }
                str.setCharAt(p1,'%');
                str.setCharAt(p1+1,'2');
                str.setCharAt(p1+2,'0');
            }
        }
        return str.toString();
    }

    private static ArrayList<Integer> reverseLink(LinkNode node){
        LinkNode head = new LinkNode(-1);
        while(node!=null){
            LinkNode memo = new LinkNode(-1);
            memo = node.next;
            node.next = head.next;
            head.next = node;
            node = memo;
        }
        //delete temporary head.
        node = head.next;
        ArrayList<Integer> ret = new ArrayList<>();
        while(node!=null){
            ret.add(node.value);
            node = node.next;
        }
        return ret;
    }

    static void countSwaps(int[] a) {
        int count = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length -1; j++){
                if (a[j] > a[j+1]){
                    count ++;
                    int temp = 0;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.printf("Array is sorted in %d swaps.",count);
        System.out.printf("First Element: %d", a[0]);
        System.out.printf("Last Element: %d", a[a.length-1]);

    }

    public static LinkNode deleteNode(LinkNode node, int value){
        if (node == null) return null;
        LinkNode head = node;
        while(node.next != null){
            if (value == node.next.value){
                if(node.next.next != null){
                    node.next = node.next.next;
                    node = node.next;
                }
                else{
                    node.next = null;
                }
                break;
            }
            node = node.next;
        }
        return head;
    }

    public static TreeLinkNode findNext(TreeLinkNode pNode){
        if(pNode == null) return null;
        TreeLinkNode node;
        if (pNode.right != null){
            node = pNode.right;
            while(node.left!=null){
                node = node.left;
            }
        }
        else{
            while(pNode.next != null){
                node = pNode.next;
                if( node.next.left == node )
                    return node;
            }
        }
        return null;

    }

    static int maxToys(int[] prices, int k){
        if(prices==null||k<=0) return 0;
        PriorityQueue<Integer> sortedPrices = new PriorityQueue<>();
        for(int i = 0; i<prices.length; i++){
            if(prices[i] <= k) sortedPrices.add(prices[i]);
        }
        int count = 0;
        int cost = 0;
        int length = sortedPrices.size();
        for(int i = 0; i<length; i++){
            cost += sortedPrices.poll();
            if (cost > k)
                break;
            count ++;
        }
        return count;
    }

    public static int compare(Player a, Player b){
        int ret = -2;
        if(a.score > b.score)
            ret = -1;
        if(a.score < b.score)
            ret = 1;
        if(a.score == b.score)
            ret = a.name.compareTo(b.name);

        return ret;
    }

    public static int [] swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return nums;
    }

    public static int[] selectsort(int[] nums, int startp){
        if(nums == null||nums.length-startp<2)
            return nums;
        else{
            int N = nums.length;
            int min = nums[startp];
            int i = startp;
            int j = startp;
            while(i < N){
                if (nums[i] < min){
                    min = nums[i];
                    j = i;
                }
                i++;
            }
            swap(nums,startp,j);
            return selectsort(nums, startp+1);
        }

    }

    public static void main(String[] args) {
	// write your code here

        int[] prices = {1,12,5,111,200,1000,10};
        int [] sortedPrices = selectsort(prices, 0);
        int ret = maxToys(prices, 50);
        LinkNode node1 = new LinkNode(1);
        node1.value = 1;
        LinkNode node2 = new LinkNode(2);
        node2.value = 2;
        LinkNode node3 = new LinkNode(3);
        node3.value = 3;
        LinkNode node4 = new LinkNode(4);
        node4.value = 4;
        LinkNode node5 = new LinkNode(5);
        node5.value = 5;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        deleteNode(node1, 5);
        deleteNode(node1, 3);

        ArrayList<Integer> list = reverseLink(node1);

        //ArrayList<Integer> reverseList = printListReverse(node1);

        int [] numbers = new int[] {2,7,11,15,17};
        StringBuffer strBuffer = new StringBuffer("A B CD");
        String str = ReplaceSpace(strBuffer);
        System.out.println(str);
        var windowMax = getWindowMax(numbers, 3);
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
        MaxHeap maxheap = new MaxHeap();
        int [] nums = {4,5,7,2,3,0,11,13,19};
        maxheap.GetKthNumber(nums,5);
        System.out.println(indexpair[0]+indexpair[1]);
        System.out.println(rootsqure[0]+rootsqure[1]);
    }
}
