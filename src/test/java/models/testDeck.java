package models;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testDeck {

    @Test
    public void buildDeck(){
        Deck d = new Deck();
        assertNotNull(d);
    }

}