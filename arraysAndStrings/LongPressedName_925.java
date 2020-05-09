package arraysAndStrings;

public class LongPressedName_925 {
	//O(n)
	public static boolean isLongPressedName(String name, String typed) {
		if (name.charAt(0) != typed.charAt(0)) {
			return false;
		}
		int i, j;
		for (i = 1, j = 1; i < name.length() && j < typed.length();) {
			if (name.charAt(i) == typed.charAt(j)) {
				i++;
				j++;
			} else {
				if (typed.charAt(j) == typed.charAt(j-1)) {
					j++;
				}
				else {
					return false;
				}
			}
		}
		
		if (i == name.length() && j == typed.length()) {
			return true;
		}
		if (j != typed.length()) {
			while (j < typed.length()) {
				if (typed.charAt(j) == typed.charAt(j-1)) {
					j++;
				} else {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "vtkgn";
		String typed = "vttkgnn";
		System.out.println(isLongPressedName(name, typed));
	}

}
