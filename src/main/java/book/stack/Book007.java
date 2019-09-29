package book.stack;

import java.util.LinkedList;

/**
 * 生成窗口的最大数值
 */
public class Book007 {
    public static void main(String[] args) {
        int[] tmp = new int[]{2, 3, 1, 3};
        int[] result = getMaxRes(tmp, 3);
    }

    static int[] getMaxRes(int[] arr, int n) {
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[arr.length - n + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]) {
                qMax.pollLast();
            }
            qMax.addLast(i);
            if (qMax.peekFirst() == i - n) {
                qMax.pollFirst();
            }
            if (i + 1 >= n) {
                res[index++] = arr[qMax.peekFirst()];
            }
        }
        return res;
    }


}
