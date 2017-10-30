import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * ID:B0544134 
 * 
 * 
 * 
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// TODO: please check your output, make sure that you print all cards on
		// your screen (10 points)
		deck.printDeck();

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	/**
	 * This method is used for checking your result, not a part of your HW2
	 * 
	 * @param allCards
	 *            �Ҧ����P
	 * @param nDeck
	 *            �`�@���X�ƵP
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();// ��J�s����

		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank,
						checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/**
 * Description: TODO: please add description here
 */
class Deck {
	private ArrayList<Card> cards;
	// TODO: Please implement the constructor (30 points)
	ArrayList<String> cards1 = new ArrayList<String>();

	public Deck(int nDeck) {
		cards = new ArrayList<Card>();

		for (int i = 1; i <= nDeck; i++) {// �Ĥ@�Ӱj��O�i�H�h�ƵP�A�]�ܼ�i�C�@�}�l���@�ƵP�A�C�C�i�֥[

			for (int x = 1; x <= 4; x++) {// �ĤG�Ӱj��O���
				for (int y = 1; y <= 13; y++) {// �ĤT�Ӱj��O�P��
					Card card = new Card(x, y);
					cards.add(card);// �s���d�[��M���
				}
			}
		}
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);//�s���d�[��M���
		// Sample code end

	}

	// TODO: Please implement the method to print all cards on screen (10
	// points)
	public void printDeck() {

		// Hint: print all items in ArrayList<Card> cards,
		// TODO: please implement and reuse printCard method in Card class (5
		// points)
		int a = cards.size();// �]a���M�椤���j�p�A�o�˴N��O�h�ƵP�]�i�H�M�i�j���
		for (int j = 0; j <= a - 1; j++) {// j�O��l ex:new
											// Card(cards.get(0).getSuit(),
											// cards.get(0).getRank());���X"��"(0,0)�P

			Card card = new Card(cards.get(j).getSuit(), cards.get(j).getRank());// Card�O�U����//card�O�W��
			card.printCard();//�I�s�U����printCard
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/**
 * Description: TODO: please add description here
 */
class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3,
						// Spades=4
	private int rank; // 1~13

	/**
	 * @param s
	 *            suit
	 * @param r
	 *            rank
	 */
	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// TODO: 1. Please implement the printCard method (20 points, 10 for suit,
	// 10 for rank)

	public void printCard() {
		// Hint: print (System.out.println) card as suit,rank, for example:
		// print 1,1 as Clubs Ace

		if (getSuit() == 1)

			System.out.print(" Clubs, ");
		if (getSuit() == 2)

			System.out.print(" Diamonds, ");
		if (getSuit() == 3)
			System.out.print(" Hearts, ");
		if (getSuit() == 4)
			System.out.print(" Spades, ");
		if (getRank() == 1)
			System.out.println("Ace");
		if (getRank() == 2)
			System.out.println("2");
		if (getRank() == 3)
			System.out.println("3");
		if (getRank() == 4)
			System.out.println("4");
		if (getRank() == 5)
			System.out.println("5");
		if (getRank() == 6)
			System.out.println("6");
		if (getRank() == 7)
			System.out.println("7");
		if (getRank() == 8)
			System.out.println("8");
		if (getRank() == 9)
			System.out.println("9");
		if (getRank() == 10)
			System.out.println("10");
		if (getRank() == 11)
			System.out.println("Jack");
		if (getRank() == 12)
			System.out.println("Queen");
		if (getRank() == 13)
			System.out.println("King");
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}
