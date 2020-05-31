package arraysAndStrings;

import java.util.Arrays;

public class MinNoOfPlatforms_Geeks {
	//O(nlogn)
	public static int findPlatform(int arr[], int dep[]) {
		int i = 0;
		int j = 0;
		int cplat = 0;
		int wplat = Integer.MIN_VALUE;
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		while (i < arr.length) {
			if (arr[i] < dep[j]) {
				cplat++;
				i++;
			} else {
				cplat--;
				j++;
			}
			wplat = Math.max(cplat, wplat);
		}
		return wplat;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 }; 
	    int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
	    System.out.println(findPlatform(arr, dep));
	}

}
