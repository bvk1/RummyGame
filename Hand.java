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
    
      private int getSequenceCount(ArrayList<Card> set){
       	int sequenceCounter = 0;
    	int len = set.size();
    	if(len > 2){
    		for (int i = 0; i < len; i++) {
    		    	  Card card1 = set.get(i);
    		    	  Card card2 = set.get(i+1);
    		    	  Card card3 = set.get(i+2);
    		    	  if(card3.getRankValue() - card2.getRankValue() == 1 && card2.getRankValue() - card1.getRankValue() == 1)
    		    	  {
    		    		  set.remove(card3);
    		    		  set.remove(card2);
    		    		  set.remove(card1);
    		    		  sequenceCounter += 1;
    		    	  }
    		 }
       }
		return sequenceCounter ;
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
