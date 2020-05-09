package hashMapAndHeap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RabbitsInForest_781 {
	public static int numRabbits(int[] answers) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int answer : answers) {
			map.put(answer, map.getOrDefault(answer, 0) + 1);
		}
		
//		int total =  0;
//		for (Integer key : map.keySet()) {
//			Integer value = map.get(key);
//			if (key > value) {
//				total = total + key + 1;
//			}
//			else if (value % (key + 1) == 0) {
//				total = total + value;
//			}
//			else {
//				int groups = value/(key+1);
//				total = total + (((groups)*(key+1)) + (key+1));
//			}
//		}
		int total = 0;
		for (Integer groupSize : map.keySet()) {
			int countOfRabbits = map.get(groupSize);
			int countOfGroup = (int) Math.ceil((double)countOfRabbits/(groupSize+1));
			total = total + ((groupSize+1)*countOfGroup);
		}
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 10, 10};
		System.out.println(numRabbits(arr));
	}

}
