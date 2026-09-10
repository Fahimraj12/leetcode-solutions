class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char c = board[row][col];

                // Ignore empty cells
                if (c == '.') {
                    continue;
                }

                int digit = c - '1';

                // Find the 3 x 3 box
                int box = (row / 3) * 3 + (col / 3);

                // Check for duplicate
                if (rows[row][digit] ||
                    cols[col][digit] ||
                    boxes[box][digit]) {

                    return false;
                }

                // Mark digit as used
                rows[row][digit] = true;
                cols[col][digit] = true;
                boxes[box][digit] = true;
            }
        }

        return true;
    }
}