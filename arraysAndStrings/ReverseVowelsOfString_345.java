package arraysAndStrings;

public class ReverseVowelsOfString_345 {
	public static String reverseVowels(String s) {
//		StringBuilder sb = new StringBuilder(s);
		char[] arr = s.toCharArray();
		int i = 0;
		int j = arr.length-1;
		while (i < j) {
			while (!isVowel(arr[i]) && i < j) {
				i++;
			}
			while (!isVowel(arr[j]) && i < j) {
				--j;
			}
			char ch = arr[i];
			arr[i] = arr[j];
			arr[j] = ch;
			i++;
			--j;
		}
		return new String(arr);
	}
	
	public static boolean isVowel(char c) {
		if (c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'O' || c == 'o' || c == 'U' || c == 'u') {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		System.out.println(reverseVowels(s));
	}

}
