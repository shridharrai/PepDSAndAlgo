package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_119 {
	//O(n^2)
	public static List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		for (int i = 2; i <= rowIndex; i++) {
			for (int j = list.size()-1; j >= 1; j--) {
				int ele = list.remove(j);
				list.add(j, list.get(j-1) + ele);
			}
			list.add(1);
//			System.out.println(list);
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(4));
	}

}
