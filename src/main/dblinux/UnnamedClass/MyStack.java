package main.dblinux.UnnamedClass;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author dblinux
 * @Date 2022/6/2 9:24
 */
class MyStack {
    private static Queue<Integer> q1;
    private static Queue<Integer> q2;
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        if(q1.isEmpty()){
            return -1;
        }
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        int res = q2.poll();
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        return res;
    }

    public int top() {
        if(q1.isEmpty()){
            return -1;
        }
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        int res = q2.peek();
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        return res;
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

    }
}
