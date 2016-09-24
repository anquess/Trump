package anquess.noTrump;

import java.util.ArrayList;
import java.util.List;

public class Master {

	private List<Player> players_;
	private Hand trump_;

	public Master(){
		players_ = new ArrayList<Player>(4);
		trump_ = Hand.createTrump();
		trump_.shuffle();
	}

	public void prepareGame() {
	}

	public Player getPlayer(int i) {
		return players_.get(i);
	}

	public void registerPlayer(Player player){
		if(players_.size() == 4) throw new IllegalArgumentException("プレイヤーは4人まで");
		players_.add(player);
	}

	public void distributeTrump() {
		int i = 0;
		for(;trump_.size() != 2;){
			getPlayer(i%4).recieve(trump_.pickUp(0));
			i++;
		}
	}

	public int trumpSize(){
		return trump_.size();
	}

}
