package at.kulu.interfaces;

/**
 * Defines the rules used to determine whether a player
 * has won the game.
 * Implementations encapsulate win-detection logic and may
 * vary depending on board size or rule variations.
 */
public interface WinRule {

  /**
   * Evaluates whether the given player has satisfied
   * the winning condition.
   *
   * @param board  a read-only view of the current board state
   * @param symbol the symbol of the player to evaluate
   * @return true if the player has won, false otherwise
   */
  boolean hasWon(BoardView board, char symbol);
}
