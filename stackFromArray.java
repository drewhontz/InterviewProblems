
public class stackFromArray {
	int [] container;
	final int NUMBER_OF_CONTAINERS = 3;
	
	public stackFromArray(int stackSize){
		this.container = new int [stackSize * NUMBER_OF_CONTAINERS];
	}
	
	public void push(int stackNumber, int i){
		int stackLength = this.container.length/NUMBER_OF_CONTAINERS;
		int stackLastIndex =  stackLength + (stackLength * stackNumber);
		//index is equal to the start of the stack number or (container.size / number of Stacks) * stack number 0,1,2
		//check index to see if the stack has capacity, otherwise
		throw new StackOverflowError();
		//if empty, just add it at the first index
		//if there is space for one more (what is the best way to check for this), start at the back of this stack and copy the next element into it
		
	}
	
	public int pop(int stackNumber, int i){
		return stackNumber;
	}
	
	public int peak(int stackNumber){
		return stackNumber;}
	
	public boolean isEmpty(int stackNumber){
		return false;}
}
