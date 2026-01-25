package at.kulu.interfaces;

import at.kulu.dtos.Move;

/**
 * Represents a participant in the game.
 * A Player is responsible for deciding its next move based on
 * the current state of the board. Implementations may represent
 * a human player, an AI, or any other decision-making strategy.
 * A Player must not mutate the board directly.
 */
public interface Player {

  /**
   * Returns the symbol used by this player (e.g. 'X' or 'O').
   *
   * @return the player symbol
   */
  char symbol();

  /**
   * Determines the next move for this player.
   * The provided board view represents the current immutable
   * state of the game board at the time of the move decision.
   *
   * @param board a read-only view of the current board state
   * @return the move the player wishes to make
   */
  Move nextMove(BoardView board);
}