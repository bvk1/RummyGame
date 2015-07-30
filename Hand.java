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
    private void checkForCanastas() {
        
    }
    
    
}
