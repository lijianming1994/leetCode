package book.stack;

import java.util.Stack;

/**
 * 用一个栈实现对另一个栈的排序
 */
public class Book005 {
    public static void sort(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (help.isEmpty() || curr <= help.peek()) {
                help.push(curr);
            } else {
                while (!help.isEmpty() && curr > help.peek()) {
                    stack.push(help.pop());
                }
                help.push(curr);
            }
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(8);
        stack.push(7);
        stack.push(9);
        stack.push(6);
        stack.push(1);
        sort(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
