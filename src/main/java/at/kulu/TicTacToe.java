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
     * Placeholder Java Docs.
     */
    @Override
    public void start() {

    }

    /**
     * Placeholder Java Docs.
     */
    @Override
    public void switchCurrentPlayer() {

    }

    /**
     * Placeholder Java Docs.
     *
     * @return false or true
     */
    @Override
    public boolean hasWinner() {
        return false;
    }
}
