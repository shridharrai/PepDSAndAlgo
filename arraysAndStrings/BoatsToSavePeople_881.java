package arraysAndStrings;

import java.util.Arrays;

public class BoatsToSavePeople_881 {
	//O(nlogn)
	public static int numRescueBoats(int[] people, int limit) {
		int i = 0;
		int j = people.length - 1;
		int ans = 0;
		Arrays.sort(people);
		while (i <= j) {
			if (people[i] + people[j] <= limit) {
				ans++;
				i++;
				j--;
			} else {
				ans++;
				--j;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,2,1};
		int limit = 3;
		System.out.println(numRescueBoats(arr, limit));
	}

}
