package models;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testBoard {

    @Test
    public void testBoardArray(){
        Board b = new Board();
        assertNotNull(b.cols);
    }
/*
    @Test
    public void testRemoveFunction(){
        Board b = new Board();
        Card c = new Card(9, Suit.Spades);
        b.addCardToCol(c);
        b.remove(0);
        assertEquals(0, b.columnHasCards(0));
    }*/
}