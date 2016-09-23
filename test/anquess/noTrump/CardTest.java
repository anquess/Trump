package anquess.noTrump;

import static anquess.noTrump.Suit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class CardTest {

	public static class 同じカード{
		@Test
		public void 複数のスペードの1を同じと検証(){
			Card actual = new Card(SPADE,1);
			Card expected = new Card(SPADE,1);
			assertThat(actual,is(expected));
		}
	}
	@RunWith(Theories.class)
	public static class ジョーカー以外を作るテスト{
		@DataPoints
		public static Param[] PARAMs = {
				new Param(SPADE,1,"SA"),
				new Param(HEART,3,"H3"),
				new Param(DIA,10,"DT"),
				new Param(CLUB,11,"CJ"),
				new Param(SPADE,12,"SQ"),
				new Param(HEART,13,"HK"),
		};

		static class Param{
			Suit suit_;
			int num_;
			String msg_;

			Param(Suit suit, int num,String msg){
				suit_	= suit;
				num_	= num;
				msg_	= msg;

			}
		}

		@Theory
		public void 指定されたカードの数字を返す(Param p) {
			int expected = p.num_;
			Card card = new Card(p.suit_,p.num_);
			int actual = card.getNum();
			assertThat(actual,is(expected));
		}

		@Theory
		public void 指定されたカードのスートを返す(Param p) {
			Suit expected = p.suit_;
			Card card = new Card(p.suit_,p.num_);
			Suit actual = card.getSuit();
			assertThat(actual,is(expected));
		}

		@Theory
		public void 指定されたカードをtoStringで返す(Param p) {
			String expected = p.msg_;
			Card card = new Card(p.suit_,p.num_);
			String actual = card.toString();
			assertThat(actual,is(expected));
		}
	}
}
