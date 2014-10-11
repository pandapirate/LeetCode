package List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 10/8/2014.
 */
public class MergeKSortedList {

    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode head = null;
        ListNode temp = null;
        while (hasMoar(lists)) {
            int x = findMin(lists);
            ListNode node = lists.get(x);

            if (head == null) {
                head = node;
                temp = head;
            } else {
                temp.next = node;
                temp = temp.next;
            }

            lists.set(x, node.next);
            node.next = null;
        }

        return head;
    }

    private boolean hasMoar(List<ListNode> lists) {
        for (ListNode n : lists) {
            if (n != null)
                return true;
        }
        return false;
    }

    private int findMin(List<ListNode> lists) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) == null) continue;
            if (lists.get(i).val < min) {
                minIndex = i;
                min = lists.get(i).val;
            }
        }

        return minIndex;
    }

    public static void main (String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        ListNode temp1 = a;
        ListNode temp2 = b;
        ListNode temp3 = c;

        for (int i = 4; i < 20; i++) {
            if (i % 3 == 0) {
                temp2.next = new ListNode(i);
                temp2 = temp2.next;
            } else if (i % 3 == 1) {
                temp1.next = new ListNode(i);
                temp1 = temp1.next;
            } else {
                temp3.next = new ListNode(i);
                temp3 = temp3.next;
            }
        }

        a.print();
        b.print();
        c.print();

        List<ListNode> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        new MergeKSortedList().mergeKLists(list).print();
    }
}
