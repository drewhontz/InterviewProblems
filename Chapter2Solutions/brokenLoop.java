import java.util.LinkedList;

public class brokenLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int brokenLoopFunc(LinkedList<Integer> cl){
		//create int[size 2] size
		//create a hashTable that stores the unique ref of each node
		//iterate from node to node adding the value to the hashset
		//look up each value to see if it exists
		//when it does exist add the to the array, mark the value, reset counter, and continue
		//when you get to this marked index again, compare the counters
		//if they are the same, you have a perfect loop,
		//if they are different, the difference indicates the index of the looped node
		return -1;
	}

}
