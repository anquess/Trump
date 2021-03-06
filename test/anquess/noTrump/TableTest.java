package anquess.noTrump;

import static anquess.noTrump.Number.*;
import static anquess.noTrump.Suit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TableTest {
	Trick table;
	Card[] card;

	@Before
	public void setUp(){
		table = new Trick();
		card = new Card[]{
				new Card(SPADE,SAM),
				new Card(SPADE,N3),
				new Card(SPADE,N5),
				new Card(SPADE,N6),
				new Card(SPADE,N7),
				new Card(SPADE,N8),
		};
	}

	@Test
	public void テーブルにカード置いた後のカードを検証(){
		String actual;
		String expected;
		String msg;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 6; i++){
			if(i%4 == 0) sb = new StringBuilder();
			table.put(card[i]);
			sb.append(card[i]);
			sb.append(" ");
			actual		= table.toString();
			expected	= sb.toString();
			msg = ( i + 1) + "回目";
			assertThat(msg,actual,is(expected));
		}
	}

}
