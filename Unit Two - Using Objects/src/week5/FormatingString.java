package week5;

public class FormatingString {
    public static void main(String[] args) {
        // 5:7.345 - wrong format
        // 5:07.345 - proper format

        int minutes = 5;
        double seconds = 7.5;

        // System.out.println(minutes + ":" + seconds);

    

        //placeholder
        // %d -> placeholder for integers
        // %s -> placeholder for Strings
        // %f -> placeholder for double
        System.out.printf("%d:%06.3f", minutes, seconds); // .2 is to move the decimal place 2, change any number
    }
    
}
