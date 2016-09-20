package trump;

/**
 * トランプのカードを表すクラス。
 */
public class Card
{
	/** スペードを表す定数 */
	public static final int SUIT_SPADE 		= 1;

	/** ハートを表す定数 */
	public static final int SUIT_HEART 		= 2;

	/** ダイヤを表す定数 */
	public static final int SUIT_DIAMOND	= 3;

	/** クラブを表す定数 */
	public static final int SUIT_CLUB		= 4;

	/** スートの数 */
	public static final int SUIT_NUM 		= 4;

	/** 値の数 */
	public static final int CARD_NUM 		= 13;

	/** カードの示すスート */
	protected int suit_;

	/** カードの示す数 */
	protected int number_;

	/**
	 * コンストラクタ。
	 * スートと数を指定して新しいカードのインスタンスを生成する。<br>
	 * スートはSUIT_SPADE、SUIT_DIAMOND、SUIT_CLUB、SUIT_HEARTの
	 * いずれかを指定する。
	 *
	 * @param suit スート
	 * @param number 数
	 */
	public Card(int suit, int number)
	{
		if((suit < 0)||(suit > 4)||(number < 0)||(number > 13))
				throw new IllegalArgumentException("suitは0~4でnumberは0~13。suit:" + suit + "number:" + number);
		this.suit_ = suit;
		this.number_ = number;
	}

	/**
	 * 数を見る。
	 *
	 * @return 数
	 */
	public int getNumber()
	{
		return number_;
	}

	/**
	 * スートを見る。
	 *
	 * @return スート
	 */
	public int getSuit()
	{
		return suit_;
	}

	@Override
	/**
	 * カードを文字列で表現する。<br>
	 * ObjectクラスのtoStringメソッドをオーバーライドしたメソッド。
	 *
	 * @return カードの文字表現
	 */
	public String toString()
	{
		StringBuffer string = new StringBuffer();

		// スートの表示
		switch (suit_)
		{
			case SUIT_SPADE :
				string.append("S");
				break;

			case SUIT_DIAMOND :
				string.append("D");
				break;

			case SUIT_CLUB :
				string.append("C");
				break;

			case SUIT_HEART :
				string.append("H");
				break;

			default :
				break;
		}

		// 数の表示
		switch (number_)
		{
			case 1 :
				string.append("A");
				break;

			case 10 :
				string.append("T");
				break;

			case 11 :
				string.append("J");
				break;

			case 12 :
				string.append("Q");
				break;

			case 13 :
				string.append("K");
				break;

			default :
				string.append(number_);
				break;
		}

		return string.toString();
	}

	@Override
	/**
	 * 同じカードかを調べる
	 * @return 同じかどうか
	 * @param o 比較対象のクラス
	 */
	public boolean equals(Object o){
		if((((Card)o).suit_ == this.suit_)
				&&(((Card)o).number_ == this.number_))	return true;
		return false;
	}
}
