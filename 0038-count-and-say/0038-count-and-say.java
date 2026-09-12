class Solution {
    public String countAndSay(int n) {

        String result = "1";

        for (int i = 2; i <= n; i++) {
            result = describe(result);
        }

        return result;
    }

    private String describe(String s) {

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            char digit = s.charAt(i);
            int count = 0;

            // Count consecutive same digits
            while (i < s.length() && s.charAt(i) == digit) {
                count++;
                i++;
            }

            // Add count + digit
            result.append(count);
            result.append(digit);
        }

        return result.toString();
    }
}