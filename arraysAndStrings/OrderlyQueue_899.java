package arraysAndStrings;

public class OrderlyQueue_899 {
	public static String orderlyQueue(String S, int K) {
		char[] arr = S.toCharArray();
		if (K == 1) {
			String ans = S;
			int len = S.length();
			for (int i = 0; i < len-1; i++) {
				S = S.substring(1, S.length()) + S.substring(0, 1);
//				System.out.println("String is "+S);
				if (S.compareTo(ans) < 0) {
					ans = S;
				}
			}
//			System.out.println("Ans is "+ans);
			return ans;
		}
		
		//BubbleSort(nlogn)
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int j = 0; j < arr.length - 1 -counter; j++) {
				if (arr[j] > arr[j+1]) {
					char temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		String s = new String(arr);
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "baaca";
		int k = 3;
//		orderlyQueue(s, k);
		System.out.println(orderlyQueue(s, k));
	}

}
