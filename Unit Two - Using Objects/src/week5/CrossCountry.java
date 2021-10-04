package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        processRunner(in);
        processRunner(in);
        processRunner(in);
        in.close();
    }

    private static void processRunner(Scanner in) {
        String firstName, lastName;
        String mileOne, mileTwo, finish;
        String splitTwo, splitThree;

        /**
         * get the first and last name of the runner
         * get the mileOne, mileTwo and finish times for the runner
         */

         splitTwo = substractTime(mileTwo, mileOne);
         splitThree = substractTime(finish, mileOne);

         /**
          * Display a summary for the runner
          */


    }

    private static String substractTime(String endTime, String startTime) {
        double endTimeInSeconds = convertToSeconds(endTime);
        double startTimeInSeconds = convertToSeconds(startTime);

    
        double diffInSeconds = endTimeInSeconds - startTimeInSeconds;

        return convertToSeconds(diffInSeconds);

    }

    private static double convertToSeconds(String endTime) {
        return 0;
    }
    
}

/**
 * @param endTime
 * @param startTime
 * @return 
 */