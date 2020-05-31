package arraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels_763 {
	public static List<Integer> partitionLables(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		for (char c : map.keySet()) {
			System.out.println(c + " " + map.get(c));
		}
		
		List<Integer> list = new ArrayList<Integer>();
		int j = 0;
		int end = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			end = Math.max(end, map.get(s.charAt(i)));
			if (i == end) {
				list.add(i-j+1);
				j = end + 1;
			}
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababcbacadefegdehijhklij";
		System.out.println(partitionLables(s));
	}

}
