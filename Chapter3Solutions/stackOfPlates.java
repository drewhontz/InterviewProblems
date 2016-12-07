import java.util.Stack;

public class stackOfPlates {
	@SuppressWarnings("rawtypes")
	Stack<Stack> master = new Stack<Stack>();
	Stack<Integer> container = new Stack<Integer>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@SuppressWarnings("unchecked")
	public void push(int i){
		if (this.isFull()){
			Stack<Integer> s = new Stack<Integer>();
			this.master.push(s);
		}
		this.master.peek().push(i);
	}
	
	public void pop(){
		if (this.isEmpty()){
			this.master.pop();
		}
		this.master.peek().pop();
	}
	
	public boolean isFull(){
		return (this.master.peek().size() > 3);
	}
	
	public boolean isEmpty(){
		return (this.master.peek().isEmpty());
	}

}
