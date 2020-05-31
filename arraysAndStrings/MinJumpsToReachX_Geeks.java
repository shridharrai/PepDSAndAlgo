package arraysAndStrings;

public class MinJumpsToReachX_Geeks {
	//O(n)
	public static int countJumps(int X) {
		int sum = 0;
		int jump = 0;
		int i = 0;
		for (i = 1; sum < X; i++) {
			sum = sum + i;
			jump++;
		}
			if (sum == X) {
				return jump;
			} else {
				//If diff between actual target and target we reach is even
				if ((sum - X)%2 == 0) {
					return jump;
				}
				//If diff is odd then take one more jump
				else {
					sum = sum + i;
					//If now the diff is even after taking one more jump
					if ((sum - X)%2 == 0) {
						return jump + 1;
					}
					//If again the diff is odd then definitely in next jump it becomes even
					else {
						return jump+2;
					}
				}
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countJumps(8));
	}

}
