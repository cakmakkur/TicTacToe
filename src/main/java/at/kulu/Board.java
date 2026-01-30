package at.kulu;

import at.kulu.interfaces.IBoard;

public class Board implements IBoard {

    private char[][] cells;

    /**
     * Checks whether the specified cell is empty.
     *
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
     *
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
     * Placeholder Java Docs
     * @return true
     */
    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * Placeholder Java Docs
     */
    @Override
    public void clear() {

    }

    /**
     * Placeholder Java Docs
     */
    @Override
    public void print() {

    }

}
