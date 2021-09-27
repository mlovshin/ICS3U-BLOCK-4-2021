package week2;

public class StringExamples {
public static void main(String[] args) {
    String s1 = "Max";   // string literal is in ""
    String s2 = "Fred"; // String literal is in ""
    String s3 = "Max"; 
    String s4 = new String("Kyle"); //string literal is in ""
    String s5 = new String ("Max");


    System.out.println(s1.length());    //length returns the number of characters n in the string

    System.out.println(s1.equals(s5));  // true - same sequence of the characters 
    System.out.println(s1.equals("max"));   // false - ( m and M are not the same) Use proper capitalization
    
    System.out.println("Brad" .indexOf("ra"));  // index of ra in Brad is 1
    System.out.println(s2.indexOf("Red"));  //Red is not in Fred so returns -1
    
    String x = "ABCDEF";

    System.out.println(x.substring(2));
    System.out.println(x.substring(2, 4));  // starts index 2 to 4 but not including 4
    System.out.println("Friday" .substring(1, "Friday" .length());     // 



    


    
}
    
}
