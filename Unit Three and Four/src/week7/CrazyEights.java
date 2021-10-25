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
    


    

    public static void main(String[] args) {
        int playerPoints = 0, c1Points = 0, c2Points = 0;
        getSuit();
        getFace();
        getCard();
     
           while (!gameOver(playerPoints, c1Points, c2Points)) {
              String result = playRound();
              int firstDash = result.indexOf("-");
              int secondDash = result.lastIndexOf("-");
              // int secondDash = result.indexOf("-", firstDash + 1);
              playerPoints += Integer.parseInt(result.substring(0, firstDash));
              c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
              c2Points += Integer.parseInt(result.substring(secondDash + 1));
     
              System.out.println(playerPoints + " " + c1Points + " " + c2Points);
           }
        }
    
    private static String playRound(String playerHand, String comp1, String comp2, String rank, String suits) {
        String topCard;

        if (playerHand.equals(suits)){
            return topCard += playerHand;

        } else if (playerHand.equals(rank)){
            return topCard+= playerHand;
        
    }

    private static String distributeCard() {
    String playerHand = "" + getCard() + "" + getCard() + "" + getCard() + "" + getCard() + "" + getCard();
        return playerHand;
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
   
        private static String getCard() {
        String card = getFace() + getSuit();
        card = getFace() + getSuit();
                return card;
        
        }
    
    
    private static String getCardsToPlay(Scanner in, int numCardsToReplace, String playerHand) {
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

  
    private static String playRound() {
        System.out.println("Let's start game!");
        String playerHand = "";
        String c1Hand = "";
        String c2Hand = "";
  
        String topCard = "";
  
        String temp = processPlayer(playerHand, topCard);
        playerHand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
  
        temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
        c1Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
  
        temp = processComputer(c2Hand, topCard, playerHand, c1Hand);
        c2Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
  
        return "17-0-8";
     }

     private static String processComputer(String c1Hand, String topCard, String playerHand, String c2Hand) {
        return null;
    }

    private static String processPlayer(String playerHand, String topCard) {
        while (!canPlay(hand, getSuit(topCard), getRank(topCard), getCard(topCard)), playerHand < 5)
            if(playerHand < 5)
                
     }
  
     private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
     }


}
    
    