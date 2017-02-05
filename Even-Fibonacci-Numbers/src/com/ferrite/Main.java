package com.ferrite;

public class Main {
	private static double GOLDEN_RATIO = (1. + Math.sqrt(5)) * 0.5;

	public static void main(String[] args) {
		System.out.println("Start...");
		System.out.println("Long.MAX_VALUE: " + Long.MAX_VALUE);
		System.out.println("Calculation method.");

		long beginTime = System.nanoTime();
		long limit = 1_000_000L;

		long n = calcNthFibonacciElement(limit);

		long sum = (fibonacci(n + 2L) - 1L) / 2L;

		System.out.println(String.format("Time: %.3f [ms]", (System.nanoTime() - beginTime) / 1_000_000.));
		System.out.println("n-th: " + n);
		System.out.println("Sum: " + sum);

		System.out.println("Iteration method.");

		beginTime = System.nanoTime();

		sum = 0L;
		long p1 = 0L, p2 = 1L;
		long i;
		for (; (i = p1 + p2) < limit; p1 = p2, p2 = i) {
			if (i % 2 == 0) {
				sum += i;
			}
		}

		System.out.println(String.format("Time: %.3f [ms]", (System.nanoTime() - beginTime) / 1_000_000.));
		System.out.println("i: " + i);
		System.out.println("Sum: " + sum);

		System.out.println("End.");

	}

	private static long fibonacci(long n) {
		return ((long) ((Math.pow(GOLDEN_RATIO, n) - Math.pow(GOLDEN_RATIO, -n)) / (2. * GOLDEN_RATIO - 1.) - 1)) / 3
				* 3;
	}

	private static long calcNthFibonacciElement(long limit) {
		return (long) ((Math.log(limit * Math.sqrt(5) + 0.5)) / (Math.log(GOLDEN_RATIO)));
	}

}
