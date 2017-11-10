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

    public java.util.List<Card> deck = new ArrayList<>();

    public Board gameBoard; //object to hold the columns which hold cards

    public Game(){

        gameBoard = new Board(); // initialize a new board object for the game
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public void dealFour(Board gameBoard) {
        for(int i = 0; i < 4; i++){
            gameBoard.cols.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
            System.out.println("HERRO");
            //System.out.println(gameBoard);
            //System.out.println(gameBoard.cols);
        }
    }

    //customDeal to setup game for testing purposes
    /*public void customDeal(int c1, int c2, int c3, int c4) {
        cols.get(0).add(deck.get(c1));
        deck.remove(c1);
        cols.get(1).add(deck.get(c2));
        deck.remove(c2);
        cols.get(2).add(deck.get(c3));
        deck.remove(c3);
        cols.get(3).add(deck.get(c4));
        deck.remove(c4);
    }*/
}
