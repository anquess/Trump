package anquess.noTrump;

public class Master {

	Player[] players;

	public Master(){
		players = new Player[4];
	}

	public void prepareGame() {
	}

	public Player getPlayer(int i) {
		return players[i];
	}
	


}
