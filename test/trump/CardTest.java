package trump;

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

	@RunWith(Theories.class)
	public static class CardFiturereTest{
		@DataPoints
		public static CardFixture[] PARAMs = {
				new CardFixture("SK",Card.SUIT_SPADE,13),
				new CardFixture("CQ",Card.SUIT_CLUB,12),
				new CardFixture("HJ",Card.SUIT_HEART,11),
				new CardFixture("DA",Card.SUIT_DIAMOND,1),
		};

		static class CardFixture{
			String cardString_;
			int suit_;
			int number_;

			CardFixture(String cardString,int suit,int number){
				cardString_	= cardString;
				suit_ 		= suit;
				number_		= number;
			}
		}


		@Theory
		public void testGetNumber(CardFixture pram) {
			Card card = new Card(pram.suit_, pram.number_);
			int expected = pram.number_;
			int actual = card.getNumber();
			String msg = pram.cardString_ + "のテスト：";
			assertThat(msg,actual, is(expected));
		}

		@Theory
		public void testGetSuit(CardFixture pram) {
			Card card = new Card(pram.suit_, pram.number_);
			int expected = pram.suit_;
			int actual = card.getSuit();
			String msg = pram.cardString_ + "のテスト：";
			assertThat(msg,actual, is(expected));
		}

		@Theory
		public void testToString(CardFixture pram) {
			Card card = new Card(pram.suit_, pram.number_);
			String expected = pram.cardString_;
			String actual = card.toString();
			String msg = pram.cardString_ + "のテスト：";
			assertThat(msg,actual, is(expected));
		}

		@Test
		public void testEqualsクラブ9で同じカードか検査(){
			Card expectedCard = new Card(Card.SUIT_CLUB,9);
			Card actualCard = new Card(Card.SUIT_CLUB,9);
			boolean expected = expectedCard.equals(actualCard);
			boolean actual = true;
			assertThat(actual, is(expected));
		}

	}

	@RunWith(Theories.class)
	public static class コンストラクタチェック{


		@Test(expected = IllegalArgumentException.class)
		public void cardコンストラクタチェック_suit5(){
			new Card(5, 9);
		}

		@Test(expected = IllegalArgumentException.class)
		public void cardコンストラクタチェック_suitマイナス(){
			new Card(-1, 9);
		}

		@Test(expected = IllegalArgumentException.class)
		public void cardコンストラクタチェック_number14(){
			new Card(1, 14);
		}

		@Test(expected = IllegalArgumentException.class)
		public void cardコンストラクタチェック_numberマイナス(){
			new Card(1, -9);
		}

	}

}
