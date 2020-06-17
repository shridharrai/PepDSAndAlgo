package stackAndQueues;

public class BackspaceStringCompare_844 {
	public static boolean backspaceCompare(String S, String T) {
		int count = 0;
		int i = S.length() - 1;
		int j = T.length() - 1;
		
		while (i >= 0 && j >= 0) {
			while (i >= 0) {
				if (S.charAt(i) == '#') {
					count++;
				} else {
					if (count > 0) {
						count--;
					} else {
						break;
					}
				}
				i--;
			}
			
			while (j >= 0) {
				if (T.charAt(j) == '#') {
					count++;
				} else {
					if (count > 0) {
						count--;
					} else {
						break;
					}
				}
				j--;
			}
			
			if ((i >= 0 && j >= 0) && S.charAt(i) == T.charAt(j)) {
				--i;
				--j;
			}
			else {
				if (i >= 0 && j >= 0) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab##";
		String t = "c#d#";
		System.out.println(backspaceCompare(s, t));
	}

}
