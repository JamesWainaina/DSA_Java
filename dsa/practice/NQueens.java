import java.util.*;


public class Nqueens {
    // function to check if placing a queen at (row, col) is safe
    private static boolean isSafe(int row, int col, int[] queens){
        for (int i = 0; i < row; i++){
            // check if theres a queen  in the same column
            if (queens[i] == col) return false;

            // check diagnols
            if (Math.abs(queens[i] - col) == Math.abs(i - row)) return false;
        }
        return true;
    }
    // recursive backtracking to place queens
    private static void solveNqueens(int row, int n, int[] queens, List<List<Integer>> solutions) {
        if (row == n){
            // All queens are placed, add the solution
            List<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++){
                soltion.add(i, queens[i]);
            }
            solutions.add(solution);
            return;
        }
        // try placing a queen in each column of the current row
        for (int col = 0; col < n; col++){
            if (isSafe(row, col, queens)){
                //place the queen
                queens[row] = col;
                // recurse to place the queens in the next row
                solveNQueens(row +1, n, queens, solutions);
            }
        }
    }

    // public method to solve the N-Queens problem and print solutions
    public static void solve(int n){
        // Array to store the column positions of queens
        int[] queens = new int[n];

        List<List<Integer>> solutions = new ArrayList<>();
        // start solving from the first row
        solveNQueens(0, n, queens,solutions);

        // print all the solutons
        for (List<Integer> solution : solutions) {
            System.out.printlns(solution);
        }
    }
}
