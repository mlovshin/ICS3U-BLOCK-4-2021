package week6;

public class ForLoop {
    public static void main(String[] args){
        exampleOne();
    }
    public static void exampleOne() {
    

        Object j;
        for (int i = 0; j = 0; i <= 100; i+= 2, j -= 2) {        // starting from; checks the condition; adds the increment
            System.out.println(i);
        }
    }
    public static void test() {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;

        while(playAgain){
            System.out.println("Game is playing...");
            System.out.println("Game is over");

            System.out.print("Do you want to play again: ");
            playAgain= in.nextLine().equals("Yes");

        }
        System.out.println("Bye");
    }

    private static int getNumber() {
        boolean validInput = false;
        System.out.println("Please print a number [1,10]: ");
        while (!validInput) {
            String input = in.nextLine();

            try
                int result = Integer.parseInt(Input);
            if (result >=1 && result <= 10)
                return result;
            else {
                System.out.print("Only ");
            }

            }catch(Exception ex){}

        }
    }
}
