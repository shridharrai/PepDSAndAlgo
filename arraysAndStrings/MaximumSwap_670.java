package arraysAndStrings;

public class MaximumSwap_670 {
	//O(n)
	public static int maximumSwap(int num) {
		String s = Integer.toString(num);
		char[] arr = s.toCharArray();
		int max = 0;
		int idx1 = -1;
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i+1] > arr[i]) {
				max = arr[i+1];
				idx1 = i+1;
				for (int j = i+2; j < arr.length; j++) {
					if (arr[j] >= max) {
						max = arr[j];
						idx1 = j;
					}
				}
				break;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < max) {
				int temp = arr[idx1];
				arr[idx1] = arr[i];
				arr[i] = (char) temp;
				break;
			}
		}
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
		return Integer.parseInt(new String(arr));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 9973;
		System.out.println("Number is "+maximumSwap(num));
	}

}
