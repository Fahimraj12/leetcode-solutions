class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> current,
                            List<List<Integer>> result) {

        // If current permutation contains all elements
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every unused element
        for (int num : nums) {

            if (current.contains(num)) {
                continue;
            }

            // Choose
            current.add(num);

            // Explore
            backtrack(nums, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}