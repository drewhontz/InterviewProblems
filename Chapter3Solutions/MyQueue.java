import java.util.Stack;

public class MyQueue {
	Stack<Integer> stackNew, stackOld;
	
	public MyQueue(){
		this.stackNew = new Stack<Integer>();
		this.stackOld = new Stack<Integer>();
	}
	
	public void add(int i){
		this.stackNew.push(i);
	}
	
	public void shifter(){
		if (stackOld.isEmpty()){
			while (!stackNew.isEmpty()){
				stackOld.push(stackNew.pop());
			}
		}
	}
	
	public void remove(){
		this.shifter();
		this.stackOld.pop();
	}
	
	public int peek(){
		this.shifter();
		return this.stackOld.peek();
	}
}
