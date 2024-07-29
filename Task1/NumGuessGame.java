package Task1;

import java.util.Scanner;

public class NumGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
     
        
       
        int maxAttempts = 5;
       
        
        boolean playAgain = true;
        int totalScore = 0;
        int roundsWon = 0;
        int totalRounds = 0;
        
        while (playAgain) {
            totalRounds++;
            int numberToGuess = (int)(Math.random()*100)+1;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("\nRound " + totalRounds);
           
            System.out.println("You have " + maxAttempts + " attempts to guess it.");
            
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    int roundScore = (maxAttempts - attempts + 1) * 20;
                    totalScore += roundScore;
                    System.out.println("You scored " + roundScore + " points this round!");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                
                if (!guessedCorrectly && attempts == maxAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
                    System.out.println("No points awarded this round.");
                }
            }
            
            System.out.println("\nCurrent Statistics:");
            System.out.println("Total Score: " + totalScore);
            System.out.println("Rounds Won: " + roundsWon + "/" + totalRounds);
            System.out.println("Win Rate: " + String.format("%.2f%%", (double)roundsWon / totalRounds * 100));
            
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes") || playAgainResponse.equals("y");
        }}}
        
