package noTrump;

import java.util.ArrayList;

import trump.Card;
import trump.Hand;

public class NoTrump {

	public static void main(String[] args) {
        // 進行役の生成
        NoTrumpMaster master = new NoTrumpMaster();

        // テーブルの生成
        NoTrumpTable table = new NoTrumpTable();

        // ルールの生成
        NoTrumpRule rule = new NoTrumpRule();

        // プレイヤーを登録
		for(NoTrumpPlayer player:CreatePlayers(master,table,rule)){
			master.registerPlayer(player);
		}

        // ゲームの準備をする
        master.prepareGame(createTrump());


        DeciedCard deciedCard = master.auction();

		if(deciedCard.getSuit() != 0){
			System.out.println("続けます");
	        // ゲームを開始する
	        master.startGame();

		}else{
			System.out.println("終了します");
		}

	}
	public static Hand createTrump(){
		Hand trump = new Hand();
        trump.addCard(new NoTrumpCard(Card.SUIT_CLUB, 1));
        trump.addCard(new NoTrumpCard(Card.SUIT_DIAMOND, 1));
        trump.addCard(new NoTrumpCard(Card.SUIT_HEART, 1));
        trump.addCard(new NoTrumpCard(Card.SUIT_SPADE, 1));
        trump.addCard(new NoTrumpCard(Card.SUIT_SPADE, 3));
        trump.addCard(new NoTrumpJoker());

		for (int number = 5; number <= Card.CARD_NUM; number++)
        {
            trump.addCard(new NoTrumpCard(Card.SUIT_CLUB, number));
            trump.addCard(new NoTrumpCard(Card.SUIT_DIAMOND, number));
            trump.addCard(new NoTrumpCard(Card.SUIT_HEART, number));
            trump.addCard(new NoTrumpCard(Card.SUIT_SPADE, number));
        }
		return trump;
	}
	public static ArrayList<NoTrumpPlayer> CreatePlayers(NoTrumpMaster master,NoTrumpTable table,NoTrumpRule rule){
	    ArrayList<NoTrumpPlayer> players = new ArrayList<NoTrumpPlayer>();

		// プレイヤーの生成
	    NoTrumpPlayer player1 = new NoTrumpPlayer("村田", master, table, rule, null, null);
	    NoTrumpPlayer player2 = new NoTrumpPlayer("山田", master, table, rule, player1, null);
	    player1.setPaetner(player2);
	    NoTrumpPlayer player3  = new NoTrumpPlayer("斎藤", master, table, rule, null, null);
	    NoTrumpPlayer player4 = new NoTrumpPlayer("蓮太郎", master, table, rule,player3,null);
	    player3.setPaetner(player4);
	    players.add(player1);
	    players.add(player2);
	    players.add(player3);
	    players.add(player4);

	    return players;
	}
}
