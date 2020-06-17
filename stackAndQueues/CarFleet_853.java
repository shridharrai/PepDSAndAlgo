package stackAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CarFleet_853 {
	private class Pair implements Comparable<Pair> {
		private int position;
		private int speed;
		private double time;
		public int getPosition() {
			return position;
		}
		public void setPosition(int position) {
			this.position = position;
		}
		public int getSpeed() {
			return speed;
		}
		public void setSpeed(int speed) {
			this.speed = speed;
		}
		public double getTime() {
			return time;
		}
		public void setTime(double time) {
			this.time = time;
		}
		@Override
		public String toString() {
			return "Pair [position=" + position + ", speed=" + speed + ", time=" + time + "]";
		}
		public Pair(int position, int speed, double time) {
			super();
			this.position = position;
			this.speed = speed;
			this.time = time;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.position - o.position;
		}
	}
	public int carFleet(int target, int[] position, int[] speed) {
		double[] time = new double[position.length];
		Pair[] arr = new Pair[position.length];
 		
		for (int i = 0; i < time.length; i++) {
			time[i] = (double)(target-position[i])/speed[i];
		}
//		for (int i = 0; i < time.length; i++) {
//			System.out.print(time[i] + " ");
//		}
		for (int i = 0; i < position.length; i++) {
			Pair pair = new Pair(position[i], speed[i], time[i]);
			arr[i] = pair;
		}
		Arrays.sort(arr);
		int fleetcount = 1;
		double mintime = arr[arr.length-1].getTime();
		System.out.println(mintime);
		for (int i = arr.length-2; i >= 0; i--) {
			if (arr[i].getTime() > mintime) {
				fleetcount++;
				mintime = arr[i].getTime();
			}
		}
		return fleetcount;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] position = {10,8,0,5,3};
		int[] speed = {2,4,1,1,3};
		int target = 12;
		CarFleet_853 car = new CarFleet_853();
		System.out.println(car.carFleet(target, position, speed));
	}

}
