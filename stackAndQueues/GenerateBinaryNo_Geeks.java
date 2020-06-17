package stackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNo_Geeks {
	//O(n)
	public static void generateNo(int n) {
		Queue<String> queue = new LinkedList<String>();
		queue.add("1");
		int count = 0;
		while (count < n) {
			String s = queue.poll();
			System.out.println(s);
			count++;
			queue.add(s + "0");
			queue.add(s + "1");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		generateNo(n);
	}

}
