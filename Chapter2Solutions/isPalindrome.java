import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class isPalindrome {

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.push(1);
		l.push(2);
		l.push(1);
		l.push(1);
		l.push(2);
		l.push(1);
		
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.push(10);
		l2.push(20);
		l2.push(1);
		l2.push(1);
		l2.push(20);
		l2.push(100);
		
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		l3.push(10);
		l3.push(20);
		l3.push(1);
		l3.push(1000);
		l3.push(1);
		l3.push(20);
		l3.push(10);
		
		System.out.println(isPalindromeList(l));
		System.out.println(isPalindromeList(l2));
		System.out.println(isPalindromeList(l3));
	}
	
	public static boolean isPalindromeList (LinkedList<Integer> l){
		int size = l.size();
		int count = 0;
		Iterator<Integer> itr = l.iterator();
		Stack<Integer> s = new Stack<Integer>();

		while (count < size/2){
			s.push(itr.next());
			count++;
		}
		
		if (size % 2 != 0) itr.next();
		
		while (itr.hasNext()){
			if (s.pop() != itr.next()) return false;
		}
		return true;
	}
}
