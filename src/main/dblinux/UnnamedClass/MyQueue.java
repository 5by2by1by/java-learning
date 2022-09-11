package main.dblinux.UnnamedClass;

import java.util.Stack;

/**
 * @author dblinux
 * @Date 2022/6/2 8:45
 */

public class MyQueue {

    public MyQueue() {

    }

    public void push(int x) {
        sPush.push(x);
    }

    public int pop() {
        if(sPush.empty()){
            return -1;
        }
        while(!sPush.empty()){
            sHelper.push(sPush.pop());
        }
        int res = sHelper.pop();
        while(!sHelper.empty()){
            sPush.push(sHelper.pop());
        }
        return res;
    }

    public int peek() {
        if(sPush.empty()){
            return -1;
        }
        while(!sPush.empty()){
            sHelper.push(sPush.pop());
        }
        int res = sHelper.peek();
        while(!sHelper.empty()){
            sPush.push(sHelper.pop());
        }
        return res;
    }

    public boolean empty() {
        return sPush.empty();
    }

    public static Stack<Integer> sPush = new Stack<>();
    public static Stack<Integer> sHelper = new Stack<>();


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.empty());
    }
}
