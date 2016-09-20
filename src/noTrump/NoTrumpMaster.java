package noTrump;

import trump.Card;
import trump.Hand;
import trump.Master;
import trump.Player;

public class NoTrumpMaster extends Master {
	public void startGame(){

	}

	public static DeciedCard auction(){
		DeciedCard currentCard = new DeciedCard();


		return currentCard;
	}

	public void prepareGame(Hand trump){
        System.out.println("【カードを配ります】");

        // トランプをシャッフルする
        trump.shuffle();

        for (int index = 0; index < 40; index++)
        {
            // カードから一枚引く
            Card card = trump.pickCard(0);

            // 各プレイヤーに順番にカードを配る
            Player player = (Player)players_.get(index % 4);
            player.receiveCard(card);
        }

	}
}
