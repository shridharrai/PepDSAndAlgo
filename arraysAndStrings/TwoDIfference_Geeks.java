package arraysAndStrings;

import java.util.Arrays;

public class TwoDIfference_Geeks {
	//O(nlogn)
	public static boolean findPair(int arr[],int diff) {
		int i = 0;
		int j = arr.length-1;
		Arrays.sort(arr);
		while (i < arr.length && j < arr.length) {
			if ((arr[j] - arr[i]) < diff) {
				j++;
			} else if ((arr[j] - arr[i]) > diff) {
				i++;
			} else {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 20, 3, 2, 50, 80};
		int diff = 78;
		System.out.println(findPair(arr, diff));
	}

}
