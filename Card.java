
public class Card {
	private int cardRankValue;

	private enum Symbol {
		SPADE, HEART, CLUB, DIAMOND;
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
    
}

