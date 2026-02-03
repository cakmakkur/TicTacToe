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

    private final char marker;

    /**
     * Creates a new player with the given marker.
     *
     * @param marker the marker for this player (e.g. 'X' or 'O')
     */
    public Player(final char marker) {
        this.marker = marker;
    }

    /**
     * Returns the marker assigned to this player.
     *
     * @return the player's marker
     */
    @Override
    public char getMarker() {
        return marker;
    }
}
