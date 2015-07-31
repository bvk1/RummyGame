import java.util.Comparator;
public class Card implements Comparator<Card> {
	private int cardRankValue;

	private enum Symbol {
		DIAMOND, HEART, CLUB, SPADE;
	}

	public Card(int number) {
		cardRankValue = number % 53;
	}
	@Override
	public int compare(Card card1, Card card2) {

	Integer i1 =  card1.cardRankValue; 
	Integer i2 =  card2.cardRankValue; 
	if(i1 > i2 ){
	    return 1;
	}else if(i1< i2){
	    return -1;
	}else {
	    return 0;
	}
	}

	public Symbol getSuite() {
		if (cardRankValue > 0 && cardRankValue < 14)
			return Symbol.DIAMOND;
		else if (cardRankValue > 13 && cardRankValue < 27)
			return Symbol.HEART;
		else if (cardRankValue > 26 && cardRankValue < 40)
			return Symbol.CLUB;
		else
			return Symbol.SPADE;
	}
	
	public boolean isSameRank(Card newCard){
		return Math.abs(cardRankValue - newCard.cardRankValue) == 13 ; 
	}
	
	public int getRank(){
		int rank = cardRankValue % 13 ;
		return (rank == 0) ? 13 : rank ; 
	}
	
	public int getRankValue(){
		
		return cardRankValue ; 
	}
	
	public boolean isIdentical(Card newCard){
			return cardRankValue == newCard.cardRankValue; 
			
}
	public boolean isConsecutive(Card newCard){
		return (Math.abs(cardRankValue - newCard.cardRankValue) == 1) && (newCard.getSuite() == this.getSuite()); 
		
}
}
