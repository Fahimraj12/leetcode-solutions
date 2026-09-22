class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Put each number in its correct position
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 &&
                   nums[i] <= n &&
                   nums[nums[i] - 1] != nums[i]) {

                int correctIndex = nums[i] - 1;

                // Swap nums[i] with nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Find the first number that is not in its correct position
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If 1..n are all present
        return n + 1;
    }
}