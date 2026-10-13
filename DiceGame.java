/*
* The DiceGame program generates a random number between 1 and 6
* and prompts the user to guess it. It handles invalid inputs safely
* and tracks total attempts.
*
* @author Sarah O
* @version 1.0
* @since 2026-10-12
*/

import java.util.Random;
import java.util.Scanner;

public final class DiceGame {

    /**
     * Private constructor to prevent instantiation.
     */
    private DiceGame() {
       // Prevent utility class instantiation
    }

    /**
     * Main entry point for the Dice Game application.
     *
     * @param args Command line arguments (unused).
     */
    public static void main(final String[] args) { // Main method to run the Dice Game
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();

        // Generate random number between 1 and 6
        final int targetNumber = random.nextInt(6) + 1; // Random number between 1 and 6
        int guessCount = 0; // Counter for number of guesses    
        int userGuess = 0; // Variable to store user's guess

        System.out.println("Welcome to the Guessing Game!"); 

        // Loop until user guesses correctly
        do {
            System.out.print("Guess a number between 1 and 6: ");
            final String input = scanner.nextLine();

            try {
                userGuess = Integer.parseInt(input);

                // Check range validity
                if (userGuess < 1 || userGuess > 6) {
                    System.out.println("Invalid input! Number must be between 1 and 6.");
                } else {
                    guessCount++;

                    // Compare guess to target
                    if (userGuess < targetNumber) {
                        System.out.println("Too low! Try again.");
                    } else if (userGuess > targetNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("You got it right!");
                        System.out.println("It took you " + guessCount + " try/tries.");
                    }
                }
            } catch (NumberFormatException e) { // Handle non-integer input
                System.out.println("Invalid input! Please enter a valid integer.");
            }

        } while (userGuess != targetNumber); // Continue until the correct guess is made

        scanner.close();
    }
}