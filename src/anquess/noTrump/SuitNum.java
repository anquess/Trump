package anquess.noTrump;

public enum SuitNum {
	JOKER{
		@Override public String toString(){
			return "JK";
		}
		@Override public int getSuit(){
			return 0;
		}
	},
	SPADE{
		@Override public String toString(){
			return "S";
		}
		@Override public int getSuit(){
			return 1;
		}
	},
	HEART{
		@Override public String toString(){
			return "H";
		}
		@Override public int getSuit(){
			return 2;
		}
	},
	DIA{
		@Override public String toString(){
			return "D";
		}
		@Override public int getSuit(){
			return 3;
		}
	},
	CLUB{
		@Override public String toString(){
			return "C";
		}
		@Override public int getSuit(){
			return 4;
		}
	};
	public abstract int getSuit();
}