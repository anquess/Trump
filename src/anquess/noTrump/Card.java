package anquess.noTrump;

public class Card {
	private Suit suit_;
	private int num_;

	public Card(Suit suit,int num){
		this.suit_	= suit;
		this.num_	= num;
	}
	public int getNum() {
		return num_;
	}

	public Suit getSuit() {
		return suit_;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		// suit
		sb.append(suit_.toString());

		// num
		switch(num_){
		case 0:
			break;
		case 1:
			sb.append("A");
			break;
		case 10:
			sb.append("T");
			break;
		case 11:
			sb.append("J");
			break;
		case 12:
			sb.append("Q");
			break;
		case 13:
			sb.append("K");
			break;
		default:
			sb.append(num_);
		}

		return sb.toString();
	}

	@Override
	public boolean equals(Object o){
		if(o == this) return true;
		if(o == null) return false;
		if(!(o instanceof Card)) return false;
		Card card = (Card)o;

		if((card.num_ == num_)&&(card.suit_ == suit_)) return true;

		return false;
	}
}
