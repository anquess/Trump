package anquess.noTrump;

/**
 * ノルマと切り札を保存するためのオブジェクト
 * ノルマを決めるときの情報としても、使用する。
 * @author anquess
 *
 */
public class Bid implements Comparable<Bid>{

	private Suit Suit_;
	private int norma_;

	public Bid(){
	}
	public Bid(Suit Suit,int norma){
		Suit_ = Suit;
		norma_ = norma;
	}
	/**
	 * 切り札を設定する
	 * @param suit
	 */
	public void setSuit(Suit suit) {
		Suit_ = suit;
	}
	/**
	 * 切り札を取得する
	 * @return
	 */
	public Suit getSuit() {
		return Suit_;
	}
	/**
	 * ノルマを取得する
	 * @param norma
	 */
	public void setNorma(int norma) {
		norma_ = norma;
	}
	/**
	 * ノルマを取得する
	 * @return
	 */
	public int getNorma() {
		return norma_;
	}
	@Override
	public int compareTo(Bid o) {
		if(this.norma_ == o.norma_){
			return Suit_.compareTo(o.Suit_);
		}
		return norma_ - o.norma_;
	}
}
