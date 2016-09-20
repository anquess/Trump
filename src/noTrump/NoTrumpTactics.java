package noTrump;

import trump.Card;
import trump.Hand;

public interface NoTrumpTactics {

	DeciedCard readBid(DeciedCard currentCard,Hand hand);
	Card readPutCard(Hand hand,Card cards[],DeciedCard deciedCard);
	Card[] readDropCard(Hand hand,DeciedCard deciedCard);
}
