package at.kulu.dtos;

/**
 * Represents an immutable move on the game board.
 * A move consists of a row and column coordinate.
 */
public record Move(int row, int col) {}