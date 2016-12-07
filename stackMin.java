import java.util.Stack;

public class stackMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int returnStackMin(Stack<NodeWithMin> s){
		return s.peek().getMin();
	}
	
	public void push(Stack<NodeWithMin> s, NodeWithMin n){
		if (n.getData() < s.peek().getMin()) {
			n.localMin = n.getData();
		} else {
			n.localMin = s.peek().getMin();
		}
		s.push(n);
	}

	public class NodeWithMin {
		
		int data;
		int localMin;
		
		public NodeWithMin (int v){
			this.data = v;
		}
		
		public int getData(){
			return this.data;
		}
		
		public int getMin(){
			return this.localMin;
		}
	}

}