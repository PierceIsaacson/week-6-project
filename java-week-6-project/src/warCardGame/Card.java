package warCardGame;

public class Card {
	
	private String name;
	private int value;
	
	public Card() {
    }
	/*
	 * Constructor for generating cards when 
	 * prompting a 52 card deck
	 */
	public Card(int value, String name) {
		this.name=name;
		this.value=value;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	/*
	 * describes the cards attributes
	 */
	 public void describe() {
			System.out.println(name);	    
	 }
}