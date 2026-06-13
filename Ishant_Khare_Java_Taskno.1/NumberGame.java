package Task1_NumberGame;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int roundsPlayed = 0;
        int roundsWon = 0;
        int totalScore = 0;
        
        System.out.println("=========================================");
        System.out.println("       WELCOME TO THE NUMBER GAME!       ");
        System.out.println("=========================================");
        System.out.println("I'm thinking of a number between 1 and 100.");
        
        boolean playAgain = true;
        while (playAgain) {
            roundsPlayed++;
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 7;
            boolean guessedCorrectly = false;
            
            System.out.println("\n--- Round " + roundsPlayed + " ---");
            System.out.println("You have " + attemptsLeft + " attempts to guess the number.");
            
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (1-100): ");
                int userGuess;
                
                if (scanner.hasNextInt()) {
                    userGuess = scanner.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                    continue;
                }
                
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please guess a number between 1 and 100.");
                    continue;
                }
                
                attemptsLeft--;
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    guessedCorrectly = true;
                    roundsWon++;
                    int roundScore = (attemptsLeft + 1) * 10;
                    totalScore += roundScore;
                    System.out.println("Round won! You earned " + roundScore + " points.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("Too high! Attempts left: " + attemptsLeft);
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("\nGame over for this round! The correct number was: " + numberToGuess);
            }
            
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
        }
        
        System.out.println("\n=========================================");
        System.out.println("               GAME OVER!                ");
        System.out.println("=========================================");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Total Score: " + totalScore + " points");
        System.out.println("Thank you for playing!");
        System.out.println("=========================================");
        
        scanner.close();
    }
}
