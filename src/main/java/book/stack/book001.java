package book.stack;


import java.util.Stack;

/**
 * 设计一个获取最小值的栈getMin方法
 */
public class book001 {

}

class minStack {

    Stack<Integer> value = new Stack();
    Stack<Integer> minStack = new Stack();

    void push(int a) {
        value.push(a);
        if (minStack.isEmpty()) {
            minStack.push(a);
        } else {
            if (minStack.peek() >= a) {
                minStack.push(a);
            }
        }
    }

    int pop() {
        if (minStack.peek().equals(value.peek())) {
            minStack.pop();
        }
        return value.pop();
    }

    int getMin(){
        return minStack.peek();
    }


}