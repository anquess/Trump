package anquess.noTrump;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DealerTest {

	public static class プレイヤーの登録{
		Dealer dealer;
		Player player;

		@Before
		public void setUp(){
			dealer = new Dealer();
			player = new Player();
		}

		@Test
		public void registPlayerTest(){
			Player expected = player;
			dealer.registerPlayer(player);
			Player actual = dealer.getPlayer(0);
			assertThat(actual,is(expected));
		}

	}

	public static class ゲームの準備を確認{
		Dealer dealer;
		Player player1;
		Player player2;
		Player player3;
		Player player4;

		@Before
		public void setUp(){
			dealer = new Dealer();
			player1 = new Player("1");
			player2 = new Player("2");
			player3 = new Player("3");
			player4 = new Player("4");
			dealer.registerPlayer(player1);
			dealer.registerPlayer(player2);
			dealer.registerPlayer(player3);
			dealer.registerPlayer(player4);
		}

		@Test(expected = IllegalArgumentException.class)
		public void 上限より多いプレイヤー5人目を追加してエラーがでるか(){
			dealer.registerPlayer(new Player("5"));
		}

		@Test
		public void トランプを配れるか確認(){
			dealer.distributeTrump();
			int expected = 10;
			int actual;
			for(int i =0 ; i <4;i++){
				actual = dealer.getPlayer(0).getHandSize();
				assertThat("player" + i,actual,is(expected));
			}
			expected = 2;
			actual = dealer.trumpSize();
			assertThat("dealer",actual,is(expected));
		}
	}

}
