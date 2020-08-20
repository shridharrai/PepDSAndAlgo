package trees;

import java.util.Scanner;


public class SquareRootDecomposition_Spoj {
	//O(sqrt(n))
	public int findSum(int[] arr, int i, int j) {
		int n = arr.length;
		int size = (int) Math.ceil(Math.sqrt(n));
		System.out.println("Size is "+size);
		int[] pointerarr = new int[size];
		
		for (int k = 0; k < arr.length; k++) {
			int sum = pointerarr[k/size];
			pointerarr[k/size] = sum+arr[k];
		}
		
		for (int k = 0; k < pointerarr.length; k++) {
			System.out.println(pointerarr[k]);
		}
		
		int ans = 0;
		while (i <= j) {
			if (i%size == 0) {
				if ((i+size-1) <= j) {
					ans = ans + pointerarr[i/size];
					i = i+size;
				} else {
					ans = ans + arr[i];
					i++;
				}
			} else {
				ans = ans + arr[i];
				i++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {2,6,-1,3,1,-2,4,8,7,-7,6,-5,3,2,1,-6,3,2,0,5};
		SquareRootDecomposition_Spoj obj = new SquareRootDecomposition_Spoj();
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		scn.nextLine();
	    String data = scn.nextLine();
	    String tmpDataArray[] = data.split(" ");
	    int dataArray[] = new int[tmpDataArray.length];
	      for (int i = 0; i < dataArray.length; ++i) {
	          dataArray[i] = Integer.parseInt(tmpDataArray[i]);
	      }
	      for (int i = 0; i < dataArray.length; i++) {
				System.out.println(dataArray[i]);
			}
		int Q = scn.nextInt();
		scn.nextLine();
		for (int k = 0; k < Q; k++) {
			String Queries = scn.nextLine();
			String tempQuery[] = Queries.split(" ");
			int i = Integer.parseInt(tempQuery[0]);
			int j = Integer.parseInt(tempQuery[1]);
			System.out.println("i is "+i+" j is "+j);
			System.out.println("Sum is "+obj.findSum(dataArray, i, j));
		}
	}

}
