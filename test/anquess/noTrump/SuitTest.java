package anquess.noTrump;

import static anquess.noTrump.Suit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SuitTest {

	@Test
	public void toStringTest() {
		assertThat("JK",	JOKER.toString(),	is("JK"));
		assertThat("SPADE",	SPADE.toString(),	is("S"));
		assertThat("HEART",	HEART.toString(),	is("H"));
		assertThat("DIA",	DIA.toString(),		is("D"));
		assertThat("CLUB",	CLUB.toString(),	is("C"));
	}



}
