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

        System.out.println("Please enter first name: ");
        firstName = in.nextLine();
        System.out.println("Please enter last name: ");
        lastName = in.nextLine();
        System.out.println("Please enter mile one time: "); 
        mileOne = in.nextLine();
        System.out.println("Please enter mile two time: ");
        mileTwo = in.nextLine();
        System.out.println("Please enter finish time: ");
        finish = in.nextLine();


         splitTwo = substractTime(mileTwo, mileOne);
         splitThree = substractTime(finish, mileOne);


         System.out.println("Please enter first name: " + firstName);
         System.out.println("Please enter last name: " + lastName);
         System.out.println("Please enter mile one time: " + mileOne);
         System.out.println("Please enter split two time: " + mileTwo);
         System.out.println("Please enter finishing time " + finish);



    }

    private static String substractTime(String endTime, String startTime) {
        double endTimeInSeconds = convertToSeconds(endTime);
        double startTimeInSeconds = convertToSeconds(startTime);

    
        double diffInSeconds = endTimeInSeconds - startTimeInSeconds;

        return convertToTime(diffInSeconds);

    }

    private static String convertToTime(double timeInSeconds) {
        int minutes = getMinutes(timeInSeconds);
        double seconds = getSeconds(timeInSeconds);


        return String.format("%d:%06.3f", minutes, seconds); 
    }

    private static double getSeconds(double timeInSeconds) {
        return timeInSeconds % 60;  // convert timeInSeconds to 
      
        // 334.221 => 34.221
    
    }

    private static int getMinutes(double timeInSeconds) {
        return (int)(timeInSeconds/60);
    
    }

    private static double convertToSeconds(String time) {
        String oneSeconds = time.substring(0, time.indexOf(":"));   // in minutes
        String twoSeconds = time.substring(time.indexOf(":" + 1));  // in seconds
        Double time1 = Double.parseDouble(oneSeconds)*60;   // convert to seconds  and times by 60
        Double time2 = Double.parseDouble(twoSeconds);   // to take the rest of twoSeconds and keep it in seconds

        Double finalTime = time1 + time2;   // add the oneSeconds(the minutes converted) to seconds to the twoSeconds to find the total time;
        return finalTime;


        // convert 5:34.221 to 334.221
        
    }
    
}

/**
 * @param endTime
 * @param startTime
 * @return 
 */



