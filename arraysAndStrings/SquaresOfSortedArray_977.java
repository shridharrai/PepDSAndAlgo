package arraysAndStrings;

public class SquaresOfSortedArray_977 {
	//O(n)
	public static int[] sortedSquares(int[] A) {
		int[] sqr = new int[A.length];
		int i = 0;
		int j = A.length - 1;
		int k = A.length - 1;
		while (i <= j) {
			if (A[j]*A[j] > A[i]*A[i]) {
				sqr[k] = A[j]*A[j];
				j--;
				k--;
			} else {
				sqr[k] = A[i]*A[i];
				i++;
				k--;
			}
		}
		for (int k2 = 0; k2 < sqr.length; k2++) {
			System.out.print(sqr[k2] + " ");
		}
		return sqr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-4,-1,0,3,10};
		sortedSquares(arr);
	}	

}
