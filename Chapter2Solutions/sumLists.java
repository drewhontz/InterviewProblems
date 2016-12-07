import java.util.Iterator;
import java.util.LinkedList;

public class sumLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.addFirst(6);
		l1.addFirst(1);
		l1.addFirst(7);
		
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.addFirst(2);
		l2.addFirst(9);
		l2.addFirst(5);
		
		LinkedList<Integer> result = new LinkedList<Integer>();
		result = sumListFunc(l1,l2);
		Iterator<Integer> itr = result.iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	
	public static LinkedList<Integer> sumListFunc(LinkedList<Integer> l1, LinkedList<Integer> l2){
		sanitizeLists(l1,l2);
		Iterator<Integer> itr1 = l1.iterator();
		Iterator<Integer> itr2 = l2.iterator();
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		int carry = 0;
		while (itr1.hasNext() && itr2.hasNext()){
			int e = itr1.next() + itr2.next() + carry;
			if (e > 10){
				carry = 1;
				result.add(e % 10);
			} else {
				carry = 0;
				result.add(e);
			}
		}
		trimBuffer(result);
		return result;
	}
	
	public static void sanitizeLists(LinkedList<Integer> l1, LinkedList<Integer> l2){
		//Make lists the same size and add a buffer at the end
		//Find the larger list and add a zero
		//add zeros to shorter list until size ==
		LinkedList<Integer> larger = (l1.size() >= l2.size()) ? l1 : l2;
		LinkedList<Integer> smaller = (l1.size() <= l2.size()) ? l1 : l2;
		larger.addLast(0);
		while (smaller.size() != larger.size()) smaller.addLast(0);
	}
	
	public static void trimBuffer(LinkedList<Integer> l){
		//trims linkedList with 0 at tail
		int tail = l.size() - 1;
		if (l.get(tail) == 0) l.remove(tail);
	}

}
