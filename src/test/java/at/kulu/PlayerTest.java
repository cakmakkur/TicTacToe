package at.kulu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlayerTest {

    @Test
    public void testGetMarkerX(){
        Player player1 = new Player('X');
        assertEquals('X', player1.getMarker());
    }

    @Test
    public void testGetMarkerO(){
        Player player2 = new Player('O');
        assertEquals('O', player2.getMarker());
    }
}
