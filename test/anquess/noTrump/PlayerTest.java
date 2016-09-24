package anquess.noTrump;

import static anquess.noTrump.Suit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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
		assertThat(player.getHandNum(),is(1));
		Card actual = player.put(0);
		assertThat(actual,is(expected));
		assertThat(player.getHandNum(),is(0));
	}

	@Test
	public void setNameで設定した名前がgetNameで検証(){
		String expected	= "Test";
		String actual	= player.getName();
		assertThat(actual,is(expected));
	}

}
