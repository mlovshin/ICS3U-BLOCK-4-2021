package week7;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;



public class ThreeCardPoker {
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
    private static final int PLAYER_WINS = 1;
    private static final int DEALER_WINS = 2;
    private static final int TIE = 3;
    public static void main(String[] args) {
        int wallet = 500;
        Scanner in = new Scanner(System.in);
        int minBet = 50;
        int maxBet = 100;
        boolean playAgain = true;
        // int bet = getWager(in, 50, 100, wallet);
        while (playAgain) {
            wallet = playPokerHand(in, wallet, minBet, maxBet);
            if (wallet >= 100)
               playAgain = playAgain(in);
            else {
               System.out.println("You don't have enough money to play again!");
               playAgain = false;
        
        String playerHand ="";   //"5D AC KS";

        playerHand = getCard(playerHand) + " ";
        playerHand += getCard(playerHand) + " ";
        playerHand += getCard(playerHand) + " ";
        System.out.println(playerHand);

        playerHand = discard(in, playerHand);
     }
    }
}
private static boolean playAgain(Scanner in) {
    boolean validInput = false;

    while (!validInput) {
       System.out.print("Do you want to play again ([Y]es / [N]o)");
       String answer = in.nextLine().toUpperCase();
       if (answer.equals("YES") || answer.equals("Y"))
          return true;
       else if (answer.equals("NO") || answer.equals("N")) {
          return false;
       } else {
          System.out.println("Invalid Input: Yes or No only!");
       }
    }

    return false;
 }

    private static int discard(Scanner in, String playerHand) {
        //int discard = 0;
        //Object usedCards;
        
        //System.out.println("Please enter number of cards you want to discard between 0 and 3: ");
        //if (playerHand.discard(0))
            //return playerHand;
        //else if (playerHand.discard(3))
            //return (int)(Math.random(3) != usedCards);
        //else if (playerHand - 1 || playerHand - 2)
            //System.out.println("Which cards do you want to discard?: ");
                //return playerHand.discard(playerHand - 1 || playerHand - 2);
                    //return (int)(Math.random(1 || 2) != usedCards);
        //if (playerHand.discard(2))
           

        // if 0 do nothing but return playerHand
        // if 3 playerHand = ""; get 3 cards (that have not already been used)
        // if 1 or 2 -> prompt for which cards and replace them 
        // (2) => 3D JC, validate their input ========= ASK HOW

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
  
     private static int getNumberToDiscard(Scanner in) {
        boolean validInput = false;
        int val = 0;
        while (!validInput) {
           System.out.print("Hoe many cards to discard [0,3]: ");
           try {
              val = Integer.parseInt(in.nextLine());
  
              if (val < 0 || val > 3) {
                 System.out.println("Invalid input!");
              } else {
                 validInput = true;
              }
           } catch (Exception ex) {
              System.out.println("Invalid input!");
           }
        }
        return val;
     }
  
     private static String getCardsToDiscard(Scanner in, int numCardsToReplace, String playerHand) {
        final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
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

    private static int countOccurences(String cards, String string) {
        return 0;
    }

    private static int playPokerHand(Scanner in, int wallet, int minBet, int maxBet) {
        int bet = getWager(in, minBet, maxBet, wallet);

        String playerHand = "";
        String dealerHand = "";
        playerHand = getCard(playerHand) + "";
        playerHand += getCard(playerHand) + "";
        playerHand += getCard(playerHand) + "";

        dealerHand = getCard(playerHand + dealerHand) + " ";
        dealerHand += getCard(playerHand + dealerHand) + " ";
        dealerHand += getCard(playerHand + dealerHand) + " ";

        System.out.println(playerHand);
        System.out.println("XX XX XX");

        if(fold(in)) {
            wallet -= bet;
            return wallet;
        }
        bet += getWager(in, minBet, maxBet, wallet);
        playerHand = discard(in, playerHand);

        if (getWinner(playerHand, dealerHand) == PLAYER_WINS) {
            wallet += bet;
            System.out.println("Player wins! ");
        
        } else if (getWinner(playerHand, dealerHand) == DEALER_WINS) {
            wallet -= bet;
            System.out.println("Dealer wins! ");
        }else{
            System.out.println("TIE");
            return wallet;
            
        } else {
            System.out.println("TIE");
         }
         return wallet;
      }

        

    private static int getWinner(String playerHand, String dealerHand) {
        if (getHandValue(playerHand) > getHandValue(dealerHand))
         return PLAYER_WINS;
      else if (getHandValue(playerHand) < getHandValue(dealerHand))
         return DEALER_WINS;
      else if (getHighCard(playerHand) > getHighCard(dealerHand))
         return PLAYER_WINS;
      else if (getHighCard(playerHand) < getHighCard(dealerHand))
         return DEALER_WINS;
      else
         return TIE;
   }

   private static int getHighCard(String cards) {
      return 0;
   }

   private static int getHandValue(String cards) {
      if (isFlush(cards) && isStraight(cards))
        return STRAIGHT_FLUSH;
    else if (isFlush(cards))
        return FLUSH;
    else if (isStraight(cards))
        return STRAIGHT;
    else if (isThreeOfAKind(cards))
        return THREE_OF_A_KIND;
    else if(isPair(cards))
        return PAIR;
    else 
        return HIGH_CARD;
        
}

   private static boolean isPair(String cards) {
    return false;
}

private static boolean isThreeOfAKind(String cards) {
    
}

private static boolean isStraight(String cards) {
    return false;
}

private static boolean isFlush(String cards) {
    return false;
}

private static boolean fold(Scanner in) {
      boolean validInput = false;

      while (!validInput) {
         System.out.print("Do you want to [F]old or [D]iscard: ");
         String answer = in.nextLine().toUpperCase();
         if (answer.equals("FOLD") || answer.equals("F"))
            return true;
         else if (answer.equals("DISCARD") || answer.equals("D")) {
            return false;
         } else {
            System.out.println("Invalid Input: Fold or Discard only!");
         }
      }

      return false;
   }

    private static String getCard(String usedCards ) {
        String card = getFace() + getSuit();

        while(usedCards.indexOf(card) >= 0) {
            card = getFace() + getSuit();
        }
        return card;
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

    private static int getWager(Scanner in, int minBet, int maxBet, int wallet) {
        boolean validInput = false;
        int bet = 0;

        while(!validInput) {
            System.out.println("Please enter a bet [$" + minBet + " - $" + maxBet + "]: ");
        try{
            bet = Integer.parseInt(in.nextLine());

            if (bet > wallet)
                System.out.println("You only have $" + wallet);
            else if (bet > maxBet ||  bet < minBet)
                System.out.println("Your bet must be between [$" + minBet + " - $" + maxBet + "]");
            else
                validInput = true;
        }catch(Exception ex){
            System.out.println("Invalid Input! ");
        

        }
    

    }
    return bet;
    
    }
}
