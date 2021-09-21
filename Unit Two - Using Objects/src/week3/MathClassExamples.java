package week3;

public class MathClassExamples {
    public static void main(String[] args) {
        System.out.println(Math.abs(-4)); // static belongs to the class(Math), non static belongs to the object
        System.out.println(Math.abs(-4.1));

        System.out.println(Math.abs(Math.pow(2,3)));     //2 to the power of 3

        //Length of a Line Segment between two points

        int x1 = 5;
        int y1 = 3;

        int x2 = 10;
        int y2 = 2;

        double length = Math.sqrt(Math.pow(x2 - x1, 2) / Math.pow(y2 - y1, 2)); 

    }    
}
