package leetcode.stackorqueue;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class LeetCode347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new LinkedList<>();
        for (Integer i : nums) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                Integer t = map.get(i);
                map.put(i, t + 1);
            }
        }
        List<Map.Entry> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> (Integer) o2.getValue() - (Integer) o1.getValue());
        for (int i = 0; i < k; i++) {
            result.add((Integer) list.get(i).getKey());
        }
        return result;
    }
}
