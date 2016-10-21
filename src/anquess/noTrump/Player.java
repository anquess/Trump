package anquess.noTrump;

import java.util.List;
/**
 * プレイヤークラス
 * @author anquess
 *
 */
public class Player {
	private Hand	myHand_;
	private String	name_;
	/**
	 * コンストラクタ
	 */
	public Player(){
		myHand_ = new Hand();
	}
	/**
	 * コンストラクタ
	 * @param name
	 */
	public Player(String name){
		this();
		name_ = name;
	}
	/**
	 * カードを受け取り、自分の手札の最後に加える
	 * @param card 受け取るカード
	 */
	public void recieve(Card card) {
		myHand_.add(card);
	}
	/**
	 * カードを受け取り、自分の手札の最後に加える
	 * @param cards 受け取るカード
	 */
	public void recieve(Card[] cards) {
		myHand_.add(cards);
	}
	/**
	 * カードを受け取り、自分の手札の最後に加える
	 * @param cards 受け取るカード
	 */
	public void recieve(List<Card> cards) {
		myHand_.add(cards);
	}
	/**
	 * 指定したカードを1枚抜く
	 * @param index 抜く手札の中での位置(0からスタート)
	 * @return 抜いたカード
	 */
	public Card put(int index) {
		return myHand_.pickUp(index);
	}
	/**
	 * 手札の数を調べる
	 * @return 手札の数
	 */
	public int getHandSize() {
		return myHand_.size();
	}

	/**
	 * 名前を返す
	 * @return
	 */
	@Override
	public String toString() {
		return name_;
	}
	/**
	 * 名前を設定する
	 * @param name
	 */
	public void setName(String name) {
		name_ = name;
	}
}
