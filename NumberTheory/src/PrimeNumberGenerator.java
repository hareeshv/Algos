import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator {

    //exclusive
    public List<Integer> generatePrimes(int range)
    {
        boolean []sieve =  new boolean[range];
        for (int i = 2; i <= Math.sqrt(range); i++)
        {
            if (!sieve[i]) {
                // mask all multiples of prime numbers.
                for (int j = i*2; j < range; j += i) {
                    sieve[j] = true;
                }
            }
        }

        List<Integer> primes = new ArrayList();
        //Collecting primes.
        for (int i = 2; i < range; i++) {
            if (!sieve[i])
                primes.add(i);
        };
        return primes;
    }

    public static void main(String []args)
    {
        PrimeNumberGenerator generator = new PrimeNumberGenerator();
        generator.generatePrimes(100).forEach(System.out::println);
    }
}
