package at.kulu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for class TicTacToe and all methods it includes.
 */
class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    @Test
    void testRandomStartPlayer() {
        TicTacToe game = new TicTacToe();

        char current = game.getCurrentPlayer();

        assertTrue(current == 'X' || current == 'O',
                "Startspieler muss X oder O sein");
    }

    @Test
    void testSwichCurrentPlayer() {
        char initialPlayer = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        char switchedPlayer = game.getCurrentPlayer();

        assertNotEquals(initialPlayer, switchedPlayer);
    }

    @Test
    void testHasWinner_XRowWin() {
        if (game.getCurrentPlayer() != 'X') {
            game.switchCurrentPlayer();
        }

        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');

        assertTrue(game.hasWinner(), "currentPlayer X should have won in the first row");
    }

    @Test
    void testHasWinner_ORowWin() {
        if (game.getCurrentPlayer() != 'O') {
            game.switchCurrentPlayer();
        }

        game.getBoard().place(1, 0, 'O');
        game.getBoard().place(1, 1, 'O');
        game.getBoard().place(1, 2, 'O');

        assertTrue(game.hasWinner(), "currentPlayer O should have won in the second row");
    }

    @Test
    void testHasWinner_XDiagonalWin() {
        if (game.getCurrentPlayer() != 'X') {
            game.switchCurrentPlayer();
        }

        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(1, 1, 'X');
        game.getBoard().place(2, 2, 'X');

        assertTrue(game.hasWinner(), "currentPlayer X should have won in the diagonal direction");
    }

    @Test
    void testMakeMoveWithScanner() {
        String simulatedInput = "1 2\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        Board board = new Board();
        char marker = 'X';

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        board.place(x, y, marker);

        assertEquals('X', board.getCells()[1][2]);
    }

    @Test
    void testMultipleMoves() {
        String simulatedInput = "0 0\n1 1\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        Board board = new Board();
        char marker1 = 'X';
        char marker2 = 'O';

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        board.place(x1, y1, marker1);

        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        board.place(x2, y2, marker2);

        assertEquals('X', board.getCells()[0][0]);
        assertEquals('O', board.getCells()[1][1]);
    }

    @Test
    void testRestartGameTrue() {
        TicTacToeSpy spyClass = new TicTacToeSpy();
        String simulatedInput = "y\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        spyClass.restartGame(scanner);
        assertTrue(spyClass.startCalled);
    }

    @Test
    void testRestartGameFalse() {
        TicTacToeSpy spyClass = new TicTacToeSpy();
        String simulatedInput = "n\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        spyClass.restartGame(scanner);
        assertFalse(spyClass.startCalled);
    }

    @Test
    void testRestartGameInvalid() {
        TicTacToeSpy spyClass = new TicTacToeSpy();
        String simulatedInput = "x\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        spyClass.restartGame(scanner);
        assertFalse(spyClass.startCalled);
    }

}

class TicTacToeSpy extends TicTacToe {
    boolean startCalled = false;

    @Override
    public void start() {
        startCalled = true;
    }
}
