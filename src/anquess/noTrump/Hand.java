package anquess.noTrump;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 手札のクラス
 * @author anquess
 *
 */
public class Hand {

	private List<Card> cards_;

	/**
	 * コンストラクタ
	 */
	public Hand(){
		cards_ = new ArrayList<Card>();
	}
	/**
	 * 手札の最後にカードを加える
	 * @param card
	 */
	public void add(Card card) {
		cards_.add(card);
	}
	/**
	 * 手札の最後にカードの配列で加える
	 * @param card
	 */
	public void add(Card[] cards){
		for(Card card:cards){
			cards_.add(card);
		}
	}
	/**
	 * 手札の最後にカードのリストで加える
	 * @param cards
	 */
	public void add(List<Card> cards){
		cards_.addAll(cards);
	}
	/**
	 * indexで指定した番目のカードを見る(0スタート)
	 * @param index
	 * @return カード
	 */
	public Card view(int index) {
		return cards_.get(index);
	}
	/**
	 * indexで指定した番目のカードを取り出す。取り出したカードは手札からなくなる(0スタート)
	 * @param index
	 * @return カード
	 */
	public Card pickUp(int index) {
		return cards_.remove(index);
	}
	/**
	 * 手札の数を調べる
	 * @return 手札の数
	 */
	public int size() {
		return cards_.size();
	}
	/**
	 * ノートランプの前手札を作るファクトリーメソッド
	 * @return
	 */
	public static Hand createTrump(){
		Hand trump = new Hand();

		for(Suit suit:Suit.values()){
			trump.add(suit.creatCards());
		}
		return trump;
	}
	/**
	 * 手札を混ぜる
	 */
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
