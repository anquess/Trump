package trump;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Before;
import org.junit.Test;

public class JokerTest {
	Card joker;

	@Before
	public void setUp() {
		joker = new Joker();
	}

	@Test
	public void ジョーカーのスーツを確認(){
		int actual 		= joker.getSuit();
		int expected 	= 0;
		assertThat(actual, is(expected));
	}

	@Test
	public void ジョーカーの数を確認(){
		int actual 		= joker.getNumber();
		int expected 	= 0;
		assertThat(actual, is(expected));
	}

	@Test
	public void equalsTestジョーカー(){
		Card actual		= joker;
		Card expected	= new Joker();
		assertThat(actual, is(expected));
	}
	
	@Test
	public void toStringTestジョーカー(){
		String actual	= joker.toString();
		String expected = "JK";
		assertThat(actual, is(expected));
	}
}
