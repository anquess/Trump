package anquess.noTrump;

import static anquess.noTrump.Number.*;

import java.util.ArrayList;
import java.util.List;

/**
 * スートの列挙型(SPADE、HEART、DIA、CLUB、JOKER)
 * @author anquess
 */
public enum Suit{
	CLUB{
		@Override
		public Suit pareSuit() {
			return SPADE;
		}
	},
	DIA{
		@Override
		public Suit pareSuit() {
			return HEART;
		}
	},
	HEART {
		@Override
		public Suit pareSuit() {
			return DIA;
		}
	},
	SPADE{
		@Override
		public List<Card> creatCards(){
			List<Card> cards = super.creatCards();
			cards.remove(cards.size()-1);
			cards.add(new Card(this,SAM));
			cards.add(new Card(this,N3));
			return cards;
		}

		@Override
		public Suit pareSuit() {
			return CLUB;
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
			cards.add(new Card(JOKER,SJK));
			return cards;
		}
		@Override
		public Suit pareSuit() {
			return null;
		}
	};
	public abstract Suit pareSuit();
	public List<Card> creatCards(){
		List<Card> cards = new ArrayList<Card>();
		for(Number num:Number.values()){
			if((num != N3)&&(num .getLevel() < 20))cards.add(new Card(this,num));
		}
		return cards;
	};
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString().charAt(0));
		return sb.toString();
	}
}