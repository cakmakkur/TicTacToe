package at.kulu.interfaces;

/**
 * Represents a player in the Tic-Tac-Toe game.
 * A player is identified solely by its marker.
 * No decision-making or input logic is defined here,
 * as required by the class diagram.
 */
public interface IPlayer {

    /**
     * Returns the marker associated with this player
     * (for example 'X' or 'O').
     *
     * @return the player's marker
     */
    char getMarker();
}

