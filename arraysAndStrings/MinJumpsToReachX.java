package arraysAndStrings;

public class MinJumpsToReachX {
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
				if ((sum - X)%2 == 0) {
					return jump;
				} else {
					sum = sum + i;
					if ((sum - X)%2 == 0) {
						return jump + 1;
					} else {
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
