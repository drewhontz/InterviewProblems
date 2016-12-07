import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

public class intersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l1, l2;
		l1 = new LinkedList<Integer>();
		l2 = new LinkedList<Integer>();
		ListIterator<Integer> itr;
		int n = 100;
		
		l1.add(1);
		l1.add(3);
		l1.add(n);
		l1.add(10);
		l1.add(4);
		l1.add(4);
		l1.add(4);
		
		l2.add(1);
		l2.add(3);
		l2.add(10);
		l2.add(4);
		l2.add(4);
		l2.add(n);
		l2.add(4);

		itr = l1.listIterator();
		int i = 0;
		while (itr.hasNext()){
			// find a better way to find an obj in mem int 
			int ref = 1; 
			System.out.printf("list 1 HC at index %d : %d \n", i, ref);
			i++;
		}
		
		i=0;
		itr = l2.listIterator();
		while (itr.hasNext()){
			int ref2 = System.identityHashCode(itr.next());
			System.out.printf("list 2 HC at index %d : %d \n", i, ref2);
			i++;
		}
		
	}
	
	public static Integer findIntersection(LinkedList<Integer> l1, LinkedList<Integer> l2){
		// find the shorter list
		// iterate through adding each element to a hash table
		// when done, iterate through the second list
		// at each value check to see if the reference exists in the hash table
		// if so we know that there is at least one point of intersection
		
		LinkedList<Integer> shorter = (l1.size() <= l2.size()) ? l1 : l2;
		LinkedList<Integer> larger  = (l1.size() > l2.size()) ? l1 : l2;		
		ListIterator<Integer> itr = shorter.listIterator();
		HashSet<Integer> objRef = new HashSet<Integer>();
		
		while (itr.hasNext()){
			int cur1 = itr.next();
			int ref = System.identityHashCode(cur1);
			objRef.add(ref);
		}
		
		ListIterator<Integer> itr2 = larger.listIterator();
		while (itr2.hasNext()){
			int cur2 = itr2.next();
			int ref2 = System.identityHashCode(cur2);
			if (objRef.contains(ref2)) return cur2;
		}
		return -1;
	}

}
