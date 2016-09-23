package anquess.noTrump;

public enum Suit {
	JOKER{
		@Override
		public String toString(){
			return "JK";
		}
		@Override
		public int getSuit(){
			return 0;
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
		public int getSuit(){
			return 1;
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
					new Card(SPADE,8),
					new Card(SPADE,10),
					new Card(SPADE,11),
					new Card(SPADE,12),
					new Card(SPADE,13),};
			return card;
		}
	},
	HEART{
		@Override
		public String toString(){
			return "H";
		}
		@Override
		public int getSuit(){
			return 2;
		}
		@Override
		public Card[] creatCard() {
			Card[] card = {
					new Card(HEART,1),
					new Card(HEART,5),
					new Card(HEART,6),
					new Card(HEART,7),
					new Card(HEART,8),
					new Card(HEART,8),
					new Card(HEART,10),
					new Card(HEART,11),
					new Card(HEART,12),
					new Card(HEART,13),};
			return card;
		}
	},
	DIA{
		@Override public String toString(){
			return "D";
		}
		@Override public int getSuit(){
			return 3;
		}
		@Override
		public Card[] creatCard() {
			Card[] card = {
					new Card(DIA,1),
					new Card(DIA,5),
					new Card(DIA,6),
					new Card(DIA,7),
					new Card(DIA,8),
					new Card(DIA,8),
					new Card(DIA,10),
					new Card(DIA,11),
					new Card(DIA,12),
					new Card(DIA,13),};
			return card;
		};

	},
	CLUB{
		@Override public String toString(){
			return "C";
		}
		@Override public int getSuit(){
			return 4;
		}
		@Override
		public Card[] creatCard() {
			Card[] card = {
					new Card(CLUB,1),
					new Card(CLUB,5),
					new Card(CLUB,6),
					new Card(CLUB,7),
					new Card(CLUB,8),
					new Card(CLUB,8),
					new Card(CLUB,10),
					new Card(CLUB,11),
					new Card(CLUB,12),
					new Card(CLUB,13),};
			return card;
		};

	};
	public abstract int getSuit();
	public Card[] createCard() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public abstract Card[] creatCard();
}