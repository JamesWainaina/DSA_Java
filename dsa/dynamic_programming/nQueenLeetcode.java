import java.util.ArrayList;
import java.util.List;

public class nQueenLeetcode {
    // Method to solve N-Queens
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> board = new ArrayList<>();
        boolean[] rows = new boolean[n]; // Corrected size
        boolean[] diag1 = new boolean[2 * n]; // Corrected size
        boolean[] diag2 = new boolean[2 * n]; // Corrected size
        nQueenUtil(0, n, board, res, rows, diag1, diag2);
        return res;
    }

    // Helper function to place queens
    public void nQueenUtil(int col, int n, List<String> board, List<List<String>> res, boolean[] rows, boolean[] diag1, boolean[] diag2) {
        if (col == n) {
            res.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (!rows[row] && !diag1[row + col] && !diag2[row - col + n]) {
                rows[row] = diag1[row + col] = diag2[row - col + n] = true;

                // Build the row string with the queen in the correct position
                char[] currentRow = new char[n];
                for (int i = 0; i < n; i++) currentRow[i] = '.';
                currentRow[row] = 'Q';
                board.add(new String(currentRow));

                // Recurse to the next column
                nQueenUtil(col + 1, n, board, res, rows, diag1, diag2);

                // Backtrack
                board.remove(board.size() - 1);
                rows[row] = diag1[row + col] = diag2[row - col + n] = false;
            }
        }
    }

    // Main method to test the solveNQueens method
    public static void main(String[] args) {
        nQueenLeetcode solution = new nQueenLeetcode();

        // Test case: N = 4 (The 4-Queens problem)
        int n = 4;
        List<List<String>> result = solution.solveNQueens(n);

        // Printing the result
        System.out.println("The possible solutions for " + n + "-Queens are:");
        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println(); // Separate solutions with a blank line
        }
    }
}

