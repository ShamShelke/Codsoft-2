import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerRange = 1;
        int upperRange = 100;
        int maxAttempts = 10;
        int totalRounds = 0;
        int totalAttempts = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (true) {
            int secretNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int attempts = 0;
            
            System.out.println("Guess the number between " + lowerRange + " and " + upperRange + ": ");
            
            while (attempts < maxAttempts) {
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == secretNumber) {
                    System.out.println("Congratulations! You've guessed the number " + secretNumber + " in " + attempts + " attempts.");
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }
            
            totalAttempts += attempts;
            totalRounds++;
            
            if (attempts >= maxAttempts) {
                System.out.println("Out of attempts! The number was " + secretNumber + ".");
            }
            
            System.out.println("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        
        double averageAttemptsPerRound = totalAttempts / (double) totalRounds;
        System.out.println("Thank you for playing! You played " + totalRounds + " rounds and your average attempts per round was " + averageAttemptsPerRound + ".");
        
        scanner.close();
    }
}
