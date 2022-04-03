package warCardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	public List<Card> cards = new ArrayList<>();
	
	private List<String> suits = List.of(" of Clubs", " of Diamonds", 
			" of Hearts", " of Spades");
	
	/*
	 * Deck is instantiated as (value + the "of suit")
	 * where the value is then replaced in the for loop
	 * with the phonetic attribute according to its
	 * value
	 */
	
	public Deck() {
		for (int i=0; i<suits.size(); i++) {
			String suit = "";
			suit = suits.get(i).toString();
			for (int j=2; j<15; j++) {
				String uCard = "";
				if (j==2) {
					uCard = "Two"+suit;
				}
				else if (j==3) {
					uCard = "Three"+suit;
				}
				else if (j==4) {
					uCard = "Four"+suit;
				}
				else if (j==5) {
					uCard = "Five"+suit;
				}
				else if (j==6) {
					uCard = "Six"+suit;
				}
				else if (j==7) {
					uCard = "Seven"+suit;
				}
				else if (j==8) {
					uCard = "Eight"+suit;
				}
				else if (j==9) {
					uCard = "Nine"+suit;
				}
				else if (j==10) {
					uCard = "Ten"+suit;
				}
				else if (j==11) {
					uCard = "Jack"+suit;
				}
				else if (j==12) {
					uCard = "Queen"+suit;
				}
				else if (j==13) {
					uCard = "King"+suit;
				}
				else {
					uCard = "Ace"+suit;
				}
				cards.add(new Card(j, uCard));

			}
		}
	}
	
	/*
	 * The card list is shuffled/randomized
	 */
	public void shuffle(List<Card> cards) {
		Collections.shuffle(cards);
	    }
	
	/*
	 * A card is drawn from the player's deck
	 * calling the method
	 */
	public Card draw() {
		Card card = new Card();
		card = cards.get(0);
		cards.remove(0);
		return card;
	}
}
