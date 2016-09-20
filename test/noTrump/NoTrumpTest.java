package noTrump;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trump.Card;
import trump.Hand;

public class NoTrumpTest {
	Hand trump;
	@Before
	public void setUp(){
		trump = NoTrump.createTrump();
	}
	@Test
	public void createTrumpで42枚のカードが作られるか検証() {
		int actual = trump.getNumberOfCards();
		int expected = 42;

		assertThat(actual,is(expected));
	}

	@Test
	public void createTrumpでジョーカーが作られるか検証(){
		Card actual = trump.pickCard(5);
		Card expected = new NoTrumpJoker();

		assertThat(actual,is(expected));

	}

}
