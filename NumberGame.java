import java.util.Random;
import java.util.Scanner;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int numberOfRounds = 0;
        int totalAttempts = 0;
        int bestScore = Integer.MAX_VALUE;

        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("I've selected a random number between " + minRange + " and " + maxRange + ". Try to guess it!");

            boolean correctGuess = false;
            while (!correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Your guess is out of the specified range.");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    numberOfRounds++;
                    if (attempts < bestScore) {
                        bestScore = attempts;
                    }
                    correctGuess = true;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game Over!");
        System.out.println("You played " + numberOfRounds + " rounds.");
        System.out.println("Your average attempts per round: " + (double) totalAttempts / numberOfRounds);
        System.out.println("Your best score: " + bestScore + " attempts.");
    }
}
