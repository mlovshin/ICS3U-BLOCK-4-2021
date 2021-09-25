package week3;

public class UnitTest {
    public static void main(String[] args) {


/** 
 * Write a function that acts a String and a integer. Return 3 copies of a substring of a length 2 at the specificed index. 
 * 
 * 
 * 
 */
// threeCopies("Happy", 2) => pp + pp + pp

 public static String  threecopies(String str, int index) {
     String s = str.substring(index, index + 2);
     return s + s + s;


public static String removeCharString
    String first = str.substring(0, index);
    String last = str.substring( index + 7);




     // ("computer science", 3, 4) // {where to start from is first num} go to the first index(3), and {where to take nums off} take 4 chars off(starting from value 3)
     // to find value to a number = index + the value of that character


     //7463
     public static double sqrtSum( int number);
     int n1 = number / 1000 % 10; // 7463 / 1000 = 7
     int n2 = number / 100 % 10; // 7463 / 100 = 74 % 10 = 4
     int n3 = number / 10 % 10; // 7463 / 10 = 746 % 10 = 6
     int n4 = number % 10; // 7463 % 10  = 3 

     int sum = n1 + n2 + n3 + n4;
     return Math.sqrt(sum);
     

 }
    }

    
}
