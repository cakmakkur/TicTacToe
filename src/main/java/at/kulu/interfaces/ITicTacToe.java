package at.kulu.interfaces;

/**
 * Controls the lifecycle and flow of a Tic-Tac-Toe game.
 * Implementations are responsible for:
 * - Initializing players and the board
 * - Managing turns and the current player
 * - Detecting game end conditions (win or draw)
 * This interface represents the main game controller.
 */
public interface ITicTacToe {

    /**
     * Starts the game loop.
     * This method blocks until the game ends
     * either by a win or a draw.
     */
    void start();
}
