package at.kulu.interfaces;

/**
 * Defines the user interface contract for presenting game state
 * and feedback to the user.
 * Implementations handle rendering and messaging only.
 * No game logic or state mutation must occur here.
 * Examples of implementations include console-based UIs,
 * graphical UIs, or web-based frontends.
 */
public interface GameUI {

  /**
   * Renders the current state of the game board.
   *
   * @param board a read-only view of the current board state
   */
  void render(BoardView board);

  /**
   * Informs the user that an attempted move was invalid.
   */
  void showInvalidMove();

  /**
   * Displays the winner of the game.
   *
   * @param symbol the symbol of the winning player
   */
  void showWinner(char symbol);

  /**
   * Displays that the game has ended in a draw.
   */
  void showDraw();
}
