import java.util.Scanner;
/**
 * Prime Description
 * 1) Takes in a positive integer from the user
 * 2) Tests if the integer is prime using method isPrime and displays the result
 * 3) Gives the user the option to test another number
 *
 * @author Adam Shaheen, adamhshaheen@gmail.com
 * @version v1.0
 * @since 3/11/2026
 */
public class Prime{
    public static void main (String[] args) {
        boolean isPrime, again;
        int number;

        Scanner keyboard = new Scanner(System.in);
        String playAgain, playLow;
        do{ 
            System.out.print("Enter a whole number>2 (ie 19) to test if prime: ");
            number = keyboard.nextInt();
            isPrime = testForPrime(number);
            System.out.print("");

            if(isPrime){
                System.out.println(number + " is prime");
            }
            else{
                System.out.println(number + " is not prime");
            }
            System.out.print("Enter yes to test another number, no to quit. ");
            playAgain = keyboard.next();
            playLow = playAgain.toLowerCase();
            System.out.print("");
        } while (playLow.equals("yes"));
    }

    /**
     * isPrime description
     * 1) Takes the square root of the parameter
     * 2) Tests if number is divisible by any number less than or equal to its square root to see if its prime
     * @param int num is a positive integer that is  tested to see if it is prime
     * @return boolean isPrimeMeth is true when num is a prime and is false when num isn't a prime
     */

    public static boolean testForPrime(int num){

        int inNumberSqRt = (int)Math.sqrt(num);
        boolean isPrimeMeth = true;

        for(int i=2;isPrimeMeth&&i<=inNumberSqRt;i++){
            if(num%i==0){
                isPrimeMeth = false;
            }
        }
        return isPrimeMeth;
    }
}