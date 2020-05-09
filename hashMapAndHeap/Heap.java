package hashMapAndHeap;

import java.util.ArrayList;

public class Heap {
ArrayList<Integer> data = new ArrayList<>();
	
	public void add (int item) {
		data.add(item);
		upheapify(data.size() - 1);
	}

	private void upheapify(int ci) {
		// TODO Auto-generated method stub
		int pi = (ci-1) / 2;
		if (data.get(ci) > data.get(pi)) {  //Considering max heap
			swap(pi, ci);
			upheapify(pi);
		}
	}
	
	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		
		data.set(i, jth);
		data.set(j, ith);
	}
	
	public void display() {
		System.out.println(data);
	}
	
	public int remove() {
		swap(0, this.data.size()-1);
		int rv = this.data.remove(this.data.size() - 1);
		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {
		// TODO Auto-generated method stub
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		
		int mini = pi;
		
		if (lci < this.data.size() && data.get(lci) > data.get(mini)) {
			mini = lci;
		}
		if (rci < this.data.size() && data.get(rci) > data.get(mini)) {
			mini = rci;
		}
		
		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}
	}
	
	public int get() {  //Gives the highest priority element
		return this.data.get(0);
	}
}
