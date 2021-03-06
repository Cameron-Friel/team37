package models;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class SpanishBoard extends Board{

    //board data members

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(); //array to hold the cards on the board

    public int score;

    public SpanishBoard()
    {
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        score = 0;
    }

    public void remove(int columnNumber) {
        if(columnHasCards(columnNumber)) {
            Card c = getTopCard(columnNumber);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHasCards(i)) {
                        Card compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                            else if (compare.getValue() == 13)
                            {
                                removeCard = true;
                            }
                        }

                    }
                }
            }
            if (removeCard) {
                this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
                this.score++;
                if(this.score >= 46)
                {
                    JOptionPane.showMessageDialog(null, "YOU WIN!");
                }
            }
        }
    }

    private boolean columnHasCards(int columnNumber) {
        if(this.cols.get(columnNumber).size()>0){
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }

    public void move(int columnFrom, int columnTo) {
        // Check if the column is empty and the value of the card being moved is an ace (has the value of 14)
        if((columnHasCards(columnTo) == false) && (getTopCard(columnFrom).value == 14)) {
            Card cardToMove = getTopCard(columnFrom);
            this.removeCardFromCol(columnFrom);
            this.addCardToCol(columnTo, cardToMove);
        }
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
