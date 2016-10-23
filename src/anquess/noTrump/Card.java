package anquess.noTrump;

import static anquess.noTrump.Number.*;


/**
 * トランプのカード
 * @author anquess
 *
 */
public class Card implements Comparable<Card>{
	private Suit suit_;
	private Number num_;

	/**
	 * コンストラクタ
	 * @param suit
	 * @param num
	 */
	public Card(Suit suit,Number num){
		suit_	= suit;
		num_	= num;
	}
	/**
	 * カードに書かれた数を取得
	 * @return
	 */
	public Number getNum() {
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
		sb.append(num_.toString());
		return sb.toString();
	}
	/**
	 * 引数のスートと同じなら切り札に設定する
	 * @param suit 切り札のスート
	 */
	public void changeSpTrump(Suit suit){
		if(this.suit_ == suit){
			this.num_ = updateNumber(this.num_);
		}
		changedPatnerJack(suit);
	}

	private void changedPatnerJack(Suit suit){
		if(this.suit_.pareSuit() == suit){
			num_ = TPJ;
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
		if((this.suit_ == o.suit_)||(isItTrumpCard(this))||isItTrumpCard(o)){
			return this.num_.compareTo(o.num_);
		}
		return 1;
	}
	private boolean isItTrumpCard(Card o) {
		return o.getNum().getLevel() > TRUMP_NUM;
	}
}
