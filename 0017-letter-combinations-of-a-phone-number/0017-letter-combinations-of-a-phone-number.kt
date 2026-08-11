class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val map = arrayOf(
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        )

        val result = mutableListOf<String>()
        val current = StringBuilder()

        fun backtrack(index: Int) {
            if (index == digits.length) {
                result.add(current.toString())
                return
            }

            val letters = map[digits[index] - '0']

            for (letter in letters) {
                current.append(letter)
                backtrack(index + 1)
                current.deleteCharAt(current.length - 1)
            }
        }

        backtrack(0)
        return result
    }
}