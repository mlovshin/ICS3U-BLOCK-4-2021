package week7;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

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
    private static String playerHand = "";
    private static String comp1 = "";
    private static String comp2 = "";
    private static String player1 = playerHand;
    private static String compPlayer1 = comp1;
    private static String compPlayer2 = comp2;


    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		getSuit();
        getFace();
        getCard();
        
        playerHand = discard(in, playerHand);
        
    }

    private static String order(String player1, String compPlayer1, String compPlayer2) {
        //how do I create an order of people, how do I connect this method to the "nextPlayer" method
    }

    private static String distributeCard(int playerHand, int comp1, int comp2) {
    playerHand += (getCard() + getCard() + getCard() + getCard() + getCard());
    comp1 += (getCard() + getCard() + getCard() + getCard() + getCard());
    comp2 += (getCard() + getCard() + getCard() + getCard() + getCard());

    System.out.println("Player hand is: " + playerHand);
    }

    private static String playCrazyEight(String playerHand, String comp1, String comp2) {
        String topCard = "";
        Object rank;
        Object suits;
        String nextPlayer = "";
        if (playerHand.equals(8)){
            return topCard += playerHand;
            System.out.println("What suit does the next person have to play?: ");
        if (nextPlayer) //code how to ask the next player to play that suit
        else if (comp1.equals(8))
            return topCard+= comp1;
            System.out.println("What suit does the next person have to play?: ");
        else if (comp2.equals(8))
            return topCard+= comp2;
            System.out.println("What suit does the next person have to play?: ");

        } else if (suits.equals(playerHand)){
            return topCard+= playerHand;
        else if (suits.equals(comp1))
            return topCard+= comp1;
        else if (suits.equals(comp2))
            return topCard += comp2;
        else // what happens if not
        
        }else if(rank.equals(playerHand)) {
                return topCard += playerHand;
        else if(rank.equals(comp1))
                return topCard += comp1;
        else if(rank.equals(comp2))
                return topCard += comp2;
        else // what happens if not
        
    }


    private static int discard(Scanner in, int playerhand2) {
        return 0;
    }

    private static void getCard() {
    }

    private static String getFace() {
        int face = (int)(Math.random() * NUM_CARDS_PER_SUIT) + 1;

        if(face >= 2 && face >= 10)
            return "" + face;
        else if (face == 1)
            return ACE;
        else if (face == 11)
            return JACK;
        else if (face == 12)
            return QUEEN;
        else
            return KING;
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
    
    private static String getCardsToDiscard(Scanner in, int numCardsToReplace, String playerHand2) {
            final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
            boolean validInput = false;
            String cards = "";
            while (!validInput) {
               System.out.println("Please enter the cards to replace: (ex. 7H KD): ");
               cards = in.nextLine().toUpperCase();
              
                String card1 = cards.substring(0);
                  String card2 = cards.substring(0 + 1);
                  if (VALID_CARDS.indexOf(card1) < 0)
                     System.out.println("Not a valid card: " + card1);
                  else if (VALID_CARDS.indexOf(card2) < 0)
                     System.out.println("Not a valid card: " + card2);
                  else if (playerHand.indexOf(card1) < 0)
                     System.out.println("You don't have a " + card1);
                  else if (playerHand.indexOf(card2) < 0)
                     System.out.println("You don't have a " + card2);
                  else if (playerHand.equals(card2))
                    System.out.println("You cannot discard the same card.");
                  else
                     validInput = true;
               }
            return cards;
    }

        private static String getCard(String string) {
        String card = getFace() + getSuit();
        card = getFace() + getSuit();
            return card;
    
    }

}
    
    