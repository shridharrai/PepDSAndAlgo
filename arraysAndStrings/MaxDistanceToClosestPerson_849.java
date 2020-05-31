package arraysAndStrings;

public class MaxDistanceToClosestPerson_849 {
	//O(n)
	public static int maxDistToClosest(int[] seats) {
		int idx = -1;
		int maxdist= Integer.MIN_VALUE;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				//Placing at firstidx
				if (idx == -1) {
					maxdist = Math.max(maxdist, i - 0);
					idx = i;
				} 
				//Placing in between
				else {
					int tempidx = (i+idx)/2;
					maxdist = Math.max(maxdist, tempidx-idx);
					idx = i;
				}
			}
		}
		//Placing at lastidx
		return Math.max(maxdist, (seats.length-1)-idx);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0,0,0};
		System.out.println(maxDistToClosest(arr));
	}

}
