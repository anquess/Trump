package anquess.noTrump;

import static anquess.noTrump.Number.*;
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
			Card actual = new Card(SPADE,SAM);
			Card expected = new Card(SPADE,SAM);
			assertThat(actual,is(expected));
		}
	}

	public static class 切り札に変更{
		@Test
		public void 切り札スペードでスペード3で検証(){
			Card sut = new Card(SPADE,N3);
			sut.changeSpTrump(SPADE);
			Card expected = new Card(SPADE,T3);
			assertThat(sut,is(expected));
		}
		@Test
		public void 切り札ハートでハートJで検証(){
			Card sut = new Card(HEART,NJ);
			sut.changeSpTrump(HEART);
			Card expected = new Card(HEART,TSJ);
			assertThat(sut,is(expected));
		}
		@Test
		public void 切り札クラブでスペードJで検証(){
			Card sut = new Card(SPADE,NJ);
			sut.changeSpTrump(CLUB);
			Card expected = new Card(SPADE,TPJ);
			assertThat(sut,is(expected));
		}


	}
	@RunWith(Theories.class)
	public static class ジョーカー以外を作るテスト{
		@DataPoints
		public static Param[] PARAMs = {
				new Param(SPADE,SAM,"SAM"),
				new Param(HEART,N3,"H3"),
				new Param(DIA,NT,"DT"),
				new Param(CLUB,NJ,"CJ"),
				new Param(SPADE,NQ,"SQ"),
				new Param(HEART,NK,"HK"),
		};

		static class Param{
			Suit suit_;
			Number num_;
			String msg_;

			Param(Suit suit, Number num,String msg){
				suit_	= suit;
				num_	= num;
				msg_	= msg;

			}
		}

		@Theory
		public void 指定されたカードの数字を返す(Param p) {
			Number expected = p.num_;
			Card card = new Card(p.suit_,p.num_);
			Number actual = card.getNum();
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
				new Fixture("H5<H7",new Card(HEART,N5),new Card(HEART,N7),new Card(HEART,N7)),
				new Fixture("H7>H5",new Card(HEART,N7),new Card(HEART,N5),new Card(HEART,N7)),
				new Fixture("H5>S7",new Card(HEART,N5),new Card(SPADE,N7),new Card(HEART,N5)),
				new Fixture("S5>H7",new Card(SPADE,N5),new Card(HEART,N7),new Card(SPADE,N5)),
				new Fixture("H5<HA",new Card(HEART,N5),new Card(HEART,NA),new Card(HEART,NA)),
				new Fixture("HA>H5",new Card(HEART,NA),new Card(HEART,N5),new Card(HEART,NA)),
				new Fixture("HA<SA",new Card(HEART,NA),new Card(SPADE,SAM),new Card(SPADE,SAM)),
				new Fixture("SA>HA",new Card(SPADE,SAM),new Card(HEART,NA),new Card(SPADE,SAM)),
				new Fixture("HA<JK",new Card(HEART,NA),new Card(JOKER,SJK),new Card(JOKER,SJK)),
				new Fixture("JK>HA",new Card(JOKER,SJK),new Card(HEART,NA),new Card(JOKER,SJK)),
				new Fixture("SA>JK",new Card(SPADE,SAM),new Card(JOKER,SJK),new Card(SPADE,SAM)),
				new Fixture("JK<SA",new Card(JOKER,SJK),new Card(SPADE,SAM),new Card(SPADE,SAM)),
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
