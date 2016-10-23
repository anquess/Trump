package anquess.noTrump;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

	private List<Player> players_;
	private Hand trump_;
	/**
	 * コンストラクタ
	 */
	public Dealer(){
		players_ = new ArrayList<Player>(4);
		trump_ = Hand.createTrump();
		trump_.shuffle();
	}
	/**
	 * ゲーム開始
	 */
	public void prepareGame() {
	}

	/**
	 * プレイヤーのゲッター
	 * @param i 何番目(0~3)
	 * @return 番号に該当するプレイヤー
	 */
	public Player getPlayer(int i) {
		return players_.get(i);
	}
	/**
	 * プレイヤーを登録
	 * @param player
	 */
	public void registerPlayer(Player player){
		if(players_.size() == 4) throw new IllegalArgumentException("プレイヤーは4人まで");
		players_.add(player);
	}
	/**
	 * プレイヤーにトランプを配る(親用に2枚残す)
	 */
	public void distributeTrump() {
		int i = 0;
		for(;trump_.size() != 2;){
			getPlayer(i%4).recieve(trump_.pickUp(0));
			i++;
		}
	}
	/**
	 * トランプの枚数
	 * @return トランプの数
	 */
	int trumpSize(){
		return trump_.size();
	}

}
