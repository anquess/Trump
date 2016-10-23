package anquess.noTrump;

public enum Number {
	N3(3),N5(5),N6(6),N7(7),N8(8),N9(9),NT(10),NJ(11),NQ(12),NK(13),NA(15),
	T3(23),T5(25),T6(26),T7(27),T8(28),T9(29),TT(30),TQ(32),TK(33),TA(35),TPJ(36),TSJ(37),
	SJK(40),SAM(41);
	private final int level_;
	private Number(final int level){
		level_ = level;
	}
	public int getLevel(){
		return level_;
	}
	public static Number updateNumber(final Number num){
		if(num == SAM) return SAM;
		if(num == NJ) return TSJ;
		for(Number number : Number.values()){
			if(number.getLevel() == updateNum(num)){
				return number;
			}
		}
		return num;
	}
	private static int updateNum(final Number num) {
		return num.getLevel() + TRUMP_NUM;
	}

	@Override
	public String toString(){
		return super.toString().substring(1);
	}
	public static final int TRUMP_NUM = 20;
}
