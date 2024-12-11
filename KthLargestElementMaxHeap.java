/*
TC: O(n log (n-k)), n is the number of elements, and n-k is the size of heap, time complexity for
heapify is log (n-k)

SC: O(n-k), n-k is the heap space
*/

import java.util.PriorityQueue;

class KthLargestElementMaxHeap {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        for(int i=0; i<nums.length;i++)
        {
            pq.add(nums[i]);
            if(pq.size() > (n-k)) {
                result = Math.min(result ,pq.poll());
            }
        }
        return result;
    }
}