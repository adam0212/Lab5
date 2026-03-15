import java.util.Scanner;
/**
 * FallingDistance Description
 * 1) Takes an integer input of the number of seconds of falling
 * 2) calculates and displays the distance an object falls for every second up to the amount of time of the input using getDistance
 *
 *  @author Adam Shaheen, adamhshaheen@gmail.com
 * @version v1.0
 * @since 3/11/2026
 */
public class FallingDistance{
    public static final double ACCELERATION = 9.8;
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double distance;
        int numOfSecs;

        System.out.println("Please enter how many seconds to compute: ");
        numOfSecs = keyboard.nextInt();
        System.out.println("Time(secs)  Distance(m)");
        System.out.println("=========   ==========");

        for(int i = 0 ; i<= numOfSecs; i++){
            System.out.printf( i + "           %.1f", getDistance(i));
            System.out.println("");
        }   
    }

    /**
     * getDistance description 
     * 1) calculates distance based on the int time using the formula for distance fallen
     * 
     * @param int time is how long the object was falling
     * @return double dist which is how far the object fell based on time
     */

    public static double getDistance(int time){
        double dist;
        dist = 0.5*ACCELERATION*time*time;
        return dist;
    }
}
