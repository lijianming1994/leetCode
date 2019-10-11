package leetcode.stackorqueue;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 给定一个嵌套的整型列表。设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的项或者为一个整数，或者是另一个列表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 *
 *
 * TODO 这里期望输出 void 但方法是Integer 。。。返回null 也不行  0也不行，不知道怎么处理
 */
public class LeetCode341 {
    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();
        NestedIterator iterator = new NestedIterator(list);
        iterator.hasNext();
        iterator.next();
    }
}

class NestedIterator implements Iterator<Integer> {

    ConcurrentLinkedDeque<NestedInteger> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new ConcurrentLinkedDeque<>();
        nestedList.forEach(e -> queue.offer(e));
    }

    @Override
    public Integer next() {
        if (queue.isEmpty()) {
            return 0;
        }
        NestedInteger result = queue.poll();
        Stack<NestedInteger> stack = new Stack<>();
        while (!result.isInteger()) {
            result.getList().forEach(stack::push);
            while (!stack.isEmpty()) {
                queue.addFirst(stack.pop());
            }
            if (!queue.isEmpty()) {
                result = queue.poll();
            }else {
                return result.getInteger();
            }
        }
        return result.getInteger();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}


interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}