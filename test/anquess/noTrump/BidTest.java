package anquess.noTrump;

import static anquess.noTrump.Suit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BidTest {

	@RunWith(Theories.class)
	public static class suitとノルマのテスト{
		public Bid bid;

		@Before
		public void setUp(){
			bid = new Bid();
		}

		static class Fixture{
			Suit 	suit_;
			int		norma_;

			Fixture(Suit suit,int norma){
				suit_	= suit;
				norma_	= norma;
			}
		}

		@DataPoints
		public static Fixture[] PARAMs = {
				new Fixture(DIA,6),
				new Fixture(CLUB,7),
		};

		@Theory
		public void 切り札とノルマが正しいかを調べるtest(Fixture p) {
			bid.setSuit(p.suit_);
			bid.setNorma(p.norma_);
			Suit expectedSuit	= p.suit_;
			Suit actualSuit		= bid.getSuit();
			assertThat(p.suit_.toString(),actualSuit,is(expectedSuit));
			int expectedNorma	= p.norma_;
			int actualNorma		= bid.getNorma();
			assertThat("ノルマ;" + p.norma_,actualNorma,is(expectedNorma));
		}
	}
}
