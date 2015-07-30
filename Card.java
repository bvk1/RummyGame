public class Card {
	private int cardRankValue;

	private enum Symbol {
		DIAMOND, HEART, SPADE, CLUB;
	}

	public Card(int number) {
		cardRankValue = number % 53;
	}

	public Symbol getSuite() {
		if (cardRankValue > 0 && cardRankValue < 14)
			return Symbol.DIAMOND;
		else if (cardRankValue > 13 && cardRankValue < 27)
			return Symbol.HEART;
		else if (cardRankValue > 26 && cardRankValue < 40)
			return Symbol.SPADE;
		else
			return Symbol.CLUB;
	}
	
	public boolean isSameRank(Card newCard){
		return Math.abs(cardRankValue - newCard.cardRankValue) == 13 ; 
	}
	
	public boolean isIdentical(Card newCard){
			return cardRankValue == newCard.cardRankValue; 
			
}
	public boolean isConsecutive(Card newCard){
		return (Math.abs(cardRankValue - newCard.cardRankValue) == 1) && (newCard.getSuite() == this.getSuite()); 
		
}
}
