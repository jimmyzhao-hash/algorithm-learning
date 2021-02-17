package com.jimmy;

import java.util.Stack;

public class MinStack {
    static private Stack<Integer> minStack = new Stack<>();
    static private Stack<Integer> dataStack = new Stack<>();

    static public void push(int num){
        dataStack.push(num);
        minStack.push(minStack.isEmpty()? num: Math.min(num, minStack.peek()));
    }

    static public Integer pop(){
        minStack.pop();
        return (dataStack.pop());
    }

    static public Integer min(){
        return(minStack.peek());
    }
}
