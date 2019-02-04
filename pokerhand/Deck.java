package pokerhand;

public class Deck {
	
Card[] cards = new Card[52];

public Deck () 
{
	
	int i = 0;
	
	for (Suit suit : Suit.values()) 
	{
		for (Rank rank : Rank.values()) 
		{
			cards[i++] = new Card(rank,suit);
		}
	}
	
}//constructor method



}
