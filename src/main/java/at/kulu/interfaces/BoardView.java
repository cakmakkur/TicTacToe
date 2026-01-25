package at.kulu.interfaces;

/**
 * Provides a read-only view of the game board.
 * This interface exists to expose board state safely
 * to players, UI components, and rule evaluators
 * without allowing mutation.
 */
public interface BoardView {

  /**
   * Returns the symbol stored at the given board position.
   *
   * @param row zero-based row index
   * @param col zero-based column index
   * @return the symbol at the specified position, or a space
   *         character if the cell is empty
   */
  char getCell(int row, int col);

  /**
   * Returns the size of the board (e.g. 3 for a 3x3 board).
   *
   * @return the board dimension
   */
  int size();
}
