package anquess.noTrump;


import static anquess.noTrump.Number.*;
import static anquess.noTrump.Suit.*;
import static anquess.noTrump.SuitTest.Fixture.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class SuitTest {

	@Test
	public void toStringTest() {
		assertThat("JK",	JOKER.toString(),	is("JK"));
		assertThat("SPADE",	SPADE.toString(),	is("S"));
		assertThat("HEART",	HEART.toString(),	is("H"));
		assertThat("DIA",	DIA.toString(),		is("D"));
		assertThat("CLUB",	CLUB.toString(),	is("C"));
	}

	public static class Fixture{
		Suit suit_;
		int count_;
		Number num_[];

		static final Number[] JK_NUM		= {SJK};
		static final Number[] SP_NUM		= {N5,N6,N7,N8,N9,NT,NJ,NQ,NK,SAM,N3};
		static final Number[] OTHER_NUM	= {N5,N6,N7,N8,N9,NT,NJ,NQ,NK,NA};


		Fixture(Suit suit,int count,Number[] num){
			suit_	= suit;
			count_	= count;
			num_	= num;

		}
	}

	@DataPoints
	public static Fixture[] PRAMs = {
			new Fixture(JOKER,1,JK_NUM),
			new Fixture(SPADE,1,SP_NUM),
			new Fixture(HEART,1,OTHER_NUM),
			new Fixture(DIA,1,OTHER_NUM),
			new Fixture(CLUB,1,OTHER_NUM),

	};

	@Theory
	public void creatCardTest(Fixture p){
		List<Card> cards = p.suit_.creatCards();
		int i = 0;
		for(Number expected:p.num_){
			Number actual = cards.get(i).getNum();
			assertThat(p.suit_.toString(),actual,is(expected));
			i++;
		}
	}

}
