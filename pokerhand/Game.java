package pokerhand;

import java.util.*;

public class Game {
	
	static Random rnd = new Random();
	static Card[] hand = new Card[5];
	
	public static void main(String[] args) 
	{
		
		Deck deck = new Deck();
		
		/*
		for (int i = 0; i < deck.cards.length; i++) 
		{
			System.out.println(deck.cards[i].getName());
		}*/
		
		
		Game.newHand(deck);
		
		Card[] testHand = new Card[5];
		
		testHand[0] = new Card(Rank.TEN, Suit.SPADES);
		testHand[1] = new Card(Rank.NINE, Suit.SPADES);
		testHand[2] = new Card(Rank.EIGHT, Suit.SPADES);
		testHand[3] = new Card(Rank.SEVEN, Suit.SPADES);
		testHand[4] = new Card(Rank.SIX, Suit.SPADES);
		
		for (int i = 0; i < hand.length; i++) 
		{
			System.out.println(hand[i].getName());
		}
		
		System.out.println("\n***********************************************\n");		
		System.out.print(Evaluator.checkHand(hand));
		
	}//main
	
	public static void newHand(Deck deck) 
	{		
		
		Arrays.fill(hand, null);
		int i = 0;
		
		while (i < hand.length) 
		{
			int j = rnd.nextInt(52);
			
			if(!Arrays.asList(hand).contains(deck.cards[j])) 
			{
				hand[i] = deck.cards[j];
				i++;
			}
			else 
			{
				continue;
			}
		}//while
		
	}//newHand

}//class Game
