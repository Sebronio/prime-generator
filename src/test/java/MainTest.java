import org.apache.commons.math3.primes.Primes;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    private final Main primeGenerator = new Main();

    @Test
    public void testSinglePrimeGeneration() {
        int generatedPrime = primeGenerator.generatePrime();
        Assert.assertTrue(Primes.isPrime(generatedPrime));
    }
}
