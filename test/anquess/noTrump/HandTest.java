package anquess.noTrump;

import static anquess.noTrump.Hand.*;
import static anquess.noTrump.Suit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
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
	@RunWith(Theories.class)
	public static class createTrumpTest{

		Hand trump;

		@Before
		public void setUp(){
			trump = createTrump();
		}

		static class Fixture{
			int pickNum_;
			Card expectedCard_;
			String msg_;

			Fixture(int pickNum,Card expectedCard){
				pickNum_ = pickNum;
				msg_ = (pickNum + 1) + "枚目";
				expectedCard_ = expectedCard;
			}
		};

		@DataPoints
		public static Fixture PARAMs[] = {
				new Fixture(0,new Card(CLUB,1)),
				new Fixture(12,new Card(DIA,6)),
				new Fixture(29,new Card(HEART,13)),
				new Fixture(40,new Card(SPADE,3)),
				new Fixture(41,new Card(JOKER,0)),
		};

		@Theory
		public void createTrumpをTest(Fixture p){
			Card actual		= trump.pickUp(p.pickNum_);
			Card expected	= p.expectedCard_;
			assertThat(actual,is(expected));
		}

		@Test
		public void shuffleして1000回中1枚目がSAでないの100回以下(){
			int saCount = 0;
			Card clubA = new Card(CLUB,1);
			assertThat(trump.view(0),is(clubA));
			for(int i = 0 ; i < 1000;i++){
				trump.shuffle();
				if(trump.view(0).equals(clubA)) saCount++;
			}
			String msg = saCount + "回";
			boolean actual = (saCount < 50);
			boolean expected = true;
			assertThat(msg,actual,is(expected));
		}

	}
}