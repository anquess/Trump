package anquess.noTrump;


import static anquess.noTrump.Suit.*;
import static anquess.noTrump.SuitTest.Fixture.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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
		int num_[];

		static final int[] JK_NUM		= {0};
		static final int[] SP_NUM		= {1,3,5,6,7,8,9,10,11,12,13};
		static final int[] OTHER_NUM	= {1,5,6,7,8,9,10,11,12,13};


		Fixture(Suit suit,int count,int[] num){
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
		Card[] cards = p.suit_.creatCard();
		int i = 0;
		for(int expected:p.num_){
			int actual = cards[i].getNum();
			assertThat(p.suit_.toString(),actual,is(expected));
			i++;
		}
	}

}
