package book.stack;

import java.util.Stack;

/**
 * 如何用递归函数和stack 来逆序一个栈
 */
public class Book003 {

    static Stack input = new Stack();

    public static void main(String[] args) {
        input.push(1);
        input.push(2);
        input.push(3);
        input.push(4);
        input.push(5);
        input.push(6);
        input.push(7);
        reverse(input);
        while (!input.isEmpty()) {
            System.out.println(input.pop());
        }

    }

    /**
     * 递归逆序一个stack
     *
     * @param input
     * @return
     */
    static void reverse(Stack<Integer> input) {
        if (input.isEmpty()) {
            return;
        }
        int botNum = getBotNum(input);
        reverse(input);
        input.push(botNum);
    }

    /**
     * 递归获取栈最底下的数并返回
     */
    static int getBotNum(Stack<Integer> stack) {
        Integer i = stack.pop();
        if (stack.isEmpty()) {
            return i;
        }
        int last = getBotNum(stack);
        stack.push(i);
        return last;
    }

}
