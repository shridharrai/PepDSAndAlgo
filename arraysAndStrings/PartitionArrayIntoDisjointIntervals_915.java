package arraysAndStrings;

public class PartitionArrayIntoDisjointIntervals_915 {
	//O(n)
	public static int partitionDisjoint(int[] A) {
		int cmax = A[0];
		int ans = 0;
		int nextmax = A[0];
		
		for (int i = 1; i < A.length; i++) {
			if (A[i] < cmax) {
				ans = i;
				cmax = Math.max(cmax, nextmax);
			} else {
				nextmax = Math.max(nextmax, A[i]);
			}
		}
		return ans+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,0,6,12};
		System.out.println(partitionDisjoint(arr));
	}

}
