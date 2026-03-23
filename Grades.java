import java.io.*;
import java.util.Scanner;

/**
 * Grades Description
 * 1) promprts user for an input file and output file using getInFile and getOutFile
 * 2) processFile reads input file, determined how many of each letter grade in each set of grades and the min, max, and average of each set
 * 3) adds the following information to output file
 *
 *  @author Adam Shaheen, adamhshaheen@gmail.com
 * @version v1.1
 * @since 3/22/2026
 */
public class Grades{
    public static void main (String[] args) throws IOException{
        String inFile, outFile;
        inFile = getInFile();
        outFile = getOutFile();
        processFile(inFile, outFile);
    }

    /**
     * Uses Scanner to get and return input file name
     * @return name of file from Scanner
     */
    public static String getInFile() throws IOException{
        String out, updated;
        boolean check;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the name of the input file (ie input.txt):");
        out = keyboard.nextLine();
        File entered = new File(out);

        check = entered.exists();
        while(check == false){
            System.out.println("File does not exist, enter the name of another input file (ie input.txt):");
            out = keyboard.nextLine();
            entered = new File(out);
            check = entered.exists();
        }
        return out;
    }

    /**
     * Uses scanner to get and return output file name
     * @return name of the file from scanner
     */
    public static String getOutFile(){
        //create a method to generate and return a String for the output file name.
        //Create a Scanner object tied to System.in (ie keyboard)
        Scanner keyboard = new Scanner(System.in);
        //Message to user
        System.out.println("Enter the name of the output file (ie output.txt):");
        return keyboard.nextLine();
    }

    /**
     * opens input file and output file
     * determines how many of each letter grade in each set of grades and the min, max, and average of each set from input file
     * adds the graded information to output file
     * closes both files
     * @param inp is the name of the input file
     * @param outp is the name of the input file
     */
    public static void processFile(String inp, String outp) throws IOException{
        ////vars section
        int number, as, bs, cs, ds, fs, min, max, total, count, set = 1;
        double avg;
        File inputFile = new File(inp);
        Scanner keyboard = new Scanner(inputFile);
        PrintWriter writer = new PrintWriter(outp);
        while(keyboard.hasNextInt()){
            as=bs=cs=ds=fs=count=total=0;
            avg = 0.0;
            number = keyboard.nextInt();
            min=max=number;

            if(number ==-1){
                writer.println("Set " + set + " of grades calculated");
                writer.println("No grades to average.");
                writer.print("\n");
                set += 1;
            }
            else{
                while(number != -1){
                    if(number<min){
                        min = number;
                    }
                    if(number>max){
                        max = number;

                    }
                    total +=number;
                    count +=1;

                    if(number>=90){
                        as++;
                    }
                    else if (number>=80){
                        bs++;
                    }
                    else if (number>=70){
                        cs++;
                    }
                    else if (number>=60){
                        ds++;
                    }
                    else{
                        fs++;
                    }
                    number = keyboard.nextInt();
                }
                writer.println("Set " + set + " of grades calculated");
                set += 1;

                writer.println("Number of As: " + as);
                writer.println("Number of Bs: " + bs);
                writer.println("Number of Cs: " + cs);
                writer.println("Number of Ds: " + ds);
                writer.println("Number of Fs: " + fs);
                writer.println("The high score was: " + max);
                writer.println("The low score was: " + min);
                avg = (double)total/count;
                writer.printf("The avg score is: %.1f", avg);
                writer.println("\n");
            }
        }
        System.out.println("Grade processing is completed");
        System.out.println("You can retrieve the output file at, " + outp);

        keyboard.close();
        writer.close();
    }
}
