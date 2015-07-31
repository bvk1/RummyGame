
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

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
        // random generation and populate cards

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

        int seqCanasta = getCanastaCount();
        System.out.println("canasta : " + seqCanasta);
        int seq = getSequenceCount(cards);
        System.out.println("seqDiamond : " + seq);
        for (Card c : cards) {
            System.out.println(c.getRankValue() + " " + c.getSuite() + " " + c.getRank());
        }
        System.out.println("Group count : " + getGroupCount(cards));
        for (Card c : cards) {
            System.out.println(c.getRankValue() + " " + c.getSuite() + " " + c.getRank());
        }
        return 0;

    }

    private void sortAndSeperateSuite(ArrayList<Card> cards) {

        Collections.sort(cards, new Card(0));
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
                if (card3.getRankValue() - card2.getRankValue() == 1
                        && card2.getRankValue() - card1.getRankValue() == 1) {
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

            if (card1.isIdentical(card2) && card1.isIdentical(card3)) {
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
        HashMap<Integer, ArrayList<Card>> hm = new HashMap<Integer, ArrayList<Card>>();

        for (Card c : set) {
            int mod = c.getRankValue() % 13;
            if (hm.containsKey(mod)) {
                hm.get(mod).add(c);
            } else {

                ArrayList<Card> sameGroup = new ArrayList<Card>();
                sameGroup.add(c);

                hm.put(mod, sameGroup);

            }
        }
        for (HashMap.Entry<Integer, ArrayList<Card>> entry : hm.entrySet()) {
            if (entry.getValue().size() >= 3) {

                groupCounter += getNumberOfPossibleGroups(entry.getValue());

            }
        }
        return groupCounter;
    }

    private int getNumberOfPossibleGroups(ArrayList<Card> possibleGroups) {
        return 0;
    }
    
    private int processRemainingCards(){
        
        if (areAllCardsLoose()){
            return cards.size() - 1;
        }
        else{
            findPartialSequencePairs();
        }
        return 0;
    }
    
     private boolean areAllCardsLoose(ArrayList<Card> set){
    	
    	Card currentCard;
    	Card nextCard;
    	for(int i = 0; i < set.size() - 1; i++){
    		currentCard = set.get(i);
    		nextCard = set.get(i+1);
    		if(currentCard.getDifferenceInRanks(nextCard) == 1 || currentCard.getDifferenceInRanks(nextCard) == 2)
    			return false;
    	}
        return true;
    }
    
        
    private int findPartialCanasta(ArrayList<Card> set){
    	Card currentCard;
    	Card nextCard;
    	int count = 0;
    	for(int i = 0; i < set.size() - 1; i++){
    		currentCard = set.get(i);
    		nextCard = set.get(i+1);
    		if(currentCard.isIdentical(nextCard)) count++; 
    	}
    	return count;
    }
   
    
    private int findPartialSequencePairs(){
        
        return 1;
    }

}
