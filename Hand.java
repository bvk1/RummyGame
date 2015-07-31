import java.util.ArrayList;
public class Hand {
    private ArrayList<Card> diamondCards = new ArrayList<Card>();
	private ArrayList<Card> heartCards = new ArrayList<Card>();
	private ArrayList<Card> clubCards = new ArrayList<Card>();
	private ArrayList<Card> spadeCards = new ArrayList<Card>();
    
    public static void main(String[] args){
        
        ArrayList<Card> cards = new ArrayList<Card>();
        Hand h = new Hand();
        
        h.deal(cards);
        int requiredNumberOfCards = h.getNumberOfCardsRequired();
    }
    
    private void deal(ArrayList<Card>  cards){
        //random generation and populate cards
    }
    
    private int getNumberOfCardsRequired(){
        return 0;
    }
    
    private void checkForSequences(){
        
        
    }
    
    private void checkForGroups() {
        
    }
    private int getCanastaCount() {
        int sequenceCount = 0;
        for (int i = 0; i < cards.size() - 2; i++) {
            if (cards.get(i).isIdentical(cards.get(i + 1)) && cards.get(i).isIdentical(cards.get(i + 1))) {
                sequenceCount++;
                cards.remove(i);
                cards.remove(i + 1);
                cards.remove(i + 2);
            }
        }
        return sequenceCount;
    }
    
    
}
