package anquess.noTrump;

import static anquess.noTrump.Suit.*;

/**
 * トランプのカード
 * @author anquess
 *
 */
public class Card implements Comparable<Card>{
	private Suit suit_;
	private int num_;
	/**
	 * コンストラクタ
	 * @param suit
	 * @param num
	 */
	public Card(Suit suit,int num){
		this.suit_	= suit;
		this.num_	= num;
	}
	/**
	 * カードに書かれた数を取得
	 * @return
	 */
	public int getNum() {
		return num_;
	}
	/**
	 * カードに書かれたスーツを取得
	 * @return
	 */
	public Suit getSuit() {
		return suit_;
	}
	/**
	 * 文字表現
	 * オーバーライド
	 */
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		// suit
		sb.append(suit_.toString());
		numToString(sb);
		return sb.toString();
	}

	private void numToString(StringBuilder sb) {
		switch(num_){
		case 0:
			break;
		case 1:
			sb.append("A");
			break;
		case 10:
			sb.append("T");
			break;
		case 11:
			sb.append("J");
			break;
		case 12:
			sb.append("Q");
			break;
		case 13:
			sb.append("K");
			break;
		default:
			sb.append(num_);
		}
	}
	/**
	 * カードのスーツと数字が同じなら同じとする
	 * オーバーライド
	 */
	@Override
	public boolean equals(Object o){
		if(o == this) return true;
		if(o == null) return false;
		if(!(o instanceof Card)) return false;
		Card card = (Card)o;
		if((card.num_ == num_)&&(card.suit_ == suit_)) return true;
		return false;
	}
	@Override
	public int compareTo(Card o) {
		if(o.equals(new Card(SPADE,1)))return -1;
		if(this.equals(new Card(SPADE,1)))return 1;
		if(o.equals(new Card(JOKER,0)))return -1;
		if(suit_ == o.suit_){
			if(num_ == 1){
				return 1;
			}else if(o.num_ == 1){
				return -1;
			}
				return num_ -o.num_;
		}
		return 1;
	}
}
