
import java.util.Random; // This import statement is necessary for generating random numbers
import java.util.Scanner; // This import statement is necessary to read the user's inputs

public class DiceGame { // This class is used to play a dice game where the user guesses a random number between 1 and 6
    public static void main(String[] args) { // This is the main method where the program starts execution

        Scanner scanner = new Scanner(System.in); // This creates a new Scanner object to read user input from the console
        Random random = new Random(); // This creates a new Random object to generate random numbers

        int trueGuess = random.nextInt(6) + 1; // This generates a random number between 1 and 6 (6 is included) and assigns it to the variable 'trueGuess'
        int guesses = 0; // This variable keeps track of the number of guesses the user has made

        System.out.println("Welcome to DiceGame!");
        System.out.println("Pick a number between 1 and 6:");

        int guess = 0;

        while (guess != trueGuess) {
            // Asks the user for a guess
            System.out.print("\nEnter your guess: ");
            String input = scanner.nextLine().trim();

            // Valid whole number from 1 to 6?
            int guessValue;
            try {
                guessValue = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid whole number!");
                continue; // Asks the user for a guess again without counting as a guess
            }

            if (guessValue < 1 || guessValue > 6) {
                System.out.println("Number must be from 1 to 6!");
                continue; // Asks the user for a guess again without counting as a guess
            }

            guess = guessValue;

            // guesses = guesses + 1
            guesses++;
            // guess == secret?
            if (guess == trueGuess) {
                System.out.println("You got it! It took " + guesses + " guesses");
            }
        }
        scanner.close();
    }
}
