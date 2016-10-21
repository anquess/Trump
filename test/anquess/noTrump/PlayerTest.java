package anquess.noTrump;

import static anquess.noTrump.Suit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	Player player;
	Card card_;

	@Before
	public void setUp(){
		player 		= new Player();
		card_		= new Card(SPADE,1);
		player.recieve(card_);
		player.setName("Test");
	}

	@Test
	public void カードを1枚受け取って1枚目を検証 (){
		Card expected	= new Card(SPADE,1);
		assertThat(player.getHandSize(),is(1));
		Card actual = player.put(0);
		assertThat(actual,is(expected));
		assertThat(player.getHandSize(),is(0));
	}

	@Test
	public void カードを配列で2枚受け取って1枚目と2枚目を検証 (){
		Card[] expected	= {new Card(SPADE,3),new Card(HEART,13)};
		player.recieve(expected);
		assertThat(player.getHandSize(),is(3));
		Card actual = player.put(1);
		assertThat("1枚目",actual,is(expected[0]));
		actual = player.put(1);
		assertThat("2枚目",actual,is(expected[1]));
		assertThat(player.getHandSize(),is(1));
	}

	@Test
	public void カードをarrayListで2枚受け取って1枚目と2枚目を検証 (){
		List<Card> expected	= new ArrayList<Card>();
			expected.add(new Card(SPADE,3));
			expected.add(new Card(HEART,13));
		player.recieve(expected);
		assertThat(player.getHandSize(),is(3));
		Card actual = player.put(1);
		assertThat("1枚目",actual,is(expected.get(0)));
		actual = player.put(1);
		assertThat("2枚目",actual,is(expected.get(1)));
		assertThat(player.getHandSize(),is(1));
	}


	@Test
	public void setNameで設定した名前がgetNameで検証(){
		String expected	= "Test";
		String actual	= player.toString();
		assertThat(actual,is(expected));
	}

}
