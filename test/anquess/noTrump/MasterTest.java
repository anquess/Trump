package anquess.noTrump;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class MasterTest {

	public static class プレイヤーの登録{
		Master master;
		Player player;

		@Before
		public void setUp(){
			master = new Master();
			player = new Player();
		}

		@Test
		public void registPlayerTest(){
			Player expected = player;
			master.registerPlayer(player);
			Player actual = master.getPlayer(0);
			assertThat(actual,is(expected));
		}

	}

	public static class ゲームの準備を確認{
		Master master;
		Player player1;
		Player player2;
		Player player3;
		Player player4;

		@Before
		public void setUp(){
			master = new Master();
			player1 = new Player("1");
			player2 = new Player("2");
			player3 = new Player("3");
			player4 = new Player("4");
			master.registerPlayer(player1);
			master.registerPlayer(player2);
			master.registerPlayer(player3);
			master.registerPlayer(player4);
		}

		@Test
		public void トランプを配れるか確認(){
			master.distribute();
			int expected = 10;
			int actual;
			for(int i =0 ; i <4;i++){
				actual = master.getPlayer(0).getHandNum();
				assertThat("player" + i,actual,is(expected));
			}
			expected = 2;
			actual = master.trumpSize();
			assertThat("master",actual,is(expected));
		}
	}

}
