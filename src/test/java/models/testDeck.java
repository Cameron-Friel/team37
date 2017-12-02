package models;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testDeck {

    @Test
    public void buildDeck(){
        Deck d = new Deck();
        assertNotNull(d.cards);
    }

    @Test
    public void testShuffle(){
        Deck d1 = new Deck();
        deck.shuffle();
        Deck d2 = new Deck();
        deck.shuffle();
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(d1.cards.toArray(),d2.cards.toArray()));
    }

}