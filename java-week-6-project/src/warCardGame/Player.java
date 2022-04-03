package warCardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
	public List<Card> hand = new ArrayList<>();
    private int score;
    private String name;

    /*
     * Players and their scores are set for a new game
     */
    public Player(String name) {
	this.name =name;
	this.score =0;
    }

    /*
     * Card attributes are described if called.
     */
    public void describe() {
	for (Card card : hand) {
	    card.describe();
	}
    }

    /*
     * Top card is retrieved from the hand for battle
     */
    public Card flip() {
	Card card = hand.get(0);
	hand.remove(0);
	return card;
    }

    /*
     * Used to divide the decks amongst the players
     */
    public void draw(Deck deck) {
	hand.add(deck.draw());
    }

    /*
     * Gives the according player their battle victory
     */
    public void incrementScore() {
	this.score=(score + 1);
    }

    /*
     * @return the score
     */
    public int getScore() {
	return score;
    }

    /*
     * @return the name
     */
    public String getName() {
	return name;
    }

}
