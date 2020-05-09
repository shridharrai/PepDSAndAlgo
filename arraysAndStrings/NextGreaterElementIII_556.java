package arraysAndStrings;

public class NextGreaterElementIII_556 {
	//O(n)
	public static int nextGreaterElement(int n) {
		String s = Integer.toString(n);
		char[] arr = s.toCharArray();
		int dipidx = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > arr[i-1]) {
				dipidx = i-1;
				break; 
			}
		}
		if (dipidx == 0) {
			return -1;
		}
//		System.out.println("First dip is "+dipidx);
		int justGreater = dipidx+1;
		for (int i = dipidx+2; i < arr.length; i++) {
			if (arr[i] > arr[dipidx]) {
				if (arr[i] <= arr[justGreater]) {
					justGreater = i;
				}
			}
		}
//		System.out.println("Just greater value is "+arr[justGreater]);
		swap(dipidx, justGreater, arr);
		int startidx = dipidx + 1;
		int endidx = arr.length-1;
		while (startidx < endidx) {
			swap(startidx, endidx, arr);
			startidx++;
			endidx--;
		}
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		return Integer.parseInt(new String(arr));
	}
	
	public static void swap(int i, int j, char[] arr) {
		char temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ele is "+nextGreaterElement(12347653));
	}

}
