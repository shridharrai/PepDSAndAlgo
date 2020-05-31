package arraysAndStrings;

public class MinDominoRotationsForEqualRow_1007 {
	//O(n)
	public static int minDominoRotations(int[] A, int[] B) {
		int A1 = 0, A2 = 0, B1 = 0, B2 = 0;
		for (int i = 0; i < A.length; i++) {
			if (A1 != Integer.MAX_VALUE) {
			if (A[i] != A[0]) {
				if (B[i] == A[0]) {
					A1++;
				}
				else {
					A1 = Integer.MAX_VALUE;
				}
			}
			}
			if (A2 != Integer.MAX_VALUE) {
			if (A[i] != B[0]) {
				if (B[i] == B[0]) {
					A2++;
				}
				else {
					A2 = Integer.MAX_VALUE;
				}
			}
			}
		}
//		System.out.println("A1 "+A1 + " A2 "+A2);
		
		for (int i = 0; i < B.length; i++) {
			if (B1 != Integer.MAX_VALUE) {
				if (B[i] != A[0]) {
					if (A[i] == A[0]) {
						B1++;
					}
					else {
						B1 = Integer.MAX_VALUE;
					}
				}
			}
			if (B2 != Integer.MAX_VALUE) {
				if (B[i] != B[0]) {
					if (A[i] == B[0]) {
						B2++;
					}
					else {
						B2 = Integer.MAX_VALUE;
					}
				}
			}
		}
//		System.out.println("B1 "+B1 + " B2 "+B2);
		int temp1 = Math.min(A1, A2);
		int temp2 = Math.min(B1, B2);
		int min = Math.min(temp1, temp2);
		if (min == Integer.MAX_VALUE) {
			return -1;
		}
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,5,1,2,3};
		int[] B = {3,6,3,3,4};
		System.out.println(minDominoRotations(A, B));
	}

}
