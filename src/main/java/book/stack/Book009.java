package book.stack;

import java.util.Stack;

/**
 * 求最大子矩阵大小。
 * TODO 好题！！！！ ***  理解为什么要用栈来找最大矩阵。
 *
 */
public class Book009 {

    public static void main(String[] args) {
        int[] tmp = new int[]{1, 2, 3, 1, 2, 1};
        System.out.println(getArrMax(tmp));
    }

    /**
     * 类似天际线的问题，就是直观图上求能构成的最大矩形
     *
     * @param arr
     * @return
     */
    static int getArrMax(int[] arr) {
        Stack<Integer> maxStack = new Stack<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxStack.isEmpty()) {
                maxStack.push(i);
            } else {
                while (!maxStack.isEmpty() && arr[maxStack.peek()] > arr[i]) {
                    int j = maxStack.pop();
                    int k = j - 1;
                    if (!maxStack.isEmpty()) {
                        k = maxStack.peek();
                    }
                    int tmp = (i - 1 - k) * arr[j];
                    max = Math.max(tmp, max);
                }
                maxStack.push(i);
            }
        }
        while (!maxStack.isEmpty()) {
            int last = maxStack.pop();
            int lastLast = maxStack.isEmpty() ? -1 : maxStack.peek();
            int tmp = (arr.length - 1 - lastLast) * arr[last];
            max = Math.max(tmp, max);
        }
        return max;
    }
}
