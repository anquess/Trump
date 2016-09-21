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
	    NoTrumpPlayer[] player = new NoTrumpPlayer[4];
	    for(int i=0;i<4;i++){
	    	player[i] = new NoTrumpPlayer("プレイヤー" + i, master, table, rule, null, null);
	    	player[i].setPaetner(player[(i+2)%4]);
	    	players.add(player[i]);
	    }

	    return players;
	}
}
