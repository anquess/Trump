package noTrump;

import trump.Master;
import trump.Player;
import trump.Rule;
import trump.Table;

/**
 * ノートラのプレイヤー
 * @author anquess
 *
 */
public class NoTrumpPlayer extends Player {

	/**
	 * プレイヤーの勝ち数(勝負の勝ち数は、プレイヤーと相棒の合計)
	 */
	int winCount_;
	/**
	 * 相棒(向かい合わせのプレイヤーが相棒となる)
	 */
	Player partner_;
	public void setPaetner(Player patner){
		this.partner_=patner;
	}


	NoTrumpTactics tactics_;


	public NoTrumpPlayer(String name, Master master, Table table, Rule rule,
			Player patner,NoTrumpTactics tactics) {
		super(name, master, table, rule);
		this.partner_ = patner;
		this.tactics_ = tactics;
	}

	/**
	 * 競り札を宣言する
	 * @param suit		競り中における暫定の切り札
	 * @param winCount	競り中における暫定のノルマの勝ち数(10以下)
	 * @Player player	現在の落札者
	 */
	public DeciedCard bid(DeciedCard currentCard){
		if ((currentCard.getSuit() < 1)||(currentCard.getSuit() > 4))
			throw new IllegalArgumentException("suitは1~4；" + currentCard.getSuit());
		if ((currentCard.getGoalWinCount() < 6)||(currentCard.getGoalWinCount() > 10))
			throw new IllegalArgumentException("winCountは6~10；" + currentCard.getGoalWinCount());
		return tactics_.readBid(currentCard, myHand_);
	}

	@Override
	public void play(Player nextPlayer) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
