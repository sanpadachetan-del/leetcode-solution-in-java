class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to optimize binary search range
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m; // Binary search will be performed on the smaller array (nums1)

        while (low <= high) {
            int partitionX = (low + high) / 2; // Partition for nums1
            // partitionY ensures the total number of elements on the left side is (m+n+1)/2
            int partitionY = (m + n + 1) / 2 - partitionX;

            // Determine the elements for comparison
            // If partition is 0, then there are no elements on the left side (use MIN_VALUE)
            // If partition is array.length, then there are no elements on the right side (use MAX_VALUE)
            int maxX_Left = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX_Right = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY_Left = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY_Right = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if the partition is correct
            if (maxX_Left <= minY_Right && maxY_Left <= minX_Right) {
                // We've found the correct partition
                if ((m + n) % 2 == 0) {
                    // Even total length, median is average of two middle elements
                    return (double) (Math.max(maxX_Left, maxY_Left) + Math.min(minX_Right, minY_Right)) / 2.0;
                } else {
                    // Odd total length, median is the larger of the two max left elements
                    return (double) Math.max(maxX_Left, maxY_Left);
                }
            } else if (maxX_Left > minY_Right) {
                // We are too far right in nums1, need to move left
                high = partitionX - 1;
            } else {
                // We are too far left in nums1, need to move right
                low = partitionX + 1;
            }
        }
        // This part should ideally not be reached if the input arrays are valid.
        return 0.0;
    }
}
