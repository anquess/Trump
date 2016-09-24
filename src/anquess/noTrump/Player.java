package anquess.noTrump;

public class Player {
	Hand	myHand_;
	String	name_;

	public Player(){
		myHand_ = new Hand();
	}
	public Player(String name){
		this();
		name_ = name;
	}

	public void recieve(Card card) {
		myHand_.add(card);
	}

	public Card put(int i) {
		return myHand_.pickUp(i);
	}

	public int getHandNum() {
		return myHand_.size();
	}

	public String getName() {
		return name_;
	}

	public void setName(String name) {
		name_ = name;
	}
}
