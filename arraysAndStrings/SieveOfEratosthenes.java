package arraysAndStrings;

public class SieveOfEratosthenes {
	public static void primes(int n) {
		boolean[] prime = new boolean[n+1];
		for (int i = 2; i*i <= n; i++) {    //Sieves
			if (prime[i] == false) {
				for (int j = 2; i*j <= n; j++) {
					prime[i*j] = true;
				}
			}
		}
		for (int i = 2; i < prime.length; i++) {
			if (prime[i] == false) {
				System.out.print(i + " ");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		primes(50);
	}

}
