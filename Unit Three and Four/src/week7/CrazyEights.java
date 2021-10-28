package week7;

import javax.lang.model.util.ElementScanner6;
import java.util.Scanner;

public class CrazyEights {
    private static final double NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";
    private static final String CLUBS = "C";
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";


    public static void main(String[] args) {
        int playerPoints = 0, c1Points = 0, c2Points = 0;
        String playerHand = ""; 

        playerHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " "; 

        System.out.println("The player's hand is: " + playerHand);
      
    
        Scanner in = new Scanner(System.in); 
        while(!gameOver(playerPoints, c1Points, c2Points)) {
            String result = playRound(in);
            int firstDash = result.indexOf("-");
            int secondDash = result.lastIndexOf("-");
            // int secondDash = result.indexOf("-", firstDash + 1);
            playerPoints += Integer.parseInt(result.substring(0, firstDash));
            c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
            c2Points += Integer.parseInt(result.substring(secondDash + 1));

            System.out.println(playerPoints + " " + c1Points + " " + c2Points);
        }
    }
    
    private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);
  
        if (suit == 0)
           return HEARTS;
        else if (suit == 1)
           return DIAMONDS;
        else if (suit == 2)
           return CLUBS;
        else
           return SPADES;
  
     }
  
     private static String getFace() {
  
        int suit = (int) (Math.random() * CARDS_PER_SUIT);
        if (suit >= 2 && suit <= 10)
           return suit + "";
        else if (suit == 1)
           return ACE;
        else if (suit == 11)
           return JACK;
        else if (suit == 12)
           return QUEEN;
        else
           return KING;
  
     }
    private static String getCard() {
        String card = getFace() + getSuit();
        return card;

    }

    private static String playRound(Scanner in) {
        System.out.println("Let's start game!");
        String playerHand = "";
        String c1Hand = "";
        String c2Hand = "";

        String topCard = getCard();
        for (int i = 0; i < 6; i++){
            playerHand += getCard() + " ";
            c1Hand += getCard() + " ";
            c2Hand += getCard() + " ";
        }
        System.out.println("Player hand: " + playerHand);

        initialDeckCard = getCard();
      if (initialDeckCard.indexOf("8") >= 0) {
         initialDeckCard = getCard();
         System.out.println("New Deck:" + " " + initialDeckCard);

      } else {
          while (playerHand.length() >= 0 || c1.length() >= 0 || c2.length() >= 0) {
            String temp = processPlayer(in, playerHand, topCard);
            playerHand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
    
            temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
            c1Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
    
            temp = processComputer(c2Hand, topCard, playerHand, c1Hand);
            c2Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
    
            System.out.println("17-0-8");
            return temp;

          }

      }
    }

    private static String processPlayer(Scanner in, String playerHand, String topCard) {

        int cardsDrawn = 0;

        while (!canPlay(playerHand, getSuit(topCard), getRank(topCard)) && cardsDrawn < 5){
            cardsDrawn++;
            playerHand += " " + getCard();
        }


        if (canPlay(playerHand, getSuit(topCard), getRank(topCard))){
            System.out.println("Which card would you like to play? ");
            if (playerHand.equals(getSuit(topCard)) && playerHand.equals(getRank(topCard))) 
                System.out.println(playerHand);
            else if(playerHand.equals(8))
                System.out.println("What suit would you like the next player to play? ");
            else
                System.out.println("Invalid card. Please choose another card: ");

            String card = getCardToDiscard(); 
        }
    }

    private static String getCardsToDiscard(Scanner in, int numCardsToReplace, String playerHand) {
        final String VALID_CARDS = "3";
        boolean validInput = false;
        String cards = "";
        while (!validInput) {
           System.out.println("Please enter the cards to replace: (ex. 7H KD): ");
           cards = in.nextLine().toUpperCase();
           if (countOccurences(cards, " ") != numCardsToReplace - 1) {
              System.out.println("You must choose " + numCardsToReplace + " cards.");
           } else if ((numCardsToReplace == 1) && (playerHand.indexOf(cards) < 0))
              System.out.println("You don't have a " + cards);
           else if ((numCardsToReplace == 1) && (playerHand.indexOf(cards) >= 0))
              validInput = true;
           else if (numCardsToReplace == 2) {
              int space = cards.indexOf(" ");
  
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

    private static String processComputer(String c1Hand, String topCard, String playerHand, String c2Hand) {
        while (!canPlay(c1, getSuit(topCard), getRank(topCard)) && cardsDrawn < 5){
            cardsDrawn++;
            c1 += " " + getCard();
        }
        if (canPlay(c1, getSuit(topCard), getRank(topCard))){
            System.out.println("Which card would you like to play? ");
            if (c1.equals(getSuit(topCard)) && !c1.equals(8)) 
                System.out.println(c1);
            else if(c1.equals(getRank(topCard) && !c1.equals(8)))
                System.out.println(c1);
            else if(c1.equals(8)){
                System.out.println(c1);
                System.out.println("What suit will you like the next player to play? ");
            System.out.println(getSuit(c1.length() - 1));
            }else{
                System.out.println("Invalid card. Please choose another card: ");

            String card = getCardToDiscard(); 
            }
        }

        while (!canPlay(c2, getSuit(topCard), getRank(topCard)) && cardsDrawn < 5){
            cardsDrawn++;
            c2 += " " + getCard();
        
        if (canPlay(c2, getSuit(topCard), getRank(topCard))){
            System.out.println("Which card would you like to play? ");
            if (c2.equals(getSuit(topCard)) && !c2.equals(8)) 
                System.out.println(c2);
            else if(c2.equals(getRank(topCard) && !c2.equals(8)))
                System.out.println(c2);
            else if(c2.equals(8))
                System.out.println(c2);
                System.out.println("What suit will you like the next player to play? ");
            System.out.println(getSuit(c2 - 1));
    
        }else{
                System.out.println("Invalid card. Please choose another card: ");

            String card = getCardToDiscard(); 
        }
            
     }
     

    }

    private static boolean canPlay(Object hand, Object suit, Object rank, Object card, Object object) {
        return false;
    }

    private static Object getRank(String topCard) {
        return null;
    }

    private static Object getSuit(String topCard) {
        return null;
    }

    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
    }

}
