package searchingAndSorting;

public class MedianOfTwoSortedArrays_4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length <= nums2.length) {
			return median(nums1, nums2);
		} else {
			return median(nums2, nums1);
		}
	}
	
//	O(log(min(nums1.length, nums2.length)))
	public double median(int[] nums1, int[] nums2) {
		int groupLength = (nums1.length + nums2.length + 1)/2;
		int i1 = 0;
		int j1 = nums1.length+1;
		double ans = 0;
		
		while (i1 <= j1) {
			int mid1 = (i1+j1)/2;
			int mid2 = groupLength-mid1;
			if ((mid1>=0 && mid1<nums1.length && mid2-1>=0) && (nums1[mid1] < nums2[mid2-1])) {
				i1 = mid1+1;
			} else if ((mid2>=0 && mid2<nums2.length && mid1-1>=0) && (nums1[mid1-1] > nums2[mid2])) {
				j1 = mid1-1;
			} else {
				if ((nums1.length + nums2.length)%2 == 0) {
					int max1 = 0, min1 = 0;
					if(mid1-1>=0 && mid2-1>=0) {
						max1 = Math.max(nums1[mid1-1], nums2[mid2-1]);
					} else if (mid1-1>=0) {
						max1 = nums1[mid1-1];
					} else{
						max1 = nums2[mid2-1];
					}
					
					if (mid1>=0 && mid1<nums1.length && mid2>=0 && mid2<nums2.length) {
						min1 = Math.min(nums1[mid1], nums2[mid2]);
					} else if (mid1>=0 && mid1<nums1.length) {
						min1 = nums1[mid1];
					} else {
						min1 = nums2[mid2];
					}
						ans = (double)(max1+min1)/2.0;
						return ans;
				} else {
					if (mid1-1>=0 && mid2-1>=0) {
						ans = Math.max(nums1[mid1-1], nums2[mid2-1]);
						return ans;
					} else if (mid2-1>=0) {
						ans = nums2[mid2-1];
						return ans;
					} else {
						ans = nums2[mid1-1];
						return ans;
					}
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianOfTwoSortedArrays_4 arr = new MedianOfTwoSortedArrays_4();
		int[] nums1 = {3};
		int[] nums2 = {-2,-1};
		System.out.println(arr.findMedianSortedArrays(nums1, nums2));
	}

}
