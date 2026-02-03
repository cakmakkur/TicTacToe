package at.kulu;

import at.kulu.interfaces.IBoard;

/**
 * Represents the Tic-Tac-Toe game board.
 */
public class Board implements IBoard {

    private char[][] cells;

    /**
     * Creates a new empty board.
     */
    public Board() {
        clear();
    }

    @Override
    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    @Override
    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    /**
     * Checks whether the board is completely filled.
     *
     * @return true if no empty cells remain, false otherwise
     */
    @Override
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Clears the board by resetting all cells.
     */
    @Override
    public void clear() {
        cells = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + cells[i][j] + " ");
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
    }

    /**
     * Internal access for win checking (package-private on purpose).
     */
    char[][] getCells() {
        return cells;
    }
}
