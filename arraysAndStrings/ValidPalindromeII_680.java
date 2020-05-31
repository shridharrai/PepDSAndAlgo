package arraysAndStrings;

public class ValidPalindromeII_680 {
	//O(n)
	public static boolean validPalindrome(String s) {
		int i = 0;
		int j = s.length()-1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				--j;
			} else {
				if (isPalindrome(s, i+1, j)) {
					return true;
				}
				else if (isPalindrome(s, i, j-1)) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				--end;
			} else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abca";
		System.out.println(validPalindrome(s));
	}

}
