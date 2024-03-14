import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 5;
        int score = 0;
        int rounds = 1;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");
        
        while (true) {
            System.out.println("Round " + rounds);
            int attempts = 0;
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                }
            }
            
            System.out.println("The correct number was: " + targetNumber);
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
            
            targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            rounds++;
        }
        
        System.out.println("Game over! Your total score is: " + score);
        scanner.close();
    }
}
