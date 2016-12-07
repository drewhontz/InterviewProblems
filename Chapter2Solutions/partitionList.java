import java.util.Iterator;
import java.util.LinkedList;

public class partitionList {

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(3);
		l.add(5);
		l.add(8);
		l.add(5);
		l.add(10);
		l.add(2);
		l.add(1);
		
		Iterator<Integer> itr = l.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next());
		}
		
		l = partitionFunc(l, 5);
		itr = l.iterator();
		while (itr.hasNext()){
			int val = itr.next();
			System.out.println(val);
		}
	}
	
	public static LinkedList<Integer> partitionFunc(LinkedList<Integer> l, int i){
		Iterator<Integer> it = l.iterator();
		LinkedList<Integer> small = new LinkedList<Integer>();
		LinkedList<Integer> large = new LinkedList<Integer>();
		while (it.hasNext()){
			int e = it.next();
			if (e < i) {
				small.add(e);
			} else {
				large.add(e);
			}
		}
		small.addAll(large);
		return small;
	}
}
