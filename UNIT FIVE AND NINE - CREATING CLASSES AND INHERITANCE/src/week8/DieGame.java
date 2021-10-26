package week8;

public class DieGame {
    public static void main(String[] args) {
        Die die1 = new Die();
        Die die2 = new Die();
        //die1.numsides = 7; not possible because it is outside the class
        
        int countPairs = 0;

        for (int i = 0; i < 100; i++){
            die1.roll();
            die2.roll();

            System.out.println(die1.getTopSide() + " " + die2.getTopSide());
                countPairs++;
        }
}
