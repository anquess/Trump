package anquess.noTrump;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class JokerTest {

	public static class 同じカード{
		@Test
		public void 複数のスペードの1を同じと検証(){
			Card actual = new Joker();
			Card expected = new Joker();
			assertThat(actual,is(expected));
		}
	}


	@Test
	public void ジョーカーの数字0を返す() {
		Joker jk = new Joker();
		int expected = 0;
		int actual = jk.getNum();
		assertThat(actual,is(expected));
	}

	@Test
	public void ジョーカーのスート0を返す() {
		Joker jk = new Joker();
		int expected = 0;
		int actual = jk.getSuit();
		assertThat(actual,is(expected));
	}

	@Test
	public void ジョーカーの文字列JKを返す() {
		Joker jk = new Joker();
		String expected = "JK";
		String actual = jk.toString();
		assertThat(actual,is(expected));
	}

}
