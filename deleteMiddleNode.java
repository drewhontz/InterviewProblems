
public class deleteMiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node tail = new Node();
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
		n6.setNext(tail);
		
		deleteMiddleNodeFunc(n4);
		
		System.out.println("After:");
		while (n.getNext() != null){
			System.out.println(n.getData());
			n = n.getNext();
		}
	}
	
	public static void deleteMiddleNodeFunc(Node n){
		n.setData(n.getNext().getData());
		n.setNext(n.getNext().getNext());
	}
}
