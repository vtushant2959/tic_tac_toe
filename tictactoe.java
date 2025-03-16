import java.util.Scanner;

public class tictactoe {
    static char[][] board = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X'; // Player X always starts
        boolean gameWon = false;

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        for (int turn = 0; turn < 9; turn++) { // At most, 9 turns
            int row, col;

            // Get valid input
            while (true) {
                System.out.println("Player " + currentPlayer + ", enter row (1-3) and column (1-3): ");
                row = scanner.nextInt() - 1; // Adjusting for 0-based index
                col = scanner.nextInt() - 1;

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    break; // Valid input
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }

            board[row][col] = currentPlayer; // Mark the board
            printBoard(); // Show updated board

            // Check if current player wins
            if (checkWin(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameWon = true;
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        if (!gameWon) {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }

    // Function to print the board
    static void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    // Function to check if a player has won
    static boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || 
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }
}
