
public class returnNth {
	public static void main(String[] args){
		Node n = new Node(3);
		Node n1 = new Node(4);
		Node n2 = new Node(65);
		Node n3 = new Node(34);
		Node n4 = new Node(23);
		Node n5 = new Node(76);
		Node n6 = new Node(231);

		n.setNext(n1);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(null);
		
		returnNthFunc(n, 4);
		returnNthFunc(n, 2);
		returnNthFunc(n, 1);
		

	}
	
	public static int returnNthFunc(Node n, int t){
		int count = 0;
		if (n.next == null){
			
			return 0;
		}
		count = returnNthFunc(n.getNext(), t) + 1;
		if (count == t) System.out.printf("Value at nth position is %d\n", n.getData());
		return count;
	}
}
