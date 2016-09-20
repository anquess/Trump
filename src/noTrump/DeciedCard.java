package noTrump;

import trump.Player;

public class DeciedCard {
	Player player;
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	public int getGoalWinCount() {
		return goalWinCount;
	}
	public void setGoalWinCount(int goalWinCount) {
		this.goalWinCount = goalWinCount;
	}
	int suit;
	int goalWinCount;
	public DeciedCard declare(DeciedCard declrareCard){
		return null;
	}
}
