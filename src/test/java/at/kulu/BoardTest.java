package at.kulu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void isCellEmpty_returnsTrueForEmptyCell() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void isCellEmpty_returnsFalseForOccupiedCell() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void place_setsMarkerCorrectly() {
        board.place(1, 1, 'O');
        assertEquals('O', board.getCells()[1][1]);

        board.place(0, 1, 'X');
        assertEquals('X', board.getCells()[0][1]);
    }

    @Test
    void place_overwritesExistingMarker() {
        board.place(1, 1, 'X');
        assertEquals('X', board.getCells()[1][1]);
        board.place(1, 1, 'O');
        assertEquals('O', board.getCells()[1][1]);
    }

    @Test
    void isFull_returnsFalseForEmptyBoard() {
        assertFalse(board.isFull());
    }

    @Test
    void isFull_returnsTrueWhenBoardIsCompletelyFilled() {
        char marker = 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, marker);
                marker = (marker == 'X') ? 'O' : 'X';
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void clear_emptiesPreviouslyFilledBoard() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');

        board.clear();

        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    void clear_resultsInNonFullBoard() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');

        board.clear();

        assertFalse(board.isFull());
    }

    @Test
    void print_doesNotThrowExceptionOnEmptyBoard() {
        assertDoesNotThrow(() -> board.print());
    }

    @Test
    void print_doesNotThrowExceptionOnFilledBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertDoesNotThrow(() -> board.print());
    }

    @Test
    void print_doesNotThrowExceptionOnPartiallyFilledBoard() {
        for (int i = 2; i < 3; i++) {
            for (int j = 2; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertDoesNotThrow(() -> board.print());
    }

    @Test
    void getCells_returns3x3Array() {
        char[][] cells = board.getCells();
        assertEquals(3, cells.length);
        assertEquals(3, cells[0].length);
    }

    @Test
    void getCells_reflectsPlacedMarkers() {
        board.place(2, 2, 'X');
        assertEquals('X', board.getCells()[2][2]);
    }
}
