package at.kulu;

import at.kulu.interfaces.IBoard;

/**
 * Represents the Tic-Tac-Toe game board.
 *
 * <p>The board is implemented as a 3x3 grid of characters where each cell
 * can contain a player marker or be empty. This class is responsible for
 * storing and updating the board state, but it does not contain any game
 * logic such as turn handling or win detection.</p>
 *
 * <p>The {@code Board} class provides operations to:</p>
 * <ul>
 *   <li>Check whether a cell is empty</li>
 *   <li>Place a marker on the board</li>
 *   <li>Determine whether the board is full</li>
 *   <li>Reset the board to its initial empty state</li>
 *   <li>Print the current board state to the console</li>
 * </ul>
 *
 * <p>This class implements the {@link IBoard} interface.</p>
 */
public class Board implements IBoard {

    private char[][] cells;

    /**
     * Checks whether the specified cell is empty.
     * This method is used to validate a player's move before
     * placing a marker on the board.
     *
     * @param x zero-based row index
     * @param y zero-based column index
     * @return true if the cell is empty, false otherwise
     */
    @Override
    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    /**
     * Places a marker on the specified cell.
     * This method assumes that the move has already been validated
     * by the caller.
     *
     * @param x      zero-based row index
     * @param y      zero-based column index
     * @param marker the player's marker to place
     */
    @Override
    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    /**
     * Placeholder Java Docs.
     *
     * @return true or false.
     */
    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * Placeholder Java Docs.
     */
    @Override
    public void clear() {

    }

    /**
     * Placeholder Java Docs.
     */
    @Override
    public void print() {

    }

}
