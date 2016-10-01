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
		@RunWith(Theories.class)
		public static class カードの比較{

		@DataPoints
		public static Fixture PARAMs[] = {
				new Fixture("H5<H7",new Card(HEART,5),new Card(HEART,7),new Card(HEART,7)),
				new Fixture("H7>H5",new Card(HEART,7),new Card(HEART,5),new Card(HEART,7)),
				new Fixture("H5>S7",new Card(HEART,5),new Card(SPADE,7),new Card(HEART,5)),
				new Fixture("S5>H7",new Card(SPADE,5),new Card(HEART,7),new Card(SPADE,5)),
				new Fixture("H5<HA",new Card(HEART,5),new Card(HEART,1),new Card(HEART,1)),
				new Fixture("HA>H5",new Card(HEART,1),new Card(HEART,5),new Card(HEART,1)),
				new Fixture("HA<SA",new Card(HEART,1),new Card(SPADE,1),new Card(SPADE,1)),
				new Fixture("SA>HA",new Card(SPADE,1),new Card(HEART,1),new Card(SPADE,1)),
				new Fixture("HA<JK",new Card(HEART,1),new Card(JOKER,0),new Card(JOKER,0)),
				new Fixture("JK>HA",new Card(JOKER,0),new Card(HEART,1),new Card(JOKER,0)),
				new Fixture("SA>JK",new Card(SPADE,1),new Card(JOKER,0),new Card(SPADE,1)),
				new Fixture("JK<SA",new Card(JOKER,0),new Card(SPADE,1),new Card(SPADE,1)),
		};

		@Theory
		public void パラメータによる比較(Fixture p){
			Card actual = p.card1_;
			Card expected = p.expected_;
			if(p.card1_.compareTo(p.card2_) > 0) actual = p.card1_;
			if(p.card1_.compareTo(p.card2_) < 0) actual = p.card2_;
			assertThat(p.msg_,actual,is(expected));
		}
		public static class Fixture{
			String msg_;
			Card card1_;
			Card card2_;
			Card expected_;
			Fixture(String msg,Card card1,Card card2,Card expected){
				msg_		= msg;
				card1_		= card1;
				card2_		= card2;
				expected_	= expected;
			}
		}
	}

}
