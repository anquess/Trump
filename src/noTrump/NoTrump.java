package noTrump;

import java.util.ArrayList;

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
        master.prepareGame(NoTrumpCard.createTrump());


        DeciedCard deciedCard = master.auction();

		if(deciedCard.getSuit() != 0){
			System.out.println("続けます");
	        // ゲームを開始する
	        master.startGame();

		}else{
			System.out.println("終了します");
		}

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
