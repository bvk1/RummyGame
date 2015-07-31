
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Hand {

    private ArrayList<Card> diamondCards = new ArrayList<Card>();
    private ArrayList<Card> heartCards = new ArrayList<Card>();
    private ArrayList<Card> clubCards = new ArrayList<Card>();
    private ArrayList<Card> spadeCards = new ArrayList<Card>();
    ArrayList<Card> cards = new ArrayList<Card>();

    public static void main(String[] args) {

        Hand h = new Hand();
        h.deal();
        h.sortAndSeperateSuite(h.cards);
        int requiredNumberOfCards = h.getNumberOfCardsRequired();
    }

    private void deal() {
        //random generation and populate cards

        cards.add(new Card(52));
        cards.add(new Card(2));
        cards.add(new Card(11));
        cards.add(new Card(47));
        cards.add(new Card(13));
        cards.add(new Card(2));
        cards.add(new Card(47));
        cards.add(new Card(36));
        cards.add(new Card(2));
        cards.add(new Card(12));
        cards.add(new Card(23));
        cards.add(new Card(49));
        cards.add(new Card(47));

    }

    private int getNumberOfCardsRequired() {

        int seq = getSequenceCount(cards);
        System.out.println("seqDiamond : " + seq);
        int seqCanasta = getCanastaCount();
        System.out.println("canasta : " + seqCanasta);
        
        for(Card c :  cards){
            System.out.println(c.getRankValue() + " "+ c.getSuite() +" "+c.getRank());
        }
        System.out.println("Group count : "+ getGroupCount(cards));
        for(Card c :  cards){
            System.out.println(c.getRankValue() + " "+ c.getSuite() +" "+c.getRank());
        }
        return 0;
        
        
    }

    private void sortAndSeperateSuite(ArrayList<Card> cards) {

        Collections.sort(cards, new Card(0));
        for (Card card : cards) {
            switch (card.getSuite()) {
                case DIAMOND:
                    diamondCards.add(card);
                    break;
                case HEART:
                    heartCards.add(card);
                    break;
                case CLUB:
                    clubCards.add(card);
                    break;
                case SPADE:
                    spadeCards.add(card);
                    break;

            }

        }
        for (Card c : diamondCards) {
            System.out.println(c.getRankValue() + "dia");
        }
        for (Card c : heartCards) {
            System.out.println(c.getRankValue() + "heart");
        }
        for (Card c : clubCards) {
            System.out.println(c.getRankValue() + "club");
        }
        for (Card c : spadeCards) {
            System.out.println(c.getRankValue() + "spade");
        }
    }

    private int getSequenceCount(ArrayList<Card> set) {
        int sequenceCounter = 0;
        Card card1;
        Card card2;
        Card card3;

        for (int i = 0; i < set.size() - 2; i++) {
            card1 = set.get(i);
            card2 = set.get(i + 1);
            card3 = set.get(i + 2);
            if (card1.getSuite() == card2.getSuite() && card1.getSuite() == card3.getSuite()) {
                if (card3.getRankValue() - card2.getRankValue() == 1 && card2.getRankValue() - card1.getRankValue() == 1) {
                    set.remove(card3);
                    set.remove(card2);
                    set.remove(card1);
                    sequenceCounter += 1;
                }
            }
        }

        return sequenceCounter;
    }

    private int getCanastaCount() {
        int sequenceCount = 0;
        for (int i = 0; i < cards.size() - 2; i++) {
            Card card1 = cards.get(i);
            Card card2 = cards.get(i + 1);
            Card card3 = cards.get(i + 2);
            
            if (card1.isIdentical(card2) && card1.isIdentical(card3)){ 
                sequenceCount++;
                cards.remove(card1);
                cards.remove(card2);
                cards.remove(card3);
            }
        }
        return sequenceCount;
    }
    
    private int getGroupCount(ArrayList<Card> set) {
    	
        int groupCounter = 0;
       	int[] counter = new int[13];
        for(Card c : set){
            int mod = c.getRankValue() % 13;
            counter[mod]++;
            
        }
        for(int i : counter){
            if(i >= 3)
                groupCounter++;
        }
        
        
        
    	return groupCounter;
  }

}
