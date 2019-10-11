package book.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 在单链表和双链表中删除倒数第k个节点
 */
public class List02 {

    public Node removeLastKNode(Node head, Integer k) {
        Node index = head;
        int num = 0;
        Map<Integer, Node> map = new HashMap<>();
        while (index != null) {
            map.put(num, index);
            index = index.next;
            num++;
        }
        int num1 = num - k;
        Node node = map.get(num1);
        if (node != null) {
            if (node.next != null) {
                if (node.next.next != null) {
                    node.next = node.next.next;
                } else {
                    node.next = null;
                }
            }
        }
        return head;
    }
}
