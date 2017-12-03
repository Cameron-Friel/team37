package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Students must implement dealFour(), remove(), move(), and columnHasCards() methods
 *
 * The customDeal() method is not present in the Assignment1_Student version since tests (and the test dir) are removed
 * to prevent confusion regarding testing and the use of unit tests; testing is covered more thoroughly in CS362.
 */
public class Game {

    //members of the game class    

    public Deck d;
    public Board gameBoard;

    public Game(){
        d = new Deck();
        gameBoard = new Board();

    }

    public Game(int gameMode) //constructor takes in argument for which deck to use
    {
        if (gameMode == 0) //use regular deck
        {
            d = new Deck();
            gameBoard = new Board();
        }
        else //use spanish deck
        {
            d = new Deck();
            gameBoard = new Board();
        }
    }
}
