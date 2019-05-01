package prime;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Primes {

	public static void main(String[] args) {
		Long startInterval = 1000000000000000l;
//		Long startInterval = 3l;
		Long endInterval = startInterval + 1000;
		List<Long> primes1 = primesSequential(startInterval, endInterval);
		System.out.println(primes1);
		List<Long> primes2 = primesParallel(startInterval, endInterval);
		System.out.println(primes2);
	}
	
	private static List<Long> primesSequential(long from, long to) {
		long startTime = System.currentTimeMillis();
		List<Long> primes = LongStream.range(from, to)
				.filter(l -> isPrime(l))
				.boxed()
				.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		System.out.println("Sequential Time = " + (endTime-startTime));
		return primes;
	}
	
	private static List<Long> primesParallel(long from, long to) {
		long startTime = System.currentTimeMillis();
		List<Long> primes = LongStream.range(from, to)
				.parallel()
				.filter(l -> isPrime(l))
				.boxed()
				.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		System.out.println("Parallel Time = " + (endTime-startTime));
		return primes;
	}
	
	private static boolean isPrime(long candidate) {
		for (long l = 2; l * l <= candidate; l++) {
			if (candidate % l == 0) return false;
		}
		return true;
	}
	
}
