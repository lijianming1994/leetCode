package leetcode.stackorqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 */
public class LeetCode225 {

}

class MyStack {

    Queue<Integer> queue;
    Queue<Integer> queueTmp;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
        queueTmp = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queueTmp.offer(x);
        while (!queue.isEmpty()) {
            queueTmp.offer(queue.poll());
        }
        Queue tmp = queue;
        queue = queueTmp;
        queueTmp = tmp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
