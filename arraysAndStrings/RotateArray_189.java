package arraysAndStrings;

public class RotateArray_189 {
	//O(n)
	public static int[] rotate(int[] nums, int k) {
		int length = nums.length;
		if (length < k) {
            k = k % length;
        }
        if(k < 0) {
            k = k + length;
        }
		reverse(length-k, length-1, nums);
		reverse(0, length-k-1, nums);
		reverse(0, length-1, nums);
		return nums;
	}
	
	public static void reverse(int startidx, int endidx, int[] arr) {
		while (startidx < endidx) {
			int temp = arr[endidx];
			arr[endidx] = arr[startidx];
			arr[startidx] = temp;
			endidx--;
			startidx++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		int[] reversed = rotate(nums, k);
		for (int i = 0; i < reversed.length; i++) {
			System.out.println(reversed[i]);
		}
	}

}
