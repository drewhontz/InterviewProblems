import java.util.LinkedList;
import java.util.ListIterator;

public class Deviation {
	
	public static void main(String[] args){
		int[] n = {6,9,4,7,4,1};
		int d = 3;
		System.out.println(deviation(n,d));
	}

	public static int deviation(int[] n, int d){
		LinkedList<Integer> window = new LinkedList<Integer>();
		int median, temp, i, j;

		//Set initial window and max
		for (i = 0; i < d; i++){
			window.add(n[i]);
		}
		median = getLinkedListMedian(window);

		//Set right bound of window to j
		j = d;

		/* Add element at [j]. Window should now consist of elements 0 - d (inclusive)
		* Remove first element so window is d elements in length
		* Find the median; update median if new differential is greater
		*/
		while (j < n.length){
			window.add(n[j]);
			window.removeFirst();
			temp = getLinkedListMedian(window);
			if (temp > median) median = temp;
			j++;
		}
		return median;
	}

	public static int getLinkedListMedian(LinkedList<Integer> w){
		int min, max, median;
		min = findMin(w);
		max = findMax(w);
		median = max - min;
		return median;
	}

	public static int findMax(LinkedList<Integer> n){
		ListIterator<Integer> itr = n.listIterator();
		int max = Integer.MIN_VALUE;
		while (itr.hasNext()){
			int val = itr.next();
			if (val > max) max = val;
		}
		return max;
	}

	public static int findMin(LinkedList<Integer> n){
		ListIterator<Integer> itr = n.listIterator();
		int min = Integer.MAX_VALUE;
		while (itr.hasNext()){
			int val = itr.next();
			if (val < min) min = val;
		}
		return min;
	}
}