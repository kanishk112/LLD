
import java.util.Scanner;

public class Game {

    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void play() {
        board.display();
        while (!board.isFull() && !board.isWinner(currentPlayer.getSymbol())) {
            System.err.println("current player: " + currentPlayer.getName() + "'s turn");
            int row = getValidInput("Enter row (0-2): ");
            int col = getValidInput("Enter column (0-2): ");

            try {
                if (!board.markCell(row, col, currentPlayer.getSymbol())) {
                    System.out.println("Invalid move! Try again.");
                    continue;
                }
                board.markCell(row, col, currentPlayer.getSymbol());
                board.display();
                switchPlayer();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }

            if (board.isWinner(player1.getSymbol())) {
                System.out.println(player1.getName() + " wins!");
            } else if (board.isWinner(player2.getSymbol())) {
                System.out.println(player2.getName() + " wins!");
            } else if(board.isFull()){
                System.out.println("It's a draw!");
            }
        }
    }

    private int getValidInput(String enter_row_) {
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            System.out.print(enter_row_);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0 && input <= 2) {
                    return input;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Please enter a number between 0 and 2.");
        }
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
}
