public class flipBitToWin {
	public static void main (String[] args) {
		int n = 1775;
		System.out.println(returnHighestCont(n)); // should be 8
		n = 0;
		System.out.println(returnHighestCont(n)); // should be 1
		n = 255;
		System.out.println(returnHighestCont(n)); // should be 1
	}

	public static int returnHighestCont(int n) {
		/*Iterate through n
		*	if n[i] == count++
		*	if n[i] == 0
		*		S.add(count)
		*		count = 0;
		* when n is complete, while s != empty
		* s.pop + s.peek = max
		* if s.pop + s.peek > max max = new max
		* return max + 1
		*/
		String ar = Integer.toString(n, 2);
		int length = ar.length();
		int count = 0;
		int prevCount = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < length; i++){
			if (ar.charAt(i) == '1'){
				count++;
			} else {
				if ((count + prevCount) > max) max = count + prevCount;
				prevCount = count;
				count = 0;
			}
		}
		//if string is all 1s, return length of string
		if (count == length) return length;
		//if string ends in series of 1s, it will not be counted
		if ((count + prevCount) > max) return (count + prevCount + 1);
		//otherwise, return max sequence + 1
		return max + 1;
	}
}