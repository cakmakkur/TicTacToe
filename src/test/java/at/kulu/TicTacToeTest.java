package at.kulu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        // current muss X oder O sein
        assertTrue(current == 'X' || current == 'O',
                "Startspieler muss X oder O sein");
    }

    @Test
    void testSwichCurrentPlayer() {
        char initialPlayer = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        char switchedPlayer = game.getCurrentPlayer();

//        assertEquals('X', initialPlayer);
//        assertEquals('O', switchedPlayer);

        System.out.println("InitialPlayer: " + initialPlayer);
        System.out.println("SwitchedPlayer: " + switchedPlayer);
    }

    //    @Override
    //    public boolean hasWinner() {
    //        char[][] c = board.getCells();
    //        char m = currentPlayer.getMarker();
    //
    //        for (int i = 0; i < 3; i++) {
    //            if (c[i][0] == m && c[i][1] == m && c[i][2] == m) {
    //                return true;
    //            }
    //            if (c[0][i] == m && c[1][i] == m && c[2][i] == m) {
    //                return true;
    //            }
    //        }
    //
    //        return (c[0][0] == m && c[1][1] == m && c[2][2] == m)
    //                || (c[0][2] == m && c[1][1] == m && c[2][0] == m);
    //    }

    @Test
    void testHasWinner() {

    }
}
