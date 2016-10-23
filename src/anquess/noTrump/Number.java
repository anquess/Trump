package anquess.noTrump;

public enum Number {N3,N5,N6,N7,N8,N9,NT,NJ,NQ,NK,NA,NSJ,NPJ,NJK,NAM;
	@Override
	public String toString(){
		return super.toString().substring(1);
	}
}
