package anquess.noTrump;

import static anquess.noTrump.Hand.*;
import static anquess.noTrump.Suit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class HandTest {

	public static class Handに追加したりテスト{
		Hand hand;

		@Before
		public void setUp() {
			hand	= new Hand();
			Card card	= new Card(SPADE,1);
			hand.add(card);
			card	= new Card(CLUB,1);
			hand.add(card);

		}

		@Test
		public void handにSAとCA加えてピックアップしてみる() {
			Card expected	= new Card(SPADE,1);
			assertThat(hand.size(),is(2));
			Card actual = hand.pickUp(0);
			assertThat(actual,is(expected));
			assertThat(hand.size(),is(1));
		}

		@Test
		public void handにSAとCA加えて見る() {
			Card expected	= new Card(SPADE,1);
			assertThat(hand.size(),is(2));
			Card actual = hand.view(0);
			assertThat(actual,is(expected));
			assertThat(hand.size(),is(2));
		}


		@Test
		public void handにSAとCA加えてtoStringしてみる() {
			String actual = hand.toString();
			String expected = "SA CA ";
			assertThat(actual,is(expected));
		}
	}

	public static class createTrumpTest{

		Hand trump;

		@Before
		public void setUp(){
			trump = createTrump();
		}

		@Test
		public void createTrumpTest1枚目(){
			Card actual		= trump.pickUp(0);
			Card expected	= new Card(JOKER,0);
			assertThat(actual,is(expected));
		}

		@Test
		public void createTrumpTest13枚目(){
			Card actual		= trump.pickUp(12);
			Card expected	= new Card(HEART,1);
			assertThat(actual,is(expected));
		}

		@Test
		public void createTrumpTest31枚目(){
			Card actual		= trump.pickUp(30);
			Card expected	= new Card(Suit.DIA,12);
			assertThat(actual,is(expected));
		}

		@Test
		public void createTrumpTest42枚目(){
			Card actual		= trump.pickUp(41);
			Card expected	= new Card(CLUB,13);
			assertThat(actual,is(expected));
		}

		@Test
		public void shuffleして1000回中1枚目がSAでないの100回以下(){
			int saCount = 0;
			Card spadeA = new Card(JOKER,0);
			assertThat(trump.view(0),is(spadeA));
			for(int i = 0 ; i < 1000;i++){
				trump.shuffle();
				if(trump.view(0).equals(spadeA)) saCount++;
			}
			String msg = saCount + "回";
			boolean actual = (saCount < 50);
			boolean expected = true;
			assertThat(msg,actual,is(expected));
		}

	}
}