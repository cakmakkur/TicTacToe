package at.kulu;

import at.kulu.interfaces.ITicTacToe;

import java.util.Scanner;

public class TicTacToe implements ITicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;


    /**
     * Handles a single move by the current player.
     *
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
     * Placeholder Java Docs
     */
    @Override
    public void start() {

    }

    /**
     * Placeholder Java Docs
     */
    @Override
    public void switchCurrentPlayer() {

    }

    /**
     * Placeholder Java Docs
     * @return false
     */
    @Override
    public boolean hasWinner() {
        return false;
    }
}
