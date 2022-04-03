package warCardGame;

public class App {
	public static void main(String[] args) {

		/*
		 * the standard 52 deck and players
		 * are instantiated for play 
		 */
		Deck deck = new Deck();
		
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");

		deck.shuffle(deck.cards); //the deck is shuffled/randomized for play

		/*
		 * Using a boolean variable as a toggle indicator,
		 * the variable allows the players to alternate
		 * drawing cards for a proper hand
		 */
		boolean toggle = true;
		for (int i = 0; i < 52; i++) {
		    
			if (toggle == true) {
			player1.draw(deck);
		    } else {
			player2.draw(deck);
		    }
			toggle = !toggle;
		}

		/*
		 * 
		 */
		    for (int i=0; i<26 && (player1.hand.size()>0) && (player2.hand.size()>0); i++) {
		    	Card playerCard1 = player1.flip();
		    //playerCard1.describe(); //optional use for debug or battle observation 
		    	Card playerCard2 = player2.flip();
		    //playerCard2.describe(); //optional use for debug or battle observation

		    	if (playerCard1.getValue() > playerCard2.getValue()) {
		    	
		    	player1.hand.add(playerCard1);
				player1.hand.add(playerCard2);
		    	player1.incrementScore();
			//System.out.println("Player 1 wins this bout"); //declares the battle winner, debug use
		    
		    } else if (playerCard2.getValue() > playerCard1.getValue()) {
			
		    	player2.hand.add(playerCard1);
				player2.hand.add(playerCard2);
				player2.incrementScore();
			//System.out.println("Player 2 wins this bout"); //declares the battle winner, debug use

		    } else if (playerCard2.getValue() == playerCard1.getValue()){
		    	war(player1, player2, playerCard1, playerCard2);
		    }
		       
		}
		    winner(player1, player2);
		

	    }

	    /*
	     * The current flipped card is recessed and two more are drawn
	     * with the most recent flipped card being an indicator of 
	     * victory.
	     * 
	     * Logic looks for if each players hands still have cards, 
	     * if a player only has one card left that is used as their 
	     * dominant card for the war 
	     */
	    private static void war(Player player1, Player player2, Card playerCard1, Card playerCard2) {
		    for (int i = 0; i < 2 && player1.hand.size() != 0 && player2.hand.size() != 0; i++) {
			if (player1.hand.size() != 0) {
			    playerCard1 = player1.flip();
			}

			if (player2.hand.size() != 0) {
			    playerCard2 = player2.flip();
			}
		    }

		    if (playerCard1.getValue() > playerCard2.getValue()) {
			player1.hand.add(playerCard1);
			player1.hand.add(playerCard2);
			player1.incrementScore();
			
		    } else if (playerCard2.getValue() > playerCard1.getValue()) {
			player2.hand.add(playerCard1);
			player2.hand.add(playerCard2);
			player2.incrementScore();
			
			/*
			 * If a war is drawn, then it is reiterated
			 * if a hand runs out in war and loses, a winner
			 * is declared.
			 */
		    } else if(playerCard2.getValue() == playerCard1.getValue()){
		    	war(player1, player2, playerCard1, playerCard2);
			 }
		    else  {
			    winner(player1, player2);
			}
	    }
	    
	    /*
	     * Winner is declared after 26 iterations 
	     * or a player runs their hands out faster 
	     * as a result of war
	     */

	    private static void winner(Player player1, Player player2) {
		
			if (player1.hand.size() < player2.hand.size()) {
				
		    System.out.println(player1.getName() + " won " + player1.getScore() + " of "
			    + (player1.getScore() + player2.getScore()) + " iterations");
		    System.out.println(player2.getName() + " won " + player2.getScore());
		    System.out.println("The war goes to " + player2.getName());
		}	
			
			else if (player1.hand.size() > player2.hand.size()) {
				
		    System.out.println(player1.getName() + " won " + player1.getScore() + " of "
			    + (player1.getScore() + player2.getScore()) + " iterations");
		    System.out.println(player2.getName() + " won " + player2.getScore());
		    System.out.println("The war goes to " + player1.getName());
		} 
			else {
				
		    System.out.println("Both " + player1.getName() + " and " + player2.getName() + 
		    												" have equal amount of cards");
		    System.out.println("The game is a draw");
		}
	    }
	}
