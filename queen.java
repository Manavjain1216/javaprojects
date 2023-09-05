import java.util.Scanner;

public class queen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the chessboard (N): ");
        int n = scanner.nextInt();

        int[] queens = new int[n]; // queens[i] represents the column of the queen in row i
        solveNQueens(queens, 0, n);

        scanner.close();
    }

    public static void solveNQueens(int[] queens, int row, int n) {
        if (row == n) {
            printBoard(queens);
        } else {
            for (int col = 0; col < n; col++) {
                if (isSafe(queens, row, col)) {
                    queens[row] = col;
                    solveNQueens(queens, row + 1, n);
                }
            }
        }
    }

    public static boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            // Check if there is a queen in the same column or diagonals
            if (queens[i] == col || queens[i] - i == col - row || queens[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(int[] queens) {
        int n = queens.length;
        System.out.println("Solution:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
