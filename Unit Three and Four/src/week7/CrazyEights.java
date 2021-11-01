package week7;

import javax.lang.model.util.ElementScanner6;
import java.util.Scanner;

public class CrazyEights {
   private static final int NUM_SUITS = 4;
   private static final String HEARTS = "H";
   private static final String DIAMONDS = "D";
   private static final String SPADES = "S";
   private static final String CLUBS = "C";
   private static final String ACE = "A";
   private static final String JACK = "J";
   private static final String QUEEN = "Q";
   private static final String KING = "K";
   private static final double CARDS_PER_SUIT = 13;
   private static int cardsDrawn;

   public static void main(String[] args) {
      int playerPoints = 0, c1Points = 0, c2Points = 0;

      Scanner in = new Scanner(System.in);
      while (!gameOver(playerPoints, c1Points, c2Points)) {
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

        
      while (topCard.indexOf("8") >= 0) {
         topCard = getCard();
      } 

      System.out.println("New Deck:" + " " + topCard);
      
      
          while (playerHand.length() >= 0 && c1Hand.length() >= 0 && c2Hand.length() >= 0) {
            String temp = processPlayer(in, playerHand, topCard);
            playerHand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
    
            temp = processComputer(c1Hand, topCard, playerHand, c2Hand, cardsDrawn);
            c1Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
    
            temp = processComputer(c2Hand, topCard, playerHand, c1Hand, cardsDrawn);
            c2Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
          }
            
          // the round is over and we need to calculate the points.  
            return "17-0-8";

      
    }

   private static String processPlayer(Scanner in, String playerHand, String topCard, int cardsDrawn) {

      while (!canPlay(playerHand, getSuit(topCard), getRank(topCard)) && cardsDrawn <= 5) {
         cardsDrawn++;
         playerHand += " " + getCard();
      }

      if (canPlay(playerHand, getSuit(topCard), getRank(topCard))) {
         System.out.println("Which card would you like to play? ");
         if (playerHand.equals(getSuit(topCard)) && playerHand.equals(getRank(topCard)))
            System.out.println(playerHand);
         else if (playerHand.indexOf("8") >= 0){
            System.out.println(playerHand);
            System.out.println("What suit would you like the next player to play? ");
            String suit = playerHand.substring((playerHand.length() - 1));
               playerHand = playerHand.replace(playerHand.substring(playerHand.indexOf("8"), playerHand.indexOf("8")+2), "");
               System.out.println("8"+suit);
               topCard = "8"+ suit;
               return playerHand + "-" + topCard;
         } else {
            System.out.println("Invalid card. Please choose another card: ");
         

            String card = getCardToDiscard();
         }
      }
      return playerHand;
   }

   private static String getCardToDiscard() {
      return null;
   }

   private static String getCardsToDiscard(Scanner in, int numCardsToReplace, String playerHand,
         String initialDeckCard) {
      String initialDeckCards = "";
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
         } else {
            int addedCards = 0;
            while (playerHand.indexOf(VALID_CARDS) == -1 && playerHand.indexOf(VALID_CARDS) == -1
                  && playerHand.indexOf("8") == -1) {
               System.out.println("You cannot play. Press enter to draw a card.");
               in.nextLine().toUpperCase();
               playerHand += " " + getCard();
               System.out.println("Hand: " + playerHand);
               System.out.println("Deck: " + initialDeckCard);
               addedCards++;
               if (addedCards == 5) {
                  System.out.println("You turn skipped. Draw max 5 cards: ");
                  return playerHand + " ";
               }
            }
         }

      }
   }

   private static String processComputer(String c1Hand, String topCard, String playerHand, String c2Hand, int cardsDrawn) {
      while (!canPlay(c1Hand, getSuit(topCard), getRank(topCard)) && cardsDrawn < 5) {
         cardsDrawn++;
         c1Hand += " " + getCard();
      }
      if (canPlay(c1Hand, getSuit(topCard), getRank(topCard))) {
         System.out.println("Which card would you like to play? ");
         if ((c1Hand.substring(c1Hand.length() - 2).equals(getRank(topCard))) && c1Hand.equals(10))
            System.out.println(c1Hand.length()- 2);
         else if ((c1Hand.subString(c1Hand.length() - 1).equals(getSuit(topCard))) && !c1Hand.equals(10))
            System.out.println(c1Hand.length() - 1);
         else if (c1Hand.indexOf(getRank(topCard))>=0)
            System.out.println(c1Hand);
         else if (c1Hand.indexOf("8") >= 0) {
            System.out.println(c1Hand);
            System.out.println("What suit will you like the next player to play? ");
            String suit = getSuit(c1Hand.length() - 1);
            c1Hand = c1Hand.replace(c1Hand.substring(c1Hand.indexOf("8"), c1Hand.indexOf("8")+2), "");
            System.out.println("8"+suit);
            topCard = "8"+suit;
            return c1Hand + "-" + topCard;

         } else {
            System.out.println("Invalid card. Please choose another card: ");

            String card = getCardToDiscard();
         }
      }

      while (!canPlay(c2Hand, getSuit(topCard), getRank(topCard)) && cardsDrawn < 5) {
         cardsDrawn++;
         c2 += " " + getCard();

         if (canPlay(c2, getSuit(topCard), getRank(topCard))) {
            System.out.println("Which card would you like to play? ");
            if ((c2Hand.subString(c2Hand.length() - 2).equals(getRank(topCard) && c1.equals(10))))
            System.out.println(c2Hand.length() - 2);
            else if ((c2Hand.subString(c2.length() - 1).equals(getSuit(topCard)) && !c2.equals(10)))
            System.out.println(c2Hand.length() - 1);
            if (c2Hand.indexOf(getRank(topCard))>=0)
               System.out.println(c2Hand);
            else if (c2Hand.indexOf("8") >= 0) {
               System.out.println(c2Hand);
               System.out.println("What suit will you like the next player to play? ");
               String suit = getSuit(c2Hand.length() - 1);
               c2Hand = c2Hand.replace(c2Hand.substring(c2Hand.indexOf("8"), c2Hand.indexOf("8")+2), "");
               System.out.println("8"+suit);
               topCard = "8"+suit;
               return c2Hand + "-" + topCard;
      
               } else {
                  System.out.println("Invalid card. Please choose another card: ");
      
                  String card = getCardToDiscard();
               }
         }
      }  

      

   }

   private static int playerPoints(String playerHand) {
      int points = 0;
      if (playerHand.indexOf(ACE) >= 0) {
         points += 1;
      }
      if (playerHand.indexOf("2") >= 0) {
         points += 2;
      }
      if (playerHand.indexOf("3") >= 0) {
         points += 3;
      }
      if (playerHand.indexOf("4") >= 0) {
         points += 4;
      }
      if (playerHand.indexOf("5") >= 0) {
         points += 5;
      }
      if (playerHand.indexOf("6") >= 0) {
         points += 6;
      }
      if (playerHand.indexOf("7") >= 0) {
         points += 7;
      }
      if (playerHand.indexOf("8") >= 0) {
         points += 50;
      }
      if (playerHand.indexOf("9") >= 0) {
         points += 9;
      }
      if (playerHand.indexOf("10") >= 0) {
         points += 10;
      }
      if (playerHand.indexOf(JACK) >= 0) {
         points += 10;
      }
      if (playerHand.indexOf(QUEEN) >= 0) {
         points += 10;
      }
      if (playerHand.indexOf(KING) >= 0) {
         points += 10;
      }
      System.out.println(points);
      return points;
   }

   private static boolean canPlay(String hand, String suit, String rank) {
      return false;
   }

   private static int getRank(String card) {
      if (card.substring(0, 2).equals(10)){
         return "10";
   } else {
      return card.substring(0, 1);
   }
   }

   private static String getSuit(String card) {
      return card.substring(card.length() - 1);

   }

   private static boolean gameOver(int playerPoints, int c1HandPoints, int c2HandPoints) {
      return playerPoints >= 100 || c1HandPoints >= 100 || c2HandPoints >= 100;
   }

}
