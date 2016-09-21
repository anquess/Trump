package noTrump;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import trump.Card;
import trump.Hand;

@RunWith(Enclosed.class)
public class NoTrumpCardTest {

	@RunWith(Theories.class)
	public static class カードを作るテスト{

		static class Fixture{
			int		position_;
			Card	card_;
			String	msg_;
			Fixture(int position, int suit, int num, String msg){
				msg_		= msg;
				position_	= position;
				if((suit == 0) && (num == 0)) card_ = new NoTrumpJoker();
				card_ = new NoTrumpCard(suit, num);
			}
		}

		@DataPoints
		public static Fixture[] PRAMs ={
				new Fixture(5,0,0,"JK"),
				new Fixture(0,Card.SUIT_CLUB,1,"C1"),
				new Fixture(4,Card.SUIT_SPADE,3,"S3"),
				new Fixture(7,Card.SUIT_DIAMOND,5,"D5"),
				new Fixture(40,Card.SUIT_HEART,13,"HK"),
		};

		Hand trump;
		@Before
		public void setUp(){
			trump = NoTrumpCard.createTrump();
		}
		@Test
		public void createTrumpで42枚のカードが作られるか検証() {
			int actual = trump.getNumberOfCards();
			int expected = 42;
			assertThat(actual,is(expected));
		}

		@Theory
		public void createTrumpで作ったカードが正しいか検証(Fixture p){
			Card actual = trump.pickCard(p.position_);
			Card expected = p.card_;
			assertThat(p.msg_,actual,is(expected));
		}
	}

}
