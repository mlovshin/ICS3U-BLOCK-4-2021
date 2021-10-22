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
    private static final int playerHand = 0;


    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		getSuit();
        getFace();
        getCard();
        System.out.println(getSuit() + "" + getFace() + "" + getCard() + "");
        System.out.println("Player = " + playerHand);

        playerHand = discard(in, playerHand);
        
    }

private static String getCard() {
    String card = getFace() + getSuit();
    card = getFace() + getSuit();
        return card;
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
    
    private static String discard(Scanner in, String playerHand) {
        
    
            int numCardsToReplace = getNumberToDiscard(in);
            String temp = playerHand;
            if (numCardsToReplace == 0)
               return playerHand;
            else if (numCardsToReplace == 3) {
               playerHand = getCard(playerHand + temp) + " ";
               playerHand += getCard(playerHand + temp) + " ";
               playerHand += getCard(playerHand + temp) + " ";
            } else {
               String cardToReplace = getCardsToDiscard(in, numCardsToReplace, playerHand);
               int space = cardToReplace.indexOf(" ");
               String card1 = "";
               if (space == -1)
                  card1 = cardToReplace;
               else
                  card1 = cardToReplace.substring(0, space);
      
               String card = getCard(playerHand + temp);
               playerHand = playerHand.replace(card1, card);
               if (numCardsToReplace == 2) {
                  String card2 = cardToReplace.substring(space + 1);
                  card = getCard(playerHand + cardToReplace + temp);
                  playerHand = playerHand.replace(card2, card);
               }
            }
            return playerHand;
         }
      
      
         private static String getCardsToDiscard(Scanner in, int numCardsToReplace, String playerHand2) {
        return null;
    }

        private static String getNumberToDiscard(Scanner in, int numCardsToReplace, String playerHand) {
            final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
            boolean validInput = false;
            String cards = "";
            while (!validInput) {
               System.out.println("Please enter the cards to replace: (ex. 7H KD): ");
               cards = in.nextLine().toUpperCase();
              
                String space = "";
                String card1 = cards.substring(0, space);
                  String card2 = cards.substring(space + 1);
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

    }
}
    
    