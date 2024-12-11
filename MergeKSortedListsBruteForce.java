import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Time complexity : O(NlogN) where N is the total number of nodes.
                = O(nk log nk) where k is the number of lists and n is the number of nodes in each and every list

Collecting all the values costs O(N) time.
A stable sorting algorithm costs O(NlogN) time.
Iterating for creating the linked list costs O(N) time.

O(N)+O(NlogN)+O(N)=O(NlogN)
----------------------------------------------------------------------------------
Space complexity : O(N).

Sorting cost O(N) space (depends on the algorithm you choose).
Creating a new linked list costs O(N) space.

O(N)+O(N)=O(2N)=O(N)
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedListsBruteForce {
    public ListNode mergeKLists(ListNode[] lists)
    {
        List<Integer> nodes = new ArrayList<>();
        ListNode head = new ListNode(0);
        ListNode point = head;

        //traversing the listnode array and adding all values in the arraylist
        for(ListNode l : lists) {
            while(l != null)
            {
                nodes.add(l.val);
                l = l.next;
            }
        }

        //Sorting the arraylist
        Collections.sort(nodes);

        for(int x : nodes)
        {
            point.next = new ListNode(x);
            point = point.next;
        }

        return head.next;
    }
}