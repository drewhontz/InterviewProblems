import java.util.HashSet;

public class removeDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(3);
		Node n1 = new Node(4);
		Node n2 = new Node(65);
		Node n3 = new Node(4);
		Node n4 = new Node(23);
		Node n5 = new Node(76);
		Node n6 = new Node(65);
		n.setNext(n1);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(null);
		
		System.out.println("Before: \n");
		while (n.getNext() != null){
			System.out.println(n.getData());
			n = n.getNext();
		}
		removeDuplicatesFunc(n);
		
		System.out.println("\n After: \n");
		while (n.getNext() != null){
			System.out.println(n.getData());
			n = n.getNext();
		}
	}
	
	public static void removeDuplicatesFunc(Node n){
		HashSet<Integer> t = new HashSet<Integer>();
		//fixme
		Node prev = n;
		n = n.next;
		while (n.getNext() != null){
			if (t.contains(n.getData())){
				prev.setNext(n.getNext());
			} else {
				t.add(n.getData());
				prev = n;
			}
			n = n.getNext();
		}
		
	}

}
