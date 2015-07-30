import java.util.ArrayList;
public class Hand {
    
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
    
    private boolean isSequence(ArrayList<Card> set){
        return false;
        
    }
    
    private boolean isGroup(ArrayList<Card> set) {
        return false;
    }
    private boolean isCanasta(ArrayList<Card> set) {
        return false;
    }
    
    
}
