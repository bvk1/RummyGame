
public class Card{
	
private enum Symbol {
		SPADE, HEART, CLUB, DIAMOND;
	}
	
	private Symbol suit;
	private String rank;
	
	Card(Symbol suit, String value){
		this.suit = suit;
		this.rank = value;
				
	}
	
	public Symbol getSuitType(){
		return this.suit;
	}
	
	public String getRank(){
		return this.rank;
	}
}
