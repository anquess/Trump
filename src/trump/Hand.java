package trump;

import java.util.ArrayList;

/**
 * 手札を表すクラス。
 */
public class Hand
{
	/** 手札にあるカードを保持するためのリスト */
	private ArrayList<Card> hand_ = new ArrayList<Card>();

	/**
	 * カードを加える。<br>
	 *
	 * @param card 加えるカード
	 * @exception IllegarlArgumentException 手札に加えるカードと同じ場合
	 * @exception NullPointerException 手札に加えるカードがnull
	 */
	public void addCard(Card card)
	{
		// 追加するカードがnullか、確認する
		if(card == null) throw new NullPointerException("手札に加えるカードがnull");
		hand_.add(card);
	}

	/**
	 * カードを見る。
	 * positionは 0 から getNumberOfCards() の範囲で指定するすること。
	 *
	 * @param position カードの位置。
	 * @return position で指定された位置のカード。範囲外の場合はnullを返す。
	 * @exception illegalArgumentException 引数が手札の数と矛盾
	 */
	public Card lookCard(int position)
	{
		checkPosition(position);
		return (Card)hand_.get(position);
	}

	/**
	 * カードを引く。
	 * 引いたカードは手札から削除される。
	 *
	 * @param position カードの位置。
	 * @return position で指定された位置のカード。範囲外の場合はnullを返す。
	 */
	public Card pickCard(int position)
	{
		checkPosition(position);

		return (Card)hand_.remove(position);
	}

	/**
	 * シャッフルする。
	 */
	public void shuffle()
	{
		// 手札の枚数を取得
		int number = hand_.size();

		// カードを抜き出す位置
		int pos;

		// カードをランダムに抜き取って最後に加える動作を繰り返す
		for (int count = 0; count < number * 2; count++)
		{
			// ランダムな位置からカードを一枚抜き取る
			pos = (int) (Math.random() * number);
			Card pickedCard = (Card)hand_.remove(pos);

			// 抜き取ったカードを最後に加える
			hand_.add(pickedCard);
		}
	}

	/**
	 * 枚数を数える。
	 *
	 * @return 手札にあるカードの枚数
	 */
	public int getNumberOfCards()
	{
		return hand_.size();
	}

	/**
	 * 手札にあるカードを文字列で表現する。
	 * ObjectクラスのtoStringメソッドをオーバーライドしたメソッド。
	 *
	 * @return 手札にあるカードの文字列表現
	 */
	public String toString()
	{
		StringBuffer string = new StringBuffer();

		int size = hand_.size();
		if (size > 0)
		{
			for (int index = 0; index < size; index++)
			{
				Card card = (Card)hand_.get(index);
				string.append(card);
				string.append(" ");
			}
		}

		return string.toString();
	}

	private void checkPosition(int position){
		// 引数で指定された位置が妥当でない場合、例外発生
		if((position < 0)||(position >= hand_.size()))
				throw new IllegalArgumentException();
	}
}
