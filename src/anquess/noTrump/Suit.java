package anquess.noTrump;

public enum Suit {
	JOKER(){
		@Override
		public String toString(){
			return "JK";
		}
		@Override
		public Card[] creatCard() {
			Card[] card = { new Card(JOKER,0)};
			return card;
		}
	},
	SPADE{
		@Override
		public String toString(){
			return "S";
		}
		@Override
		public Card[] creatCard() {
			Card[] card = {
					new Card(SPADE,1),
					new Card(SPADE,3),
					new Card(SPADE,5),
					new Card(SPADE,6),
					new Card(SPADE,7),
					new Card(SPADE,8),
					new Card(SPADE,9),
					new Card(SPADE,10),
					new Card(SPADE,11),
					new Card(SPADE,12),
					new Card(SPADE,13),};
			return card;
		}
	},
	HEART,DIA,CLUB;
	public Card[] creatCard(){
		Card[] card = {
				new Card(this,1),
				new Card(this,5),
				new Card(this,6),
				new Card(this,7),
				new Card(this,8),
				new Card(this,9),
				new Card(this,10),
				new Card(this,11),
				new Card(this,12),
				new Card(this,13),};
		return card;
	};
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString().charAt(0));
		return sb.toString();
	}
}