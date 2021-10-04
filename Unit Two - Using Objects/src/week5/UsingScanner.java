package week5;

import java.util.Scanner;

public class UsingScanner {
    public static void main(String[] args) {    // 
        Scanner in = new Scanner(System.in);    // System.in is the input device
            // exampleOne();

    }

    private static void exampleTwo(Scanner in) {
        System.out.print("Please enter a number:  ");
        // double num = int.nextDouble();

        double num = 0; // an exception 
        
        boolean validInput = false;


    while(validInput == false){
        try{

        num = Double.parseDouble(in.nextLine());
        validInput = true;
        }catch(Exception ex){
            System.out.print("Invalid input!!! Please enter a number: ");
        }

        double result = Math.pow(num, 2);   // static because it belongs to Math class, static 
        System.out.println(result);
        }

    }

    private static void exampleOne(Scanner in) {
        System.out.print("Please enter your name: ");
        String name = in.nextLine();    // the in.nextLine gives you everything till that key

        System.out.println("Hello " + name);

        in.close();
    }
    
}
