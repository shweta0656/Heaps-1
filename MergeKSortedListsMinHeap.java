import java.util.PriorityQueue;

/*
TC: N log k, There are N nodes in all linked list and k is the number if lists

SC : O(k), dominated by the priority queue, where k is the number of linked lists.
*/

 //Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class MergeKSortedListsMinHeap
{
    public ListNode mergeKLists(ListNode[] lists) {
        //a and b are list node, so a.val and b.val to get the values
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->a.val-b.val);

        //Adding all the head nodes only in heap
        for(ListNode list : lists) {
            if(list != null) {
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        //compare all the nodes till heap becomes empty
        while(!pq.isEmpty())
        {
            ListNode currMin = pq.poll(); //min will be at the top in min heap
            curr.next = currMin;
            curr = curr.next;

            if(currMin.next != null) {
                pq.add(currMin.next);
            }
        }

        return dummy.next;
    }
}