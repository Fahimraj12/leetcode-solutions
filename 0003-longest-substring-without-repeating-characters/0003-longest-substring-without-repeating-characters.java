class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If character exists in map and is inside current window
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1; // move left pointer
            }

            // Update last index
            map.put(c, right);

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}