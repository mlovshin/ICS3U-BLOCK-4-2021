package week7;

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
    
    private static String distributeCards() {
        String playerHand = "" + getCard() + "" + getCard() + "" + getCard() + "" + getCard() + "" + getCard();
            System.out.println("The player's hand is: " + playerHand);
        return playerHand;
    }
    
  
    private static String playRound() {
        System.out.println("Let's start game!");
        String playerHand = "";
        String c1Hand = "";
        String c2Hand = "";
  
        String topCard = "";
  
        String temp = processPlayer(playerHand, topCard, 0);
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

     private static String processPlayer(String playerHand, String topCard, int hand) {
    
        while (!canPlay(hand, getSuit(topCard), getRank(topCard), getCard(topCard), hand < 6))
            if(!topCard.equals(playerHand)) {
                hand++;
            }
        while (canPlay(hand, getSuit(topCard), getRank(topCard), getCard(topCard), hand = 5))
                if(topCard.equals(playerHand)) {
                    return playerHand;
                }
        
        System.out.println("The top card is: " + topCard);
        return topCard;
    }

    private static String processComputer(String c1Hand, String topCard, String playerHand, String c2Hand) {
        return null;
    }
  
     private static boolean canPlay(Object hand, Object suit, Object rank, Object card, Object object) {
        return false;
    }


    private static Object getCard(String topCard) {
        return null;
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
    
    