import java.util.List;

import org.apache.commons.math3.primes.Primes;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    private final Main primeGenerator = new Main();

    @Test
    public void testSinglePrimeGeneration() {
        int generatedPrime = primeGenerator.generatePrime();
        Assert.assertTrue("Generated number is not prime", Primes.isPrime(generatedPrime));
    }

    @Test
    public void testRandomPrimeGeneration() {
        // Define the number of random primes to generate for testing
        int numberOfPrimes = 5; // This can be varied or parameterized if needed

        // Generate random primes
        List<Integer> randomPrimes = primeGenerator.generateRandomPrimes(numberOfPrimes);

        // Check that the number of primes generated is correct
        Assert.assertEquals("The number of random primes generated is incorrect", numberOfPrimes, randomPrimes.size());

        // Check that each generated number is a prime number
        for (int prime : randomPrimes) {
            Assert.assertTrue("Generated number " + prime + " is not prime", Primes.isPrime(prime));
        }
    }

    @Test
    public void testRandomPrimeGenerationWithEdgeCase() {
        // Edge case: Generate 1 prime number
        List<Integer> randomPrimes = primeGenerator.generateRandomPrimes(1);
        Assert.assertEquals("The number of random primes generated is incorrect", 1, randomPrimes.size());
        Assert.assertTrue("Generated number is not prime", Primes.isPrime(randomPrimes.get(0)));
    }
}