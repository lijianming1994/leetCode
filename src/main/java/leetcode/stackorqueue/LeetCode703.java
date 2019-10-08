package leetcode.stackorqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * //TODO 麻烦的题，不用现成的这个优先级队列，实现起来比较麻烦
 */
public class LeetCode703 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3);
        kthLargest.add(5);
    }
}

class KthLargest {
    int k;
    PriorityQueue<Integer> queue;


    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue(k);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
    }

    public int add(int val) {
        queue.offer(val);
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}

