package week3;

public class Q6 {
    public static void main(String[] args) {
            String str = questionSix("This is a sentence. ", "ent");    //"This is a sence"


            private static String questionSix(String str, String substr) {

            int index = str.indexOf(substr);
            String first = str.substring(0, index);      // (beginIndex(0), endIndex to where you want to get the string from)
            String last = str.substring(index + substr.length());   // it starts a the index and skips all those characters (or string) "ent" and prints everything after
            System.out.println(str);
            
        }

}
    
    

