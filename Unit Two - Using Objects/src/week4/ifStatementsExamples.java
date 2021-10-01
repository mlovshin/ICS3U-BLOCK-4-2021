package week4;

public class ifStatementsExamples {
    public static void main(String[] args) {
        exampleOne();
        String LetterGrade = getLetterGrade(78);
        exampleThree();

        public static void exampleThree() {
            /**
             * >   less than
             * <   more than 
             * ==   equal to
             * >=   less than equal too
             * <==
             * !=   (not equal)
             * 
             * || or (x > 7) || (y > 7)         either are TRUE to be TRUE
             *  && AND (x > 7) || (y > 7)       either 
             */
        }

        
    }

    private static String getLetterGrade(int mark) {
        if (mark >= 90) {
            return "A+";
        }else if (mark >= 80) {
            return "A";
        }else if (mark >= 70) {
            return "B";
        }else if (mark >= 60) {
            return "C";
        }else if (mark >= 50) {
            return "D";
        }else {
            return "F"; 
        }

        }


    private static void exampleOne() {  // return type before the class
        int x = 7;

        if (x % 2 == 0) {
            System.out.println( x + " is even.");   // can't put it down because (x % 2) is not even, so it's false, so it can't print that it's even

        }else // want to do something else if it's false
        System.out.println( x + " is odd.");

        /**
         * if (x % 2 == 1) {
         * }
         */
        if (x % 2 == 1) {
            System.out.println( x + " is odd."); // only to outputs, true or false

            // codingbat seeColor practice


            if (str.indexOf("red") ==0) {       // if index of red starts at 0( 0, 1, 2), then return red 
                return "red";                   
              }else if (str.indexOf("blue") ==0 ){      //if index of blue starts at 0(0, 1, 2, 3), then return blue
                return "blue";
              }else{
                return "";
              }

              // codingbat extraFront

              if (str.length() < 2){
                return str + str + str;
              }else {
                String newStr = str.substring(0,2);
                return newStr + newStr + newStr; 
              }

    }
    
}
