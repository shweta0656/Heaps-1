import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
TC:
Average Case
-------------
In the average case, the pivot divides the array approximately into halves.
The size of the array segments reduces geometrically:
First partition: n elements → O(n).
Second partition: n/2 elements → O(n/2).
Third partition: n/4 elements → O(n/4).
...
Total work in the average case:
T(n) = n + n/2 + n/4 + ⋯ ≈ 2n

This sums up to O(n).

Worst Case
-----------
In the worst case, the pivot is always the smallest or largest element, resulting in highly unbalanced partitions.
The partition sizes reduce by only 1 element in each step:
First partition: n elements → O(n).
Second partition: n-1 elements → O(n-1).
Third partition: n-2 elements → O(n-2).
...
Total work in the worst case:
T(n) = n + (n-1) + (n-2) + ⋯ = n(n+1)/2

This sums up to O(n²).

SC:
Auxiliary space due to new lists:

At each recursion, three new lists (left, mid, right) are created, consuming space proportional to the size
of the current list.
The space used for lists across all recursive calls is proportional to the input size, so the space complexity
is O(n).

Recursion stack:

In the average case, the recursion depth is O(log n).
In the worst case, the recursion depth is O(n).
Combining both, the total space complexity is:

O(n) for the new lists.
O(n) in the worst case due to recursion.

O(n) + O(n) = O(2n) = O(n)
*/
class KthLargestUsingQuickSelect {
    public int findKthLargest(int[] nums, int k)
    {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return quickSelect(list, k);
    }

    private int quickSelect(List<Integer> nums, int k)
    {
        //Selects a random number between 0{included} and nums.size(){excluded}
        int pivotIndex = new Random().nextInt(nums.size());
        int pivot = nums.get(pivotIndex);

        /*
        As quick select is used to find the kth smallest element, not largest, we will swap the left
        arraylist to have larger numbers than pivot and right will have smaller numbers than pivot
        */
        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        //Adding numbers in different list based on comparison with num
        for(int num : nums)
        {
            if(num > pivot) {
                left.add(num);
            }
            else if (num < pivot) {
                right.add(num);
            }
            else {
                mid.add(num);
            }
        }

        //Meaning the kth largest number is present in the left arraylist
        if (k <= left.size()) {
            return quickSelect(left, k);
        }

        /*
        If k is greater than the size of left and mid combined, meaning k is present on the right side.
        Since we will be passing the right arraylist for recursion, we need to reduce the kth value by
        the elements we have already neglected and not going to check again
        */
        if(left.size() + mid.size() < k) {
            return quickSelect(right, k-left.size()-mid.size());
        }

        //If k is neither is left nor in right meaning it is the pivot
        return pivot;
    }
}