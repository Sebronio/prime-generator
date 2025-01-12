import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public int generatePrime() {
        return generatePrimes(1).get(0);
    }

    private List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int number = 2;

        while (primes.size() < n) {
            if (isPrime(number)) {
                primes.add(number);
            }
            number++;
        }

        return primes;
    }

    // Generates 'n' random prime numbers
    public List<Integer> generateRandomPrimes(int n) {
        List<Integer> allPrimes = generatePrimes(1000); // Precompute a list of primes up to 1000
        List<Integer> randomPrimes = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int randomPrime = random.nextInt(allPrimes.size());
            randomPrimes.add(allPrimes.get(randomPrime));
        }

        return randomPrimes;
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String... args) {
        Main primeGenerator = new Main();
        Scanner scanner = new Scanner(System.in);

        int numberNeeded = 0;

        // Loop until the user enters a valid number between 1 and 50
        while (true) {
            System.out.print("How many random prime numbers do you want (1-50)? ");
            if (scanner.hasNextInt()) {
                numberNeeded = scanner.nextInt();
                if (numberNeeded >= 1 && numberNeeded <= 50) {
                    break; // Exit the loop if valid input is provided
                } else {
                    System.out.println("Please enter a number between 1 and 50.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume the invalid input
            }
        }

        // Generate and display the random primes
        List<Integer> randomPrimes = primeGenerator.generateRandomPrimes(numberNeeded);
        System.out.println("Random primes: " + randomPrimes);

    }

}