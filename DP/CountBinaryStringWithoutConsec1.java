package DP;

public class CountBinaryStringWithoutConsec1 {
	public static int countBinaryStrings(int n) {
		int end0 = 1;
		int end1 = 1;
		for (int i = 2; i <= n; i++) {
			int temp = end0;
			end0 = end1 + end0;
			end1 = temp;
		}
		return end0 + end1;
	}
	
	public static void main(String[] args) {
		System.out.println("Number of binary strings are "+countBinaryStrings(6));
	}
}
