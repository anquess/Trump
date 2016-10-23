package anquess.noTrump;

import static anquess.noTrump.Number.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class NumberTest {

	@DataPoints
	public static Param[] PARAMs = {
			new Param(N3,"3"),
			new Param(N5,"5"),
			new Param(N6,"6"),
			new Param(N7,"7"),
			new Param(N8,"8"),
			new Param(N9,"9"),
			new Param(NT,"T"),
			new Param(NJ,"J"),
			new Param(NQ,"Q"),
			new Param(NK,"K"),
			new Param(NA,"A"),
			new Param(T3,"3"),
			new Param(T5,"5"),
			new Param(T6,"6"),
			new Param(T7,"7"),
			new Param(T8,"8"),
			new Param(T9,"9"),
			new Param(TT,"T"),
			new Param(TQ,"Q"),
			new Param(TK,"K"),
			new Param(TA,"A"),
			new Param(TPJ,"PJ"),
			new Param(TSJ,"SJ"),
			new Param(SJK,"JK"),
			new Param(SAM,"AM"),
	};

	static class Param{
		Number sut_;
		String num_;

		Param(Number sut, String num){
			sut_ = sut;
			num_ = num;
		}
	}

	@Theory
	public void 文字化テスト(Param p) {
		Number sut = p.sut_;
		String actual = sut.toString();
		String expected = p.num_;
		assertThat(actual,is(expected));
	}

}
