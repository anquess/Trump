package anquess.noTrump;

public class Table {
	private Hand gameCards_;
	private int cardsNum_;

	public void reset(){
		cardsNum_ = 0;
		for(int i = 0;i < 4;i++){
			gameCards_ = new Hand();
		}
	}
	public Table(){
		gameCards_ = new Hand();
		cardsNum_ = 0;
	}

	public void put(Card card) {
		if(cardsNum_ == 4) reset();
		gameCards_.add(card);
		cardsNum_++;
	}
	public int getCardNum() {
		return cardsNum_;
	}

	@Override
	public String toString(){
		return gameCards_.toString();
	}
}
