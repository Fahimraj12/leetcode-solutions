class Solution {
    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Empty string can be matched by '*' only
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                char strChar = s.charAt(i - 1);
                char patternChar = p.charAt(j - 1);

                // Normal character or '?'
                if (patternChar == '?' || patternChar == strChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // '*'
                else if (patternChar == '*') {

                    // '*' matches empty
                    // OR
                    // '*' matches current character
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}