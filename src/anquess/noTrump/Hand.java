package anquess.noTrump;

import static anquess.noTrump.Card.*;

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

		int suit = 0;
		for(suit = SPADE;suit <= CLUB;suit++){
			Card card = new Card(suit,1);
			trump.add(card);
		}
		trump.add(new Card(SPADE,3));
		for(suit = SPADE;suit <= CLUB;suit++){
			for(int num = 5;num <= 13;num++){
				Card card = new Card(suit,num);
				trump.add(card);
			}
		}
		trump.add(new Joker());

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
