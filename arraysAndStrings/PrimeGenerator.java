package arraysAndStrings;

import java.util.ArrayList;

//Segmented Sieves
public class PrimeGenerator {
	public static void primes(int m, int n, ArrayList<Integer> sieves) {
		boolean[] prime = new boolean[(n-m) + 1];
//		System.out.println(prime.length);
		for (int i = 0; i < prime.length; i++) {
			prime[i] = true;
		}
		int diff = 0;
		for (int sieve : sieves) {
			for (int i = 0; i+m <= n; i++) {
				if (((i+m) % sieve) == 0) {
					if ((i+m) != sieve) {
						prime[i] = false;
					}
				}
//				if (i % sieve == 0) {
//					if (i != sieve) {
//						diff = i - m;
//						break;
//					}
//				}
			}
//			for (int j = diff; j < prime.length; j+=sieve) {
//				prime[j] = false;
//			}
		}
		
		for (int i = 0; i < prime.length; i++) {
			if (prime[i] == true) {
				if (i+m > 1) {
					System.out.print(i+m + " ");
				}
			}
		}
	}
	public static ArrayList<Integer> sieves(int size) {
		boolean[] prime = new boolean[size+1];
		for (int i = 2; i*i <= size; i++) {    //Sieves
			if (prime[i] == false) {
				for (int j = 2; i*j <= size; j++) {
					prime[i*j] = true;
				}
			}
		}
		ArrayList<Integer> sieves = new ArrayList<Integer>();
		for (int i = 2; i < prime.length; i++) {
			if (prime[i] == false) {
				sieves.add(i);
			}
		}
		return sieves;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 1;
		int n = 10;
		ArrayList<Integer> sieves = sieves((int) Math.sqrt(n));
		System.out.println(sieves);
		primes(m, n, sieves);
	}

}
