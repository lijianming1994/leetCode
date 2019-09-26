package book.queue;


import java.util.Stack;

/**
 * 两个栈组成队列
 */
public class Book002 {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(3);
        System.out.print(queue.poll());
        queue.offer(5);
        queue.offer(1);
        queue.offer(4);
        System.out.print(queue.poll());
        System.out.print(queue.poll());
        System.out.print(queue.poll());
    }
}

class MyQueue {


    Stack<Integer> offerStack = new Stack<>();
    Stack<Integer> pollStack = new Stack<>();

    void offer(int i) {
        while (!pollStack.isEmpty()) {
            offerStack.push(pollStack.pop());
        }
        pollStack.push(i);
    }

    int poll() {
        while(!offerStack.isEmpty()){
            pollStack.push(offerStack.pop());
        }
        return pollStack.pop();
    }
}
