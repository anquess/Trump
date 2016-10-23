package anquess.noTrump;
/**
 * トリック(1回1回のゲーム)のクラス
 * 前プレイヤーが1枚ずつ出して勝敗を決める勝負の単位
 * @author anquess
 *
 */
public class Trick {
	private Hand gameCards_;
	private int cardsNum_;
	/**
	 * コンストラクタ
	 */
	public Trick(){
		gameCards_ = new Hand();
		cardsNum_ = 0;
	}
	/**
	 * トリックのカードのリセット
	 */
	public void reset(){
		cardsNum_ = 0;
		gameCards_ = new Hand();
	}
	/**
	 * 場にカード1枚置く
	 * @param card
	 */
	public void put(Card card) {
		if(cardsNum_ == 4) reset();
		gameCards_.add(card);
		cardsNum_++;
	}

	@Override
	public String toString(){
		return gameCards_.toString();
	}
}
