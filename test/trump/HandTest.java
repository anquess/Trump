package trump;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class HandTest {
	static Hand hand_;

	public static class ExceptionCheck{
		@Before
		public void setUp(){
			hand_ = new Hand();
		}

		@Test(expected = NullPointerException.class)
		public void addCardTest_null値のカード追加で例外発生() {
			Card card = null;
			hand_.addCard(card);
		}
	}

	public static class Test_スペード全部追加後の検証{

		@Before
		public void setUp(){
			hand_ = new Hand();
			for(int i = 1; i <= 13;i++){
				hand_.addCard(new Card(Card.SUIT_SPADE,i));
			}
		}

		@Test
		public void getNumberOfCardsTestカードの枚数(){
			int expected = 13;
			int actual = hand_.getNumberOfCards();
			assertThat(actual, is(expected));
		}

		@Test(expected = IllegalArgumentException.class)
		public void lookCardTest手札以外マイナス(){
			hand_.lookCard(-1);
		}
		@Test(expected = IllegalArgumentException.class)
		public void lookCardTest13枚目(){
			hand_.lookCard(13);
		}
		@Test
		public void lookCardTest_0枚目SA(){
			Card expected	= new Card(Card.SUIT_SPADE,1);
			Card actual		= hand_.lookCard(0);
			assertThat(actual,is(expected));
		}
		@Test
		public void lookCardTest_13枚目SK(){
			Card expected		= new Card(Card.SUIT_SPADE,13);
			Card actual	= hand_.lookCard(12);
			assertThat(actual,is(expected));
		}

		@Test(expected = IllegalArgumentException.class)
		public void pickCardTest手札以外マイナス(){
			hand_.pickCard(-1);
		}
		@Test(expected = IllegalArgumentException.class)
		public void pickCardTest13枚目(){
			hand_.pickCard(13);
		}
		@Test
		public void pickCardTest_0枚目SA(){
			Card expected	= new Card(Card.SUIT_SPADE,1);
			Card actual		= hand_.pickCard(0);
			assertThat(actual,is(expected));
		}
		@Test
		public void pickCardTest_13枚目SK(){
			Card expected	= new Card(Card.SUIT_SPADE,13);
			Card actual		= hand_.pickCard(12);
			assertThat(actual,is(expected));
		}

		@Test
		public void toStringTest(){
			String expected	= "SA S2 S3 S4 S5 S6 S7 S8 S9 ST SJ SQ SK ";
			String actual	= hand_.toString();
			assertThat(actual,is(expected));
		}

	}
}
