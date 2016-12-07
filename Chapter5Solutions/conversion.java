public class conversion{
	
	/* Counts the number of bits that need to change for 2 ints
	* to be equal */

	public static void main (String[] args){
		System.out.println(countChanges(29,15));
		System.out.println(countChanges(221,209)); //should be 2
	}

	/* Returns the count of 1s in the XOR of a, b */
	public static int countChanges(int a, int b){
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}
}