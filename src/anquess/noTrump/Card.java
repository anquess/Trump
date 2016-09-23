package anquess.noTrump;

public class Card {

	private int suit_;
	private int num_;

	public Card(int suit, int num) {
		this.suit_	= suit;
		this.num_	= num;
	}
	public static final int SPADE	= 1;
	public static final int HEART	= 2;
	public static final int DIA		= 3;
	public static final int CLUB	= 4;

	public int getNum() {
		return num_;
	}

	public int getSuit() {
		return suit_;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		// suit
		switch(suit_){
		case SPADE:
			sb.append("S");
			break;
		case HEART:
			sb.append("H");
			break;
		case DIA:
			sb.append("D");
			break;
		default:
			sb.append("C");
		}

		// num
		switch(num_){
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