package anquess.noTrump;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

	private List<Card> cards_;

	public Hand(){
		cards_ = new ArrayList<Card>();
	}
	public void add(Card card) {
		cards_.add(card);
	}
	public void add(Card[] cards){
		for(Card card:cards){
			cards_.add(card);
		}
	}
	public void add(List<Card> cards){
		cards_.addAll(cards);
	}
	public Card view(int i) {
		return cards_.get(i);
	}

	public Card pickUp(int i) {
		return cards_.remove(i);
	}
	public int size() {
		return cards_.size();
	}

	public static Hand createTrump(){
		Hand trump = new Hand();

		for(Suit suit:Suit.values()){
			trump.add(suit.creatCards());
		}
		return trump;
	}

	public void shuffle(){
		Collections.shuffle(cards_);
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Card card:cards_){
			sb.append(card.toString());
			sb.append(" ");
		}
		return sb.toString();
	}
}
