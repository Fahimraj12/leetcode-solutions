class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = total / 2;

        int left = 0, right = m;

        while (left <= right) {
            int i = (left + right) / 2;       // partition for nums1
            int j = half - i;                 // partition for nums2

            int nums1Left  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int nums2Left  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Correct partition
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // Odd length
                if (total % 2 == 1) {
                    return Math.min(nums1Right, nums2Right);
                }
                // Even length
                int leftMax = Math.max(nums1Left, nums2Left);
                int rightMin = Math.min(nums1Right, nums2Right);
                return (leftMax + rightMin) / 2.0;
            }

            // nums1Left too big → move left
            else if (nums1Left > nums2Right) {
                right = i - 1;
            }
            // nums2Left too big → move right
            else {
                left = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays not sorted.");
    }
}