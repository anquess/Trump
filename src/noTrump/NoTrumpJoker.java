package noTrump;

public class NoTrumpJoker extends NoTrumpCard {
	/**
	 * コンストラクタ。
	 * デフォルトでは、ジョーカーは何の値・スートも表さない。
	 * getNumber()、getSuit()は0を返す。
	 */
	public NoTrumpJoker()
	{
		super(0, 0);
	}

}
