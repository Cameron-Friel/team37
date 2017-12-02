package models;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testBoard {

    @Test
    public void testBoardArray(){
        Board b = new Board();
        assertNotNull(b.cards);
    }

    @Test
    public void testRemoveFunction(){
        Board b = new Board();
        Card c = new Card(9, suit.Spades);
        b.add(c)
        g.remove(0);
        assertEquals(0, b.cards.size());
    }
}