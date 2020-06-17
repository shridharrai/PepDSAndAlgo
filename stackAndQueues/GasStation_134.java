package stackAndQueues;

public class GasStation_134 {
	//O(n)
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int startidx = 0;
		int totalcost = 0;
		int totalgas = 0;
		int prefixsum = 0;
		for (int i = 0; i < gas.length; i++) {
			prefixsum = prefixsum + (gas[i]-cost[i]);
			if (prefixsum < 0) {
				prefixsum = 0;
				startidx = i+1;
			}
			totalcost = totalcost+cost[i];
			totalgas = totalgas+gas[i];
		}
		
		if (totalgas-totalcost >= 0) {
			return startidx;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = {2,3,4};
		int[] cost = {3,4,3};
		System.out.println(canCompleteCircuit(gas, cost));
	}

}
