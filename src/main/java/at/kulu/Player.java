package at.kulu;

import at.kulu.interfaces.IPlayer;

/**
 * Represents a player in the Tic-Tac-Toe game.
 *
 * <p>A player is defined by a single marker (for example {@code 'X'} or
 * {@code 'O'}) that is placed on the board during the game. This class
 * provides access to the player’s marker but does not contain any game
 * logic such as turn handling or move validation.</p>
 *
 * <p>The {@code Player} class implements the {@link IPlayer} interface.</p>
 */
public class Player implements IPlayer {

    /**
     * Returns the marker assigned to this player.
     *
     * <p>The marker uniquely identifies the player on the game board
     * (for example {@code 'X'} or {@code 'O'}). It is used when placing
     * moves during the game.</p>
     *
     * @return the player's marker
     */
    @Override
    public char getMarker() {
        return 0;
    }
}
