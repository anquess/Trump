package noTrump;

import trump.Card;
import trump.Hand;

public class NoTrumpCard extends Card {

	public NoTrumpCard(int suit, int number) {
		super(suit, number);
		// TODO 自動生成されたコンストラクター・スタブ
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

}
