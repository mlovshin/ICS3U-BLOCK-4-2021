package week6;

public class ComparingObjects {
    public static void main(String[] args) {
        // when comparing String we NEVER EVER EVER use == in Java

        // Why? 
        // If we don't instantiate an object, then the variable stores NULL
        // Otherwise, the variable stores the adress of the actual object

        //Why?
        // When you use == you are comparing what is stored in the variable
        // Two objects can have the same attributes but not the same location(in memor where the object is stored).
        
        // Equals method checks the sequence of the characters in the two objects

        String s1 = new String("Hello"); 
        String s2 = new String("Hello"); 

        System.out.println(s1.equals(s2));

        // whatever is on the other left of the . is this (s1)

        String str1 = "ABCD";
        String str2 = "BCD";

        // System.out.println(str1.compareTo(str2));
        System.out.println("A".compareTo("a"));

        // if they equal, they both return equal
        // if ("") is bigger than "".compareTo than
        // if "".compareTo is bigger than ("");
        
    }
    
}


