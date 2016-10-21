package anquess.noTrump;

import java.util.ArrayList;
import java.util.List;

/**
 * スートの列挙型(SPADE、HEART、DIA、CLUB、JOKER)
 * @author anquess
 */
public enum Suit{
	CLUB,DIA,HEART,
	SPADE{
		@Override
		public List<Card> creatCards(){
			List<Card> cards = super.creatCards();
			cards.add(new Card(SPADE,3));
			return cards;
		}
	},
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
	};
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