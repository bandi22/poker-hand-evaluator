package pokerhand;

import java.util.Arrays;

public class Evaluator {
	
public static boolean isFlush(Card[] hand) 
{	
	for (int i = 1; i < hand.length;i++) 
	{
		if (hand[i].suit != hand[i-1].suit) 
		{
			return false;
		}
	} //checks if hand is flush (i.e. all 5 cards has the same suit)
	
	return true;
} //check if had is flush

public static int[] histogram(Card[] hand) 
{
	int[] handRanks = new int[13];
	Arrays.fill(handRanks, 0);
	
	for (int i = 0; i < hand.length; i++) 
	{
		switch (hand[i].rank) 
		{
			case TWO:
				handRanks[0]++;
			break;
			case THREE:
				handRanks[1]++;
			break;
			case FOUR:
				handRanks[2]++;
			break;
			case FIVE:
				handRanks[3]++;
			break;
			case SIX:
				handRanks[4]++;
			break;
			case SEVEN:
				handRanks[5]++;
			break;
			case EIGHT:
				handRanks[6]++;
			break;
			case NINE:
				handRanks[7]++;
			break;
			case TEN:
				handRanks[8]++;
			break;
			case JACK:
				handRanks[9]++;
			break;
			case QUEEN:
				handRanks[10]++;
			break;
			case KING:
				handRanks[11]++;
			break;
			case ACE:
				handRanks[12]++;
			break;
		}//switch
	}//for -- fill histogram array
	
	return handRanks;
	
}//histogram method

public static int countSimilar(int number, int histogram[]) 
{
	int count = 0;
	
	for(int i = 0; i < histogram.length; i++) 
	{
		if (histogram[i] == number) 
		{
			count++;
		}
	}
	
	return count;
} //countSimilar
/*method checks if number of similar values is present in the histogram; 
	 e. g. number 4 indicates a four-of-a-kind */ 

public static boolean jacksOrBetter(int histogram[]) 
{
	if ((histogram[9] == 2) || (histogram[10] == 2) || (histogram[11] == 2) || (histogram[12] == 2)) 
	{
		return true;
	}
	
	else {
		return false;
	}	
} //checks if there are any pairs of Jacks or better; use with checkHand pair condition branch!

public static boolean isStraight(int histogram[]) 
{
	int first = 0;
	int last = 0;
	
	for(int i = 0; i < histogram.length; i++) 
	{
		if (histogram[i] == 1) 
		{
			first = i+1;
			break;
		}
	}
	
	for(int i = histogram.length-1; i > 0; i--) 
	{
		if (histogram[i] == 1) 
		{
			last = i+1;
			break;
		}
	}
	
	if (last-first == 4) 
	{
		return true;
	}
	else 
	{
		return false;
	}
	
} //method to determine if an a hand is a straight; use when histogram has five 1 values!

public static handRank checkHand(Card[] hand) 
{
	
	handRank score = handRank.HIGH_CARD;  
	
	int[] histogram = Evaluator.histogram(hand);
	
	if ((Evaluator.countSimilar(1, histogram) == 5) && (Evaluator.isStraight(histogram) == true) && (!Evaluator.isFlush(hand))) 
	{
		score = handRank.STRAIGHT;
	}
	
	else if (Evaluator.isFlush(hand) && (Evaluator.isStraight(histogram) == false)) 
	{
		score = handRank.FLUSH;
	}
	
	else if ((Evaluator.countSimilar(1, histogram) == 5) && (Evaluator.isStraight(histogram) == true) && (Evaluator.isFlush(hand) == true)) 
	{
		if (histogram[12] == 1) {
			score = handRank.ROYAL_FLUSH;
		}
		else 
		{
			score = handRank.STRAIGHT_FLUSH;
		}
	}
	
	else if ((Evaluator.countSimilar(3, histogram) > 0) && (Evaluator.countSimilar(2, histogram) > 0)) 
	{
		score = handRank.FULL_HOUSE;
	}
	
	else if ((Evaluator.countSimilar(2, histogram)) > 0 && (Evaluator.jacksOrBetter(histogram) == true)) 
	{
		score = handRank.JACKS_OR_BETTER;
	}
	
	else if (Evaluator.countSimilar(2, histogram) == 2) 
	{
		score = handRank.TWO_PAIR;
	}
	
	else if (Evaluator.countSimilar(3, histogram) > 0) 
	{
		score = handRank.THREE_OF_A_KIND;
	}
	
	else if (Evaluator.countSimilar(4, histogram) > 0) 
	{
		score = handRank.FOUR_OF_A_KIND;
	}

	return score;
}

}//class Evaluator

enum handRank{
	HIGH_CARD,
	JACKS_OR_BETTER,
	TWO_PAIR,
	THREE_OF_A_KIND,
	STRAIGHT,
	FLUSH,
	FULL_HOUSE,
	FOUR_OF_A_KIND,
	STRAIGHT_FLUSH,
	ROYAL_FLUSH
}