package at.kulu;

import at.kulu.interfaces.ITicTacToe;
import java.util.Scanner;

/**
 * Controls the flow of a Tic-Tac-Toe game.
 *
 * <p>This class is responsible for managing the overall game lifecycle,
 * including player turns, user input, move execution, and game termination.
 * It coordinates interactions between players and the game board but does
 * not directly manage the board's internal state.</p>
 *
 * <p>The {@code TicTacToe} class:</p>
 * <ul>
 *   <li>Starts and restarts a game</li>
 *   <li>Handles player input and moves</li>
 *   <li>Switches turns between players</li>
 *   <li>Checks for win and draw conditions</li>
 *   <li>Notifies players about the game outcome</li>
 * </ul>
 *
 * <p>This class implements the {@link ITicTacToe} interface and represents
 * the central game controller.</p>
 */
public class TicTacToe implements ITicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    /**
     * Handles a single move by the current player.
     * Prompts the player for input, validates the chosen position,
     * and places the player's marker on the board once a valid
     * move is provided.
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
     * Starts the Tic-Tac-Toe game and notifies players when the game ends.
     */
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        board.clear();
        currentPlayer = player1;

        while (true) {
            board.print();
            makeMove(scanner);

            if (hasWinner()) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                break;
            }

            if (isDraw()) {
                board.print();
                System.out.println("The game ends in a draw.");
                break;
            }

            switchCurrentPlayer();
        }
    }


    /**
     * Placeholder Java Docs.
     */
    @Override
    public void switchCurrentPlayer() {

    }

    /**
     * Checks whether the current player has won the game.
     *
     * <p>A win occurs when the current player has placed their marker
     * in three consecutive cells in a row, column, or diagonal.</p>
     *
     * @return true if the current player has won, false otherwise
     */
    @Override
    public boolean hasWinner() {
        char m = currentPlayer.getMarker();

        for (int i = 0; i < 3; i++) {
            if (board.get(i, 0) == m && board.get(i, 1) == m && board.get(i, 2) == m) {
                return true;
            }
            if (board.get(0, i) == m && board.get(1, i) == m && board.get(2, i) == m) {
                return true;
            }
        }

        if (board.get(0, 0) == m && board.get(1, 1) == m && board.get(2, 2) == m) {
            return true;
        }

        if (board.get(0, 2) == m && board.get(1, 1) == m && board.get(2, 0) == m) {
            return true;
        }

        return false;
    }

    /**
     * Checks whether the game has ended in a draw.
     *
     * <p>A draw occurs when the board is full and no player has won.</p>
     *
     * @return true if the game is a draw, false otherwise
     */
    private boolean isDraw() {
        return board.isFull();
    }



}
