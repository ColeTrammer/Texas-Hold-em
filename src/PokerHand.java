import java.util.ArrayList;
import java.util.Collections;

/**********************************
 * Texas Hold-em! Your task is to determine if the cards in the list makes up a
 * straight (five cards of sequential rank) or not. The cards will always have
 * values ranging from 2-14, where 14 is the ace.
 * 
 * Be aware that the ace (14) also should count as value 1!
 * 
 * The number of cards will vary, but will never be more than 7 (the board (5) +
 * player hand (2))
 * 
 * Examples:
 * 
 * straight: 9-10-11-12-13
 * 
 * straight: 14-2-3-4-5
 * 
 * straight: 2-7-8-5-10-9-11
 * 
 * not straight: 7-8-12-13-14
 *
 ***********************/
public final class PokerHand {
	public static boolean IsStraight(ArrayList<Integer> cards) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i) == 14) {
				cards.set(i, 1);
			}
		}
		Collections.sort(cards);
		int count = 0;
		int last = -1;
		for (int card : cards) {
			if (count == 0) {
				count++;
			} else if (card == 1) {
				if (last == 13) {
					count++;
				}
			} else if (card - 1 == last) {
				count++;
			} else {
				count = 0;
			}
			if (count >= 5) {
				return true;
			}
			last = card;
		}
		return false;
	}
}