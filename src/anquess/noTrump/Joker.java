package anquess.noTrump;

public class Joker extends Card {

	public Joker() {
		super(Suit.JOKER, 0);
	}

	@Override
	public String toString(){
		return "JK";
	}

}
