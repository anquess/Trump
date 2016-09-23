package anquess.noTrump;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class MasterTest {

	public static class ゲームの準備を確認{
		Master master;

		@Before
		public void setUp(){
			master = new Master();
			master.prepareGame();
		}

		@Test
		public void 絶対成功(){
			assertThat(1,is(1));
		}


	}

}
