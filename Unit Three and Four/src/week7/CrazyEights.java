package week7;

import java.util.Scanner;

public class CrazyEights {
    private static final double NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";
    private static final String CLUBS = "C";
    private static final double NUM_CARDS_PER_SUIT = 0;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final String playerHand = "player1";
    private static final String compPlayer1 = "player2";
    private static final String compPlayer2 = "player3";

    public static void main(String[] args) {
		int totalCards = 52;

		Scanner in = new Scanner(System.in){
		int i = in.nextLine();
        

        String playerHand =""; 
        String compPlayer1 ="";
        String compPlayer2 ="";  

        }

private static String getCard(String usedCards) {
    String card = getFace() + getSuit();
    
    while(usedCards.indexOf(card) >= 0) {
        card = getFace() + getSuit();
        }
        return card;
    }
    
private static String getFace() {
    return null;
}

private static String getSuit() {
    int suit = (int)(Math.random() * NUM_SUITS);
    if (suit == 0)
        return HEARTS;
     else if (suit == 1)
        return DIAMONDS;
    else if (suit == 2)
        return SPADES;
     else
        return CLUBS;
                    
        }

public static String playCrazyEights(String playerHand, String compPlayer1, String comPlayer2) {
    String cardOnTop = "";
    if (playerHand.equals(cardOnTop))
        return cardOnTop += playerHand;
    else if (playerHand.equals("8"))
            return cardOnTop += playerHand;
    else if (compPlayer1.equals(cardOnTop))
        return cardOnTop += compPlayer1;
    else if (compPlayer1.equals("8"))
        return cardOnTop += compPlayer1;
    else if (compPlayer2.equals(cardOnTop))
        return cardOnTop += compPlayer2;
    else if (compPlayer2.equals("8"))
        return cardOnTop += compPlayer2;
            

    
}

    }
    