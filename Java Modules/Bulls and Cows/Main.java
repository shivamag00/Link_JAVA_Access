
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String code;
    public static Scanner scan = new Scanner(System.in);
    public static int symbols;

    public static void main(String[] args) {
        System.out.println("Please, enter the secret code's length:");
        int codeLength;
        String input = scan.nextLine();
        try {
            codeLength = Integer.parseInt(input);
            code = generator(codeLength);    //generate code word
            if (code == null ) {
                return;
            }

            boolean isWrong = true;

            while (isWrong) {
                input = scan.next();
                isWrong = grader(input);    //grade users input
            }

            System.out.println("Congratulations! You guessed the secret code.");
        }
        catch (NumberFormatException e) {
            System.out.println("Error: " + input + " isn't a valid number.");
        }
    }

    public static String generator(int length) {
        int count = 0;
        int[] uniqueNumbers;
        System.out.println("Input the number of possible symbols in the code:");
        symbols = scan.nextInt();
        if (symbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return null;
        }

        StringBuilder pseudoRandomNumber = new StringBuilder();
        int randomNumber;

        if (length > symbols || length == 0) {
            System.out.println("Error: it's not possible to generate a code with a length of " + length + " with " + symbols + " unique symbols.");
            return null;
        }

        // Generating random code using Random Class
        uniqueNumbers = new int[symbols];
        Random random = new Random();

        while (count != length) {
            randomNumber = random.nextInt(symbols);
            if (uniqueNumbers[randomNumber] == 0) {
                if (randomNumber < 10) {
                    pseudoRandomNumber.append(randomNumber);
                }
                else {
                    pseudoRandomNumber.append((char)(randomNumber+87));
                }
                uniqueNumbers[randomNumber] = 1;
                count++;
            }
            if (count == length) {
                break;
            }
        }
        System.out.print("The secret is prepared: ");
        for (int i = 0; i<length;i++) {
            System.out.print("*");
        }
        System.out.print(" (0-");
        if (symbols > 10) {
            System.out.print("9, ");
            System.out.print("a-"+(char)(symbols+86)+").");
        }
        else {
            System.out.print(symbols-1+").");
        }
        System.out.println();

        return pseudoRandomNumber.toString();







//        //Generating random code using System.nantime()
//        while (count != length) {
//            uniqueNumbers = new int[10];
//            pseudoRandomNumber = new StringBuilder(String.valueOf(System.nanoTime()));
//            pseudoRandomNumber.reverse();
//            pseudoNumberLength = pseudoRandomNumber.length();
//
//            for (int i = 0; i < pseudoNumberLength; i++) {
//                if (count == 0 && pseudoRandomNumber.charAt(i) == '0') {
//                    continue;
//                } else if (uniqueNumbers[pseudoRandomNumber.charAt(i) - '0'] == 0) {
//                    pseudoRandomNumber.append(pseudoRandomNumber.charAt(i));
//                    uniqueNumbers[pseudoRandomNumber.charAt(i) - '0'] = 1;
//                    count++;
//                }
//                if (count == length) {
//                    break;
//                }
//            }
//        }

//        pseudoRandomNumber.delete(0, pseudoNumberLength);
//        return pseudoRandomNumber.toString();
    }

    public static boolean grader(String input) {
        int cows = 0, bulls =0;
        int[] status = new int[code.length()];
        for (int i = 0; i < input.length(); i++) {
            //counting bulls
            if (input.charAt(i) == code.charAt(i)) {
                bulls++;
                status[i] = 1;
                continue;
            }

            //counting cows
            for (int j = 0; j < code.length(); j++) {
                if (input.charAt(i) == code.charAt(j) && status[j] != 1) {
                    cows++;
                    status[j] = 1;
                    break;
                }
            }
        }

        if (bulls == 0 && cows == 0 ) {
            System.out.print("Grade: None");
        }
        else {
            System.out.print("Grade:");
            if (bulls == 1) {
                System.out.printf(" %d bull",bulls);
            }
            else if (bulls > 1) {
                System.out.printf(" %d bulls",bulls);
            }

            if (bulls > 0 && cows > 0) {
                System.out.print(" and");
            }

            if (cows == 1 ) {
                System.out.printf(" %d cow",cows);
            }
            if (cows > 1) {
                System.out.printf(" %d cows", bulls, cows);
            }
        }
        System.out.println(".");

        if (bulls == code.length()) {
            return false;
        }
        else {
            return true;
        }
    }
}
