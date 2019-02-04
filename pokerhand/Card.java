package pokerhand;

public class Card {
	
	Rank rank;
	Suit suit;

	public Card (Rank rank, Suit suit) 
	{
		this.rank = rank;
		this.suit = suit;
		
	}
	
	public Suit getSuit() 
	{
		return this.suit;
	}
	
	public Rank getRank() 
	{
		return this.rank;
	}
	
	public String getName() 
	{
		return this.rank + " OF " + this.suit;
	}
	
} //Card class

enum Suit 
{
	CLUBS, DIAMONDS, HEARTS, SPADES
}

enum Rank
{
	TWO, THREE, FOUR, FIVE, SIX,
	SEVEN, EIGHT, NINE, TEN,
	JACK, QUEEN, KING, ACE
}
