package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){
        // initialize a new game such that each column can store cards
        int counter=0;
        while(counter<4){
            //add 14 slots in each column for cards
            cols.add(new ArrayList<Card>(14));
            counter++;
        }
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
        // shuffles the deck so that it is random
        Random rand = new Random(); //initialize random variable

        for (int i = 0; i < 100; i++) //iterate through 100 times for card shifting
        {
                int firstIndex = 1 + rand.nextInt(51); //first position to change
                int secondIndex = 1 + rand.nextInt(51); //second position to change
        
                //swap positions of the two randomly chosen indexes
                Collections.swap(deck, firstIndex, secondIndex);
        }
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        int counter=0;
        while(counter<4){
            //initialize size of deck
            int deckSize=this.deck.size()-1;
            //add top card to column
            addCardToCol(counter, this.deck.get(deckSize));
            //remove top card from deck
            this.deck.remove(deckSize);
            counter++;
        }
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        // Initialize variables
        int hearts, diamonds, spades, clubs;
        hearts = diamonds = spades = clubs = 0;
        Card hearts_compare = new Card(1,Suit.Hearts);
        Card diamonds_compare = new Card(1,Suit.Diamonds);
        Card spades_compare = new Card(1,Suit.Spades);
        Card clubs_compare = new Card(1,Suit.Clubs);
        java.util.List<Card> temp = new ArrayList<>(4);

        // Count the instances of each suit at the top of the columns
        for(int i = 0; i < 4; i++){
            temp.add(getTopCard(i));
            if (temp.get(i).suit == hearts_compare.suit) {
                hearts++;
            }else if (temp.get(i).suit == diamonds_compare.suit){
                diamonds++;
            }else if (temp.get(i).suit == spades_compare.suit){
                spades++;
            }else if (temp.get(i).suit == clubs_compare.suit){
                clubs++;
            }
        }

        // Loop through the respective suit and remove the lower value
        // Return prevents elimination of more than 1 value on a single click
        while (hearts >= 2){
            for(int i = 0; i < 4; i++){
                if (temp.get(i).suit == hearts_compare.suit){
                    for(int k = i + 1; k < 4; k++) {
                        if (temp.get(k).suit == hearts_compare.suit) {
                            if (temp.get(i).value < temp.get(k).value && i == columnNumber) {
                                removeCardFromCol(i);
                                hearts--;
                                return;
                            } else if(temp.get(i).value > temp.get(k).value && k == columnNumber){
                                removeCardFromCol(k);
                                hearts--;
                                return;
                            }
                        }
                    }
                }
            }
        }

        // Loop through the respective suit and remove the lower value
        // Return prevents elimination of more than 1 value on a single click
        while (diamonds >= 2){
            for(int i = 0; i < 4; i++){
                if (temp.get(i).suit == diamonds_compare.suit){
                    for(int k = i + 1; k < 4; k++) {
                        if (temp.get(k).suit == diamonds_compare.suit) {
                            if (temp.get(i).value < temp.get(k).value && i == columnNumber) {
                                removeCardFromCol(i);
                                diamonds--;
                                return;
                            } else if(temp.get(i).value > temp.get(k).value && k == columnNumber){
                                removeCardFromCol(k);
                                diamonds--;
                                return;
                            }
                        }
                    }
                }
            }
        }

        // Loop through the respective suit and remove the lower value
        // Return prevents elimination of more than 1 value on a single click
        while (spades >= 2){
            for(int i = 0; i < 4; i++){
                if (temp.get(i).suit == spades_compare.suit){
                    for(int k = i + 1; k < 4; k++) {
                        if (temp.get(k).suit == spades_compare.suit) {
                            if (temp.get(i).value < temp.get(k).value && i == columnNumber) {
                                removeCardFromCol(i);
                                spades--;
                                return;
                            } else if(temp.get(i).value > temp.get(k).value && k == columnNumber){
                                removeCardFromCol(k);
                                spades--;
                                return;
                            }
                        }
                    }
                }
            }
        }

        // Loop through the respective suit and remove the lower value
        // Return prevents elimination of more than 1 value on a single click
        while (clubs >= 2){
            for(int i = 0; i < 4; i++){
                if (temp.get(i).suit == clubs_compare.suit){
                    for(int k = i + 1; k < 4; k++) {
                        if (temp.get(k).suit == clubs_compare.suit) {
                            if (temp.get(i).value < temp.get(k).value && i == columnNumber) {
                                removeCardFromCol(i);
                                clubs--;
                                return;
                            } else if(temp.get(i).value > temp.get(k).value && k == columnNumber){
                                removeCardFromCol(k);
                                clubs--;
                                return;
                            }
                        }
                    }
                }
            }
        }

    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) 
        
        // Get which card to move and store it
        Card cardToMove = getTopCard(columnFrom);
        //remove the card from the original column
        removeCardFromCol(columnFrom);
        // add card to new column
        addCardToCol(columnTo, cardToMove);

       
    }


    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
