package anquess.noTrump;

import java.util.ArrayList;
import java.util.List;

public enum Suit {
	JOKER(){
		@Override
		public String toString(){
			return "JK";
		}
		@Override
		public List<Card> creatCards(){
			List<Card> cards = new ArrayList<Card>();
			cards.add(new Card(JOKER,0));
			return cards;
		}
	},
	SPADE{
		@Override
		public String toString(){
			return "S";
		}
		@Override
		public List<Card> creatCards(){
			List<Card> cards = super.creatCards();
			cards.add(new Card(SPADE,3));
			return cards;
		}
	},
	HEART,DIA,CLUB;
	public List<Card> creatCards(){
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(this,1));
		for(int i = 5; i <= 13; i++)		cards.add(new Card(this,i));
		return cards;
	};
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString().charAt(0));
		return sb.toString();
	}
}