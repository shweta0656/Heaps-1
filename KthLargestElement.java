import java.util.PriorityQueue;

/*
TC: O(n log k), n is number of elements, and k is the size of heap, time complexity for heapify is log k

SC: O(k), k is the heap space

By default, it is a min heap even if we do not write a custom comparator
*/
class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->a-b);
        for(int i=0; i<nums.length;i++) {
            pq.add(nums[i]);
            if(pq.size()>k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}