package models;

public class SpanishDeck extends Deck{

    @Override
    public void buildDeck() {

        // Add all cards except aces and jokers to the deck
        for(int i = 1; i < 13; i++)
        {
            deck.add(new Card(i,Suit.Bastos));
            deck.add(new Card(i,Suit.Oros));
            deck.add(new Card(i,Suit.Copas));
            deck.add(new Card(i,Suit.Espadas));
        }

        // Add the 2 jokers to the deck, their value is greater than aces to maintain remove logic
        deck.add(new Card(13, Suit.Jokers));
        deck.add(new Card(13, Suit.Jokers));
    }
}
