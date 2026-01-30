package at.kulu.interfaces;

/**
 * Represents the Tic-Tac-Toe game board.
 * The board manages cell state, placement of markers,
 * and basic board-level queries such as fullness.
 * Implementations are also responsible for rendering
 * the board state, as required by the given design.
 */
public interface IBoard {

    /**
     * Checks whether a specific cell is empty.
     *
     * @param x zero-based row index
     * @param y zero-based column index
     * @return true if the cell is empty, false otherwise
     */
    boolean isCellEmpty(int x, int y);

    /**
     * Places a marker in the specified cell.
     * No validation is required by this contract;
     * callers are responsible for ensuring the move is valid.
     *
     * @param x      zero-based row index
     * @param y      zero-based column index
     * @param marker the marker to place
     */
    void place(int x, int y, char marker);

    /**
     * Checks whether the board is completely filled.
     *
     * @return true if no empty cells remain, false otherwise
     */
    boolean isFull();

    /**
     * Clears the board by resetting all cells
     * to their initial empty state.
     */
    void clear();

    /**
     * Prints the current state of the board.
     * The concrete output format is implementation-specific.
     */
    void print();
}
