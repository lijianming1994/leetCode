package leetcode.stackorqueue;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class LeetCode155 {

}

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() > x) {
            minStack.push(x);
        }else {
            minStack.push(minStack.peek());
        }
    }

    public int pop() {
        if (!minStack.isEmpty()) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
