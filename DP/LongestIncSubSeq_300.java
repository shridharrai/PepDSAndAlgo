package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LongestIncSubSeq_300 {
	
	static int lisRec(int arr[], int i, int n, int prev) {
		if (i == n) {
			return 0;
		}
		//exclude the current element
		int excl = lisRec(arr, i+1, n, prev);
		//include the current element in LIS
		int incl = 0;
		if (arr[i] > prev) {
			incl = 1 + lisRec(arr, i+1, n, arr[i]);
		}
		
		return Math.max(excl, incl);
	}
	
	//O(n^2)
	static int lisDp(int arr[],int n) {
		int[] lis = new int[n];
		String[] paths = new String[n];
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
			paths[i] = arr[i] + " ";
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
					paths[i] = paths[j] + arr[i] + " ";
					if (max < lis[i]) {
						max = lis[i];
					}
				}
			}
		}
		
		
		for (int i = 0; i < lis.length; i++) {
			if (lis[i] == max) {
				System.out.println("LIS : "+ paths[i]);
			}
		}
		return max;
	}
	
	//In O(nlogn)
	public static int LISdp(int arr[]) {
		int increasingsub[] = new int[arr.length];
		int parent[] = new int[arr.length + 1];
		int length = 0;
		
		for (int i = 0; i < arr.length; i++) {
			//Binary Search
			int low = 1;
			int high = length;
			while (low <= high) {
				int mid = (int) Math.ceil((low+high)/2);
				if (arr[increasingsub[mid]] > arr[i]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			int pos = low;
			parent[i] = increasingsub[pos-1];
			increasingsub[pos] = i;
			
			if (length < pos) {
				length = pos;
			}
		}
		
		//Generate LIS from parent array
		int LIS[] = new int[length];
		int k = increasingsub[length];
		for (int i = length-1; i >= 0; i--) {
			LIS[i] = arr[k];
			k = parent[k];
		}
		
		for (int i = 0; i < LIS.length; i++) {
				System.out.println(LIS[i]);
		}
		
		return length;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = { 4, 10, 3, 13, 7, 11, 12 }; 
		int arr[] = { 4, 3, 2, 1 }; 
        int n = arr.length; 
        System.out.println("Length of lis is " + LISdp(arr) + "\n" );
        System.out.println("LIS Recursive call length "+ lisRec(arr, 0, n, Integer.MIN_VALUE));
	}

}
