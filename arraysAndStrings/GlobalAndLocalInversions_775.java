package arraysAndStrings;

public class GlobalAndLocalInversions_775 {
	public static boolean isIdealPermutation(int[] A) {
		for (int i = 0; i < A.length; i++) {
			if (Math.abs(A[i]-i) >= 2) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,0}; 
		System.out.println(isIdealPermutation(arr));
	}

}
