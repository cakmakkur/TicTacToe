package at.kulu;

import at.kulu.interfaces.ITicTacToe;
import java.util.Scanner;

/**
 * Controls the flow of a Tic-Tac-Toe game.
 */
public class TicTacToe implements ITicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    /**
     * Creates a new TicTacToe game.
     */
    public TicTacToe() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

    /**
     * Handles a single move by the current player.
     */
    private void makeMove(Scanner scanner) {
        int x;
        int y;

        while (true) {
            System.out.print("Player " + currentPlayer.getMarker() + " move (row col): ");
            x = scanner.nextInt();
            y = scanner.nextInt();

            if (x < 0 || x > 2 || y < 0 || y > 2) {
                System.out.println("Out of bounds.");
                continue;
            }

            if (!board.isCellEmpty(x, y)) {
                System.out.println("Cell occupied.");
                continue;
            }

            break;
        }

        board.place(x, y, currentPlayer.getMarker());
    }

    /**
     * Starts the game loop.
     */
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        board.clear();

        while (true) {
            board.print();
            makeMove(scanner);

            if (hasWinner()) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                restartGame(scanner);
                break;
            }

            if (board.isFull()) {
                board.print();
                System.out.println("The game ends in a draw.");
                restartGame(scanner);
                break;
            }

            switchCurrentPlayer();
        }
    }

    /**
     * Switches the current player.
     */
    @Override
    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    /**
     * Checks whether the current player has won.
     *
     * @return true if the current player has won
     */
    @Override
    public boolean hasWinner() {
        char[][] c = board.getCells();
        char m = currentPlayer.getMarker();

        for (int i = 0; i < 3; i++) {
            if (c[i][0] == m && c[i][1] == m && c[i][2] == m) {
                return true;
            }
            if (c[0][i] == m && c[1][i] == m && c[2][i] == m) {
                return true;
            }
        }

        return (c[0][0] == m && c[1][1] == m && c[2][2] == m)
                || (c[0][2] == m && c[1][1] == m && c[2][0] == m);
    }

    /**
     * Asks the players if they want to play again.
     */
    public void restartGame(Scanner scanner) {
        System.out.println("Do you want to play again [Y/n]?     ");
        String restart = scanner.next();
        restart = restart.toLowerCase();

        switch (restart) {
            case "y": 
                start();
                break;
            case "n":
                System.out.println("Game ends. Bye!");
                break;
            default:
                System.out.println("Invalid Input. Game ends.");
        }
    }
}
