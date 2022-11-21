package linklists.questions;


import java.util.LinkedList;
import java.util.Queue;

class MyStack {
   private Queue<Integer> queue;
    int lastVal = 0;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        lastVal = x;
    }

    public int pop() {
        for (int i = 0; i < queue.size() - 1; i++) {
            lastVal = queue.poll();
            queue.offer(lastVal);
        }
        return queue.poll();
    }

    public int top() {
        return lastVal;

    }

    public boolean empty() {
        return queue.size() == 0;
    }
}


public class ImplementStackUsingQueue {


    public static void main(String[] args) {

        MyStack stack= new MyStack();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.pop();
        int top = stack.top();
        System.out.println(top);
        System.out.println(stack.empty());
    }

}
