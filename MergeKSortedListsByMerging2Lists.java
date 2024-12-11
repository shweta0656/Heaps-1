/*
TC: O(N*k)

Merging two list at a time:
n+2n+3n+4n+......+kn = n(1+2+3+4+...+k) = n[(k(k+1))/2] = nk^2/2 + nk/2 = nk^2 = N.K

SC: The space complexity remains O(1), as you're using constant space for the dummy node and pointers
during the merge operations.

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
class MergeKSortedListsByMerging2Lists {
    public ListNode mergeKLists(ListNode[] lists)
    {
        //make a dummy list to compare it with given list to start, so dummy list can stay in the front
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode list : lists) {
            merged = merge(merged, list);
        }

        return merged.next;
    }

    //method to merge two lists
    private ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        //If any of l1 or l2 lists remains in the end, add the remaining integers in the end
        if(l1 != null) {
            curr.next = l1;
        }

        if(l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }
}